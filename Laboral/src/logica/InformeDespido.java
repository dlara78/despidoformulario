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
    float eurosIndemnAntesReforma;
    float eurosIndemnDespuesReforma;
    
    
    public InformeDespido(
            String tipoDespido,             //Tipo de despido
            GregorianCalendar fechaAlta,    //Fecha de alta en la empresa
            GregorianCalendar fechaBaja,    //Fecha de baja en la empresa
            float baseCotizacion,           //Base de cotización comunicada
            float diasCotizados) {          //Dias correspondientes a la base de cotización
        
        
        this.tipoDespido = tipoDespido;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.baseCotizacion = baseCotizacion;
        this.diasCotizados = diasCotizados;
        this.baseCotizDiaria = baseCotizacion / diasCotizados;
        
        
        GregorianCalendar fechaInforme = new GregorianCalendar(); //Fecha del informe
        int antiguedadTotal = logica.Fechas.diferenciaDosGregorian(this.fechaAlta, this.fechaBaja);
        
        
        
        
        
        this.informe = ("Informe emitido en " + Fechas.formatearFechaBonita(fechaInforme)
                + "\nDespido seleccionado: " + tipoDespido
                + "\n\nFecha de alta: " + Fechas.formatearFechaBonita(this.fechaAlta)
                + "\nFecha de baja: " + Fechas.formatearFechaBonita(this.fechaBaja)
                + "\n\nAntigüedad Total: " + antiguedadTotal + " dias"
                + "\nBase de cotización diaria: " + Formato.darFormatoMoneda(this.baseCotizDiaria) + "/dia"
                + "\nEl número de días de indemnización es: " + Formato.pasar_Float_a_String(numDiasIndemnizacion)
                + "\nEl importe de la indemnización es: " + Formato.darFormatoMoneda(importeIndemnizacion));

        
        
        
//El siguiente IF es cuando todo se produce DESPUÉS de la fechaReforma.
        if (fAltaMilis > milisReforma) {
            codigoDespido = 'a';
            antTotal = Fechas.diferenciaDosGregorian(f_Alta, f_Baja);
            diasHastaReforma = 0;
            diasDesdeReforma = antTotal;
            numDiasIndemnizacion = antTotal * (33f / 365f);
            if (numDiasIndemnizacion > topeImprocedente33) {
                textoTopeMens = " (TOPE ALCANZADO)";
                numDiasIndemnizacion = 720f;
            }
            //El siguiente IF es cuando todo se produce ANTES de la fechaReforma.
        } else if (fBajaMilis <= milisReforma) {
            codigoDespido = 'b';
            antTotal = Fechas.diferenciaDosGregorian(f_Baja, f_Alta);
            diasHastaReforma = antTotal;
            diasDesdeReforma = 0;
            numDiasIndemnizacion = antTotal * (45f / 365f);
            if (numDiasIndemnizacion > topeImprocedente45) {
                textoTopeMens = " (TOPE ALCANZADO)";
                numDiasIndemnizacion = 1260f;
            }

            /*
             El siguiente tramo es cuando la antigüedad es afectada por los dos tramos.
             El límite son 720dias de salario, salvo que del cálculo del periodo
             anterior a la fechaReforma resultasen más días. En ese caso, la indemnización
             resultante (de entre 720d y 1260d) sería la máxima aplicable, desechando 
             la indemnización del periodo posterior a la fechaReforma.
             */
        } else {
            antiguedadPREreforma = (milisReforma - fAltaMilis) / MILISEGS_POR_DIA;
            antiguedadPOSTreforma = (fBajaMilis - milisReforma) / MILISEGS_POR_DIA;
            antTotalSumada = antiguedadPREreforma + antiguedadPOSTreforma;
            antTotal = logica.Fechas.diferenciaDosGregorian(f_Alta, f_Baja);

            numDiasIndemnPreReforma = antiguedadPREreforma * (45f / 365f);
            numDiasIndemnPostReforma = antiguedadPOSTreforma * (33f / 365f);
            numDiasIndemnizacion = numDiasIndemnPreReforma + numDiasIndemnPostReforma;

            if (numDiasIndemnPreReforma >= 1260f) {
                codigoDespido = 'c';
                numDiasIndemnPreReforma = 1260f;
                numDiasIndemnPostReforma = 0f;
                textoTopeMensPRE = " (Tope 42m alcanzado. Periodo 2 descartado)";
                numDiasIndemnizacion = 1260f;
            }
            if ((numDiasIndemnPreReforma >= 720f) && (numDiasIndemnPreReforma < 1260f)) {
                codigoDespido = 'd';
                textoTopeMensPRE = " (Periodo 2 descartado)";
                numDiasIndemnizacion = numDiasIndemnPreReforma;
            }
            if ((numDiasIndemnPreReforma < 720f) && ((numDiasIndemnPreReforma + numDiasIndemnPostReforma) >= 720f)) {
                codigoDespido = 'e';
                numDiasIndemnizacion = 720f;
                textoTopeMensPOST = " (Tope 24m alcanzado entre los dos tramos)";
            }
            if ((numDiasIndemnPreReforma < 720f) && ((numDiasIndemnPreReforma + numDiasIndemnPostReforma) < 720f)) {
                codigoDespido = 'f';
                numDiasIndemnPostReforma = (antiguedadPREreforma * (45f / 365f)) + (antiguedadPOSTreforma * (33f / 365f));
            }

            textoControl = "\n(" + Formato.pasar_Float_a_String(diasHastaReforma) + textoTopeMensPRE + " antes de la reforma"
                    + " \ny " + Formato.pasar_Float_a_String(diasDesdeReforma) + textoTopeMensPOST + " despúes de la reforma)";
        };

        importeIndemnizacion = numDiasIndemnizacion * bCotizDiaria;

        GregorianCalendar hoy = new GregorianCalendar();

        String informe = ("Informe emitido en " + Fechas.formatearFechaBonita(hoy)
                + "\nDespido seleccionado: " + tipoDespido
                + "\n\nFecha de alta: " + Fechas.formatearFechaBonita(f_Alta)
                + "\nFecha de baja: " + Fechas.formatearFechaBonita(f_Baja)
                + "\n\nAntigüedad Total: " + Formato.pasar_Float_a_String(antTotal) + " dias"
                + "\nBase de cotización diaria: " + Formato.darFormatoMoneda(bCotizDiaria) + "/dias"
                + "\nEl número de días de indemnización es: " + Formato.pasar_Float_a_String(numDiasIndemnizacion)
                + "\nEl importe de la indemnización es: " + Formato.darFormatoMoneda(importeIndemnizacion));
        
    }

    public static String informeCausaObjetiva(
            String tipoDespido,
            GregorianCalendar fechaAlta,
            GregorianCalendar fechaBaja,
            float bCotiz,
            float diasCotizados) {

        int antiguedadTotal = Fechas.diferenciaDosGregorian(fechaAlta, fechaBaja);
        float bCotizDiaria = bCotiz / diasCotizados;
        float numDiasIndemnizacion = Fechas.calculaDiasIndemnObjetiva(antiguedadTotal);
        float importeIndemnizacion = Fechas.calculaImporteIndemnObjetiva(numDiasIndemnizacion, bCotizDiaria);
        float topeCObjetiva = 360f;
        String textoTopeMens = "";

        if (numDiasIndemnizacion > topeCObjetiva) {
            numDiasIndemnizacion = topeCObjetiva;
            textoTopeMens = " (TOPE ALCANZADO)";
        }

        GregorianCalendar hoy = new GregorianCalendar();

        String informe
                = ("Informe emitido en " + Fechas.formatearFechaBonita(hoy)
                + "\nDespido seleccionado: " + tipoDespido
                + "\nFecha de alta: " + Fechas.formatearFechaBonita(fechaAlta)
                + "\nFecha de baja: " + Fechas.formatearFechaBonita(fechaBaja)
                + "\n(Antigüedad Total: " + Formato.pasar_Float_a_String(antiguedadTotal) + " dias)"
                + "\nBase de cotización diaria: " + Formato.darFormatoMoneda(bCotizDiaria) + "/dias"
                + "\nDías a indemnizar: " + Formato.pasar_Float_a_String(numDiasIndemnizacion) + textoTopeMens
                + "\nIndemnización total: " + Formato.darFormatoMoneda(importeIndemnizacion));

        return informe;
    }

    public static String informeImprocedente(
            String tipoDespido,
            GregorianCalendar f_Alta,
            GregorianCalendar f_Baja,
            float bCotiz,
            float diasCotizados) {

        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 0, 0, 0);

        int antTotal;
        float antTotalSumada;
        float milisReforma = reforma.getTimeInMillis();
        float fAltaMilis = f_Alta.getTimeInMillis();
        float fBajaMilis = f_Baja.getTimeInMillis();
        float bCotizDiaria = bCotiz / diasCotizados;
        float numDiasIndemnizacion;
        float numDiasIndemnPreReforma;
        float numDiasIndemnPostReforma;
        float importeIndemnizacion;
        float diasHastaReforma = Fechas.diasHastaReforma(f_Alta);
        float diasDesdeReforma = Fechas.diasDesdeReforma(f_Baja);
        float antiguedadPREreforma = 0;
        float antiguedadPOSTreforma = 0;
        String textoControl = "";
        String textoTopeMens = "";
        String textoTopeMensPRE = "";
        String textoTopeMensPOST = "";
        float topeImprocedente45 = 1260f;
        float topeImprocedente33 = 720f;
        char codigoDespido = 'a';

        //El siguiente IF es cuando todo se produce DESPUÉS de la fechaReforma.
        if (fAltaMilis > milisReforma) {
            codigoDespido = 'a';
            antTotal = Fechas.diferenciaDosGregorian(f_Alta, f_Baja);
            diasHastaReforma = 0;
            diasDesdeReforma = antTotal;
            numDiasIndemnizacion = antTotal * (33f / 365f);
            if (numDiasIndemnizacion > topeImprocedente33) {
                textoTopeMens = " (TOPE ALCANZADO)";
                numDiasIndemnizacion = 720f;
            }
            //El siguiente IF es cuando todo se produce ANTES de la fechaReforma.
        } else if (fBajaMilis <= milisReforma) {
            codigoDespido = 'b';
            antTotal = Fechas.diferenciaDosGregorian(f_Baja, f_Alta);
            diasHastaReforma = antTotal;
            diasDesdeReforma = 0;
            numDiasIndemnizacion = antTotal * (45f / 365f);
            if (numDiasIndemnizacion > topeImprocedente45) {
                textoTopeMens = " (TOPE ALCANZADO)";
                numDiasIndemnizacion = 1260f;
            }

            /*
             El siguiente tramo es cuando la antigüedad es afectada por los dos tramos.
             El límite son 720dias de salario, salvo que del cálculo del periodo
             anterior a la fechaReforma resultasen más días. En ese caso, la indemnización
             resultante (de entre 720d y 1260d) sería la máxima aplicable, desechando 
             la indemnización del periodo posterior a la fechaReforma.
             */
        } else {
            antiguedadPREreforma = (milisReforma - fAltaMilis) / MILISEGS_POR_DIA;
            antiguedadPOSTreforma = (fBajaMilis - milisReforma) / MILISEGS_POR_DIA;
            antTotalSumada = antiguedadPREreforma + antiguedadPOSTreforma;
            antTotal = logica.Fechas.diferenciaDosGregorian(f_Alta, f_Baja);

            numDiasIndemnPreReforma = antiguedadPREreforma * (45f / 365f);
            numDiasIndemnPostReforma = antiguedadPOSTreforma * (33f / 365f);
            numDiasIndemnizacion = numDiasIndemnPreReforma + numDiasIndemnPostReforma;

            if (numDiasIndemnPreReforma >= 1260f) {
                codigoDespido = 'c';
                numDiasIndemnPreReforma = 1260f;
                numDiasIndemnPostReforma = 0f;
                textoTopeMensPRE = " (Tope 42m alcanzado. Periodo 2 descartado)";
                numDiasIndemnizacion = 1260f;
            }
            if ((numDiasIndemnPreReforma >= 720f) && (numDiasIndemnPreReforma < 1260f)) {
                codigoDespido = 'd';
                textoTopeMensPRE = " (Periodo 2 descartado)";
                numDiasIndemnizacion = numDiasIndemnPreReforma;
            }
            if ((numDiasIndemnPreReforma < 720f) && ((numDiasIndemnPreReforma + numDiasIndemnPostReforma) >= 720f)) {
                codigoDespido = 'e';
                numDiasIndemnizacion = 720f;
                textoTopeMensPOST = " (Tope 24m alcanzado entre los dos tramos)";
            }
            if ((numDiasIndemnPreReforma < 720f) && ((numDiasIndemnPreReforma + numDiasIndemnPostReforma) < 720f)) {
                codigoDespido = 'f';
                numDiasIndemnPostReforma = (antiguedadPREreforma * (45f / 365f)) + (antiguedadPOSTreforma * (33f / 365f));
            }

            textoControl = "\n(" + Formato.pasar_Float_a_String(diasHastaReforma) + textoTopeMensPRE + " antes de la reforma"
                    + " \ny " + Formato.pasar_Float_a_String(diasDesdeReforma) + textoTopeMensPOST + " despúes de la reforma)";
        };

        importeIndemnizacion = numDiasIndemnizacion * bCotizDiaria;

        GregorianCalendar hoy = new GregorianCalendar();

        String informe = ("Informe emitido en " + Fechas.formatearFechaBonita(hoy)
                + "\nDespido seleccionado: " + tipoDespido
                + "\n\nFecha de alta: " + Fechas.formatearFechaBonita(f_Alta)
                + "\nFecha de baja: " + Fechas.formatearFechaBonita(f_Baja)
                + "\n\nAntigüedad Total: " + Formato.pasar_Float_a_String(antTotal) + " dias"
                + "\nBase de cotización diaria: " + Formato.darFormatoMoneda(bCotizDiaria) + "/dias"
                + "\nEl número de días de indemnización es: " + Formato.pasar_Float_a_String(numDiasIndemnizacion)
                + "\nEl importe de la indemnización es: " + Formato.darFormatoMoneda(importeIndemnizacion));

        /* Ejemplo Switch - aprenderaprogramar.com */
        switch (codigoDespido) {
            case 'a':
            case 'b':
            case 'c':

                String comentarios;
                break;

            case 'd':

                String comentarios2 = ("\n\n---------------------"
                        + "\nNOTAS:"
                        + "Desglose antigüedad = " + Formato.pasar_Float_a_String(antiguedadPREreforma) + " + " + Formato.pasar_Float_a_String(antiguedadPOSTreforma));
                break;

        } /* Fin de la condicional Switch*/


        return informe;
    } /* Fin del informe de despido improcedente */

} //Fin de la Clase InformeDespido
