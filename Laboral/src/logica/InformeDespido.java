package logica;

import java.util.GregorianCalendar;

public class InformeDespido {

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
    float diasIndemnTOTAL;
    float eurosIndemnAntesReforma;
    float eurosIndemnDespuesReforma;
    float eurosIndemnTOTAL;

    String textoControl1 = "";
    String textoControl2 = "No hay más incidencias.";
    String textoControl3 = "textoControl3 inicial";
    String textoControl4 = "textoControl4 inicial";

    public String getInforme() {
        return informe;
    }

    public InformeDespido(
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
        int antiguedadTotal = logica.Fechas.diferenciaDosGregorian(this.fechaAlta, this.fechaBaja);
        float topeImproced45dias = 1260;
        float topeImproced33dias = 720;


        /*
         Comienza la preparación del informe.
         */
        if ("Despido improcedente".equals(tipoDespido)) {

            if (this.fechaBaja.getTimeInMillis() < this.fechaReforma.getTimeInMillis()) {
                /*
                 Este primer if es en caso de que la relación laboral sucediese integramente
                 antes de la reforma laboral.
                 */
                this.diasTrabajadosDespuesReforma = 0;
                this.diasIndemnDespuesReforma = 0;
                this.diasTrabajadosAntesReforma = Fechas.diferenciaDosGregorian(this.fechaAlta, this.fechaBaja);
                this.diasIndemnAntesReforma = (float) this.diasTrabajadosAntesReforma * (45f / 365f);
                if (this.diasIndemnAntesReforma > topeImproced45dias) {
                    this.textoControl1 = "TOPADO";
                    this.diasIndemnAntesReforma = topeImproced45dias;
                }

                this.diasIndemnTOTAL = this.diasIndemnAntesReforma;
                this.eurosIndemnAntesReforma = (this.baseCotizDiaria * this.diasIndemnAntesReforma);
                this.eurosIndemnDespuesReforma = 0;
                this.eurosIndemnTOTAL = this.eurosIndemnAntesReforma;

            } else if (this.fechaAlta.getTimeInMillis() >= this.fechaReforma.getTimeInMillis()) {
                /* 
                 Este segundo if es en caso de que la relación laboral sucediese integramente
                 despues de la reforma laboral.
                 */

                this.diasTrabajadosAntesReforma = 0;
                this.diasIndemnAntesReforma = 0;
                this.diasTrabajadosDespuesReforma = Fechas.diferenciaDosGregorian(this.fechaAlta, this.fechaBaja);
                this.diasIndemnDespuesReforma = (float) this.diasTrabajadosDespuesReforma * (33f / 365f);

                if (this.diasIndemnDespuesReforma > topeImproced33dias) {
                    textoControl1 = "TOPADO";
                    this.diasIndemnDespuesReforma = topeImproced33dias;
                }

                this.diasIndemnTOTAL = this.diasIndemnDespuesReforma;
                this.eurosIndemnAntesReforma = 0;
                this.eurosIndemnDespuesReforma = (this.baseCotizDiaria * this.diasIndemnDespuesReforma);
                this.eurosIndemnTOTAL = this.eurosIndemnDespuesReforma;

            } else {
                /*
                 El siguiente tramo es cuando la antigüedad es afectada por los dos tramos.
                 El límite son 720dias de salario, salvo que del cálculo del periodo
                 anterior a la fechaReforma resultasen más días. En ese caso, la indemnización
                 resultante (de entre 720d y 1260d) sería la máxima aplicable, desechando 
                 la indemnización del periodo posterior a la fechaReforma.
                 */

                if (this.diasIndemnAntesReforma >= 1260) {

                    this.textoControl2 = "(Periodo 2 descartado. Tope 42m alcanzado.)";
                    this.diasIndemnAntesReforma = 1260;
                    this.diasIndemnDespuesReforma = 0;
                    this.diasIndemnTOTAL = this.diasIndemnAntesReforma;
                    this.eurosIndemnDespuesReforma = 0;
                    this.eurosIndemnAntesReforma = (this.baseCotizDiaria * this.diasIndemnAntesReforma);
                    this.eurosIndemnTOTAL = this.eurosIndemnAntesReforma;

                } else if ((this.diasIndemnAntesReforma >= 720f) && (this.diasIndemnAntesReforma < 1260f)) {

                    this.textoControl2 = " (Periodo 2 descartado. Tope 42m no alcanzado)";
                    this.diasIndemnAntesReforma = (float) this.diasTrabajadosAntesReforma * (45f / 365f);
                    this.diasIndemnDespuesReforma = 0;
                    this.diasIndemnTOTAL = this.diasIndemnAntesReforma;
                    this.eurosIndemnDespuesReforma = 0;
                    this.eurosIndemnAntesReforma = (this.baseCotizDiaria * this.diasIndemnAntesReforma);
                    this.eurosIndemnTOTAL = this.eurosIndemnAntesReforma;
                    this.diasIndemnDespuesReforma = 0;

                } else if ((this.diasIndemnAntesReforma < 720f) && ((this.diasIndemnAntesReforma + this.diasIndemnDespuesReforma) >= 720f)) {

                    this.textoControl2 = " (Tope 24m alcanzado entre los dos tramos)";
                    this.diasIndemnAntesReforma = 0;
                    this.diasIndemnDespuesReforma = 720;

                } else if ((this.diasIndemnAntesReforma < 720f) && ((this.diasIndemnAntesReforma + this.diasIndemnDespuesReforma) < 720f)) {

                    this.diasIndemnDespuesReforma = (this.diasTrabajadosAntesReforma * (45f / 365f));
                    this.diasIndemnDespuesReforma = (this.diasTrabajadosDespuesReforma * (33f / 365f));
                }

            }

        }

        /*
         La siguiente instrucción asigna el contenido final a la variable 'informe'
         que se usará para ser mostrada en el contenido del formulario.
         */
        this.informe = ("Informe emitido en " + Fechas.formatearFechaBonita(fechaInforme)
                + "\nDespido seleccionado: " + this.tipoDespido
                + "\n\nFecha de alta: " + Fechas.formatearFechaBonita(this.fechaAlta)
                + "\nFecha de baja: " + Fechas.formatearFechaBonita(this.fechaBaja)
                + "\n\nAntigüedad Total: " + antiguedadTotal + " dias"
                + "\nBase de cotización diaria: " + Formato.darFormatoMoneda(this.baseCotizDiaria) + "/dia"
                + "\nNº días indemnización totales: " + Formato.pasar_Float_a_String(this.diasIndemnTOTAL) + " días (" + Formato.pasar_Float_a_String(this.diasIndemnAntesReforma) + " + " + Formato.pasar_Float_a_String(this.diasIndemnDespuesReforma) + " ) " + this.textoControl1
                + "\nIndemnización TOTAL: " + Formato.darFormatoMoneda(this.eurosIndemnTOTAL) + "(" + Formato.darFormatoMoneda(this.eurosIndemnAntesReforma) + " + " + Formato.darFormatoMoneda(this.eurosIndemnDespuesReforma) + ")"
                + "\n" + this.textoControl2);

    }

//    public static String informeCausaObjetiva(
//            String tipoDespido,
//            GregorianCalendar fechaAlta,
//            GregorianCalendar fechaBaja,
//            float bCotiz,
//            float diasCotizados) {
//
//        int antiguedadTotal = Fechas.diferenciaDosGregorian(fechaAlta, fechaBaja);
//        float bCotizDiaria = bCotiz / diasCotizados;
//        float numDiasIndemnizacion = Fechas.calculaDiasIndemnObjetiva(antiguedadTotal);
//        float importeIndemnizacion = Fechas.calculaImporteIndemnObjetiva(numDiasIndemnizacion, bCotizDiaria);
//        float topeCObjetiva = 360f;
//        String textoTopeMens = "";
//
//        if (numDiasIndemnizacion > topeCObjetiva) {
//            numDiasIndemnizacion = topeCObjetiva;
//            textoTopeMens = " (TOPE ALCANZADO)";
//        }
//
//        GregorianCalendar hoy = new GregorianCalendar();
//
//        String informe
//                = ("Informe emitido en " + Fechas.formatearFechaBonita(hoy)
//                + "\nDespido seleccionado: " + tipoDespido
//                + "\nFecha de alta: " + Fechas.formatearFechaBonita(fechaAlta)
//                + "\nFecha de baja: " + Fechas.formatearFechaBonita(fechaBaja)
//                + "\n(Antigüedad Total: " + Formato.pasar_Float_a_String(antiguedadTotal) + " dias)"
//                + "\nBase de cotización diaria: " + Formato.darFormatoMoneda(bCotizDiaria) + "/dias"
//                + "\nDías a indemnizar: " + Formato.pasar_Float_a_String(numDiasIndemnizacion) + textoTopeMens
//                + "\nIndemnización total: " + Formato.darFormatoMoneda(importeIndemnizacion));
//
//        return informe;
//    }
} //Fin de la Clase InformeDespido
