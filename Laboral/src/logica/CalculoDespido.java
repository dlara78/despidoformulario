package logica;

import java.util.GregorianCalendar;

public class CalculoDespido {

    final float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);
    final GregorianCalendar fechaReforma = new GregorianCalendar(2012, 1, 12, 0, 0, 0);
    String tipoDespido;
    String informe;
    GregorianCalendar fechaAlta;
    GregorianCalendar fechaBaja;
    float baseCotizacion;
    float diasCotizados;
    float baseCotizDiaria;

    int diasTrabajadosAntesReforma;
    int diasTrabajadosDespuesReforma;
    float diasIndemnAntesReforma;
    float diasIndemnDespuesReforma;
    float eurosIndemnAntesReforma;
    float eurosIndemnDespuesReforma;

    float diasIndemnTOTAL;
    float eurosIndemnTOTAL;
    int diasTrabajadosTOTAL;

    String textoControl1 = "";
    String textoControl2 = "No hay más incidencias.";
    String textoControl3 = "";

    String textoExtraAntiguedad = "";
    String textoExtraDiasIndemn = "";
    String textoExtraEurosIndemn = "";

    public String getInforme() {
        return informe;
    }

    public CalculoDespido(
            String tipoDespido, //Tipo de despido
            GregorianCalendar fechaAlta, //Fecha de alta en la empresa
            GregorianCalendar fechaBaja, //Fecha de baja en la empresa
            float baseCotizacion, //Base de cotización comunicada
            float diasCotizados) {          //Dias correspondientes a la base de cotización

        this.tipoDespido = tipoDespido;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.baseCotizacion = baseCotizacion;
        this.diasCotizados = diasCotizados;
        this.baseCotizDiaria = baseCotizacion / diasCotizados;

        GregorianCalendar fechaInforme = new GregorianCalendar(); //Fecha del informe
        int antiguedadTotal = logica.Fechas.difFechas(this.fechaAlta, this.fechaBaja);
        final float topeImproced45dias = 1260f;
        final float topeImproced33dias = 720f;
        final float diasIndemnizables45 = 45f / 365f;
        final float diasIndemnizables33 = 33f / 365f;
        final float diasIndemnizable20 = 20f / 365f;


        /*
         Comienza la preparación del informe.
         */
        if ("Despido improcedente".equals(tipoDespido)) {

            if (this.fechaBaja.getTimeInMillis() < this.fechaReforma.getTimeInMillis()) {
                /*
                 Este primer if es en caso de que la relación laboral sucediese integramente
                 antes de la reforma laboral. #CORRECTO.
                 */
                this.diasTrabajadosAntesReforma = Fechas.difFechas(this.fechaAlta, this.fechaBaja);
                this.diasTrabajadosDespuesReforma = 0;
                this.diasIndemnAntesReforma = (float) this.diasTrabajadosAntesReforma * diasIndemnizables45;
                if (this.diasIndemnAntesReforma > topeImproced45dias) {
                    this.textoControl1 = "TOPADO";
                    this.diasIndemnAntesReforma = topeImproced45dias;
                }
                this.diasIndemnDespuesReforma = 0;
                this.diasIndemnTOTAL = this.diasIndemnAntesReforma;

            } else if (this.fechaAlta.getTimeInMillis() >= this.fechaReforma.getTimeInMillis()) {
                /* 
                 Este segundo if es en caso de que la relación laboral sucediese integramente
                 despues de la reforma laboral.  #CORRECTO.
                 */
                this.diasTrabajadosAntesReforma = 0;
                this.diasTrabajadosDespuesReforma = Fechas.difFechas(this.fechaAlta, this.fechaBaja);
                this.diasIndemnAntesReforma = 0;
                this.diasIndemnDespuesReforma = (float) this.diasTrabajadosDespuesReforma * diasIndemnizables33;
                if (this.diasIndemnDespuesReforma > topeImproced33dias) {
                    textoControl1 = "TOPADO";
                    this.diasIndemnDespuesReforma = topeImproced33dias;
                }

                this.diasIndemnTOTAL = this.diasIndemnDespuesReforma;

            } else {
                /*
                 El siguiente tramo es cuando la antigüedad es afectada por los dos tramos.
                 El límite son 720dias de salario, salvo que del cálculo del periodo
                 anterior a la fechaReforma resultasen más días. En ese caso, la indemnización
                 resultante (de entre 720d y 1260d) sería la máxima aplicable, desechando 
                 la indemnización del periodo posterior a la fechaReforma.
                 */

                this.textoControl3 = "\nTramo mixto";

                this.diasTrabajadosAntesReforma = Fechas.difFechas(this.fechaAlta, this.fechaReforma);
                this.diasTrabajadosDespuesReforma = Fechas.difFechas(this.fechaReforma, this.fechaBaja);
                this.diasIndemnAntesReforma = this.diasTrabajadosAntesReforma * diasIndemnizables45;
                this.diasIndemnDespuesReforma = this.diasTrabajadosDespuesReforma * diasIndemnizables33;

                if (this.diasIndemnAntesReforma >= 1260) {

                    this.textoControl2 = "(Periodo 2 descartado. Tope 42m alcanzado.)";
                    this.diasIndemnAntesReforma = 1260;
                    this.diasIndemnDespuesReforma = 0;
                    this.diasIndemnTOTAL = this.diasIndemnAntesReforma;

                } else if ((this.diasIndemnAntesReforma >= 720f) && (this.diasIndemnAntesReforma < 1260f)) {

                    this.textoControl2 = " (Periodo 2 descartado. Tope 42m no alcanzado)";
                    this.diasIndemnAntesReforma = (float) this.diasTrabajadosAntesReforma * diasIndemnizables45;
                    this.diasIndemnDespuesReforma = 0;
                    this.diasIndemnTOTAL = this.diasIndemnAntesReforma;

                } else if ((this.diasIndemnAntesReforma < 720f) && ((this.diasIndemnAntesReforma + this.diasIndemnDespuesReforma) >= 720f)) {

                    this.textoControl2 = " (Tope 24m alcanzado entre los dos tramos)";
                    this.diasIndemnAntesReforma = (float) this.diasTrabajadosAntesReforma * diasIndemnizables45;
                    this.diasIndemnDespuesReforma = 720f - (float) this.diasIndemnAntesReforma;
                    this.diasIndemnTOTAL = this.diasIndemnAntesReforma + this.diasIndemnDespuesReforma;

                } else if ((this.diasIndemnAntesReforma < 720f) && ((this.diasIndemnAntesReforma + this.diasIndemnDespuesReforma) < 720f)) {

                    this.textoControl2 = "Indemnización en 2 periodos. Sin tope alguno";
                    this.diasIndemnAntesReforma = (float) this.diasTrabajadosAntesReforma * diasIndemnizables45;
                    this.diasIndemnDespuesReforma = (float) this.diasTrabajadosDespuesReforma * diasIndemnizables33;
                    this.diasIndemnTOTAL = this.diasIndemnAntesReforma + this.diasIndemnDespuesReforma;
                }

                /*
                El siguiente bloque añade un texto en el informe para diferenciar los totales
                cuando se trata de un periodo mixto.
                */
                this.textoExtraAntiguedad = " (" + this.diasTrabajadosAntesReforma + " + " + this.diasTrabajadosDespuesReforma + ")";
                this.textoExtraDiasIndemn = " (" + Formato.pasar_Float_a_String(this.diasIndemnAntesReforma) + " + " + Formato.pasar_Float_a_String(this.diasIndemnDespuesReforma) + ")" + this.textoControl1;
                this.textoExtraEurosIndemn = " (" + Formato.darFormatoMoneda(this.eurosIndemnAntesReforma) + " + " + Formato.darFormatoMoneda(this.eurosIndemnDespuesReforma) + ")";

            }

            /*
            El siguiente bloque establece el valor definitivo de las variables relacionadas con cantidades
            en el caso de despido improcedente.
            */
            this.eurosIndemnAntesReforma = (this.baseCotizDiaria * this.diasIndemnAntesReforma);
            this.eurosIndemnDespuesReforma = (this.baseCotizDiaria * this.diasIndemnDespuesReforma);
            this.eurosIndemnTOTAL = this.eurosIndemnAntesReforma + this.eurosIndemnDespuesReforma;

        }  //Fin de la lógica del Despido Improcedente.

        
        /*
        Comenzamos aquí con la lógica en los casos de despido por Causa objetiva.
        */
        if ("Causa objetiva".equals(tipoDespido)) {

            this.diasTrabajadosTOTAL = Fechas.difFechas(fechaAlta, fechaBaja);
            this.diasIndemnTOTAL = (float) this.diasTrabajadosTOTAL * diasIndemnizable20;
            if (this.diasIndemnTOTAL > 360f) {
                this.textoControl2 = " (Tope 12m alcanzado entre los dos tramos)";
                this.diasIndemnTOTAL = 360f;
            }

            this.eurosIndemnTOTAL = this.diasIndemnTOTAL * this.baseCotizDiaria;

        } //Fin de los argumentos de la lógica en caso de Causa Objetiva.


        /*
         La siguiente instrucción asigna el contenido final a la variable 'informe'
         que se usará para ser mostrada en el contenido del formulario.
         */
        this.informe = ("Informe emitido en " + Fechas.formatearFechaBonita(fechaInforme)
                + "\nDespido seleccionado: " + this.tipoDespido
                + this.textoControl3
                + "\nAlta: " + Fechas.formatearFechaBonita(this.fechaAlta)
                + "\nBaja: " + Fechas.formatearFechaBonita(this.fechaBaja)
                + "\nAntigüedad: " + antiguedadTotal + " días" + this.textoExtraAntiguedad
                + "\nBase diaria: " + Formato.darFormatoMoneda(this.baseCotizDiaria) + "/dia"
                + "\nDías de indemnización: " + Formato.pasar_Float_a_String(this.diasIndemnTOTAL) + " días" + this.textoExtraDiasIndemn
                + "\nIndemnización TOTAL: " + Formato.darFormatoMoneda(this.eurosIndemnTOTAL) + this.textoExtraEurosIndemn
                + "\n" + this.textoControl2);

    } //Fin del método constructor

} //Fin de la Clase CalculoDespido
