package DespidoFormulario;

import java.util.GregorianCalendar;
import static DespidoFormulario.Trabajador.MILISEGS_POR_DIA;

public class Informes {

    public static String informeCausaObjetiva(String tipoDespido, GregorianCalendar fechaAlta, GregorianCalendar fechaBaja, float bCotiz, float diasCotizados) {

        float antiguedadTotal = MetodosFechas.diferenciaEntreDosFechas(fechaBaja, fechaAlta);
        float bCotizDiaria = bCotiz / diasCotizados;
        float numDiasIndemnizacion = MetodosFechas.calculaDiasIndemnObjetiva(antiguedadTotal);
        float importeIndemnizacion = MetodosFechas.calculaImporteIndemnObjetiva(numDiasIndemnizacion, bCotizDiaria);
        float topeCausaObjetiva = 360f;
        String textoTopeMens = "";

        if (numDiasIndemnizacion > topeCausaObjetiva) {
            numDiasIndemnizacion = topeCausaObjetiva;
            textoTopeMens = " (TOPE ALCANZADO)";
        }

        GregorianCalendar hoy = new GregorianCalendar();

        String informe
                = ("Informe emitido en " + MetodosFechas.formatearFechaBonita(hoy)
                + "\nDespido seleccionado: " + tipoDespido
                + "\nFecha de alta: " + MetodosFechas.formatearFechaBonita(fechaAlta)
                + "\nFecha de baja: " + MetodosFechas.formatearFechaBonita(fechaBaja)
                + "\n(Antigüedad Total: " + MetodosFormatos.darFormatoEsp(antiguedadTotal) + " dias)"
                + "\nBase de cotización diaria: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias"
                + "\nDías a indemnizar: " + MetodosFormatos.darFormatoEsp(numDiasIndemnizacion) + textoTopeMens
                + "\nIndemnización total: " + MetodosFormatos.darFormatoMoneda(importeIndemnizacion));

        return informe;
    }

    public static String informeImprocedente(
            String tipoDespido, GregorianCalendar fechaAlta, GregorianCalendar fechaBaja,
            float bCotiz, float diasCotizados) {

        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 0, 0, 0);

        float antiguedadTotal;
        float antiguedadTotalSumada;
        float reformaMilis = reforma.getTimeInMillis();
        float fAltaMilis = fechaAlta.getTimeInMillis();
        float fBajaMilis = fechaBaja.getTimeInMillis();
        float bCotizDiaria = bCotiz / diasCotizados;
        float numDiasIndemnizacion;
        float numDiasIndemnPreReforma;
        float numDiasIndemnPostReforma;
        float importeIndemnizacion;
        float diasHastaReforma = MetodosFechas.diasHastaReforma(fechaAlta);
        float diasDesdeReforma = MetodosFechas.diasDesdeReforma(fechaBaja);
        float antiguedadPREreforma = 0;
        float antiguedadPOSTreforma = 0;
        String textoControl = "";
        String textoTopeMens = "";
        String textoTopeMensPRE = "";
        String textoTopeMensPOST = "";
        float topeImprocedente45 = 1260f;
        float topeImprocedente33 = 720f;
        char codigoDespido = 'a';
        
        
        //El siguiente IF es cuando todo se produce DESPUÉS de la reforma.
        if (fAltaMilis > reformaMilis) {
            codigoDespido = 'a';
            antiguedadTotal = MetodosFechas.diferenciaEntreDosFechas(fechaBaja, fechaAlta);
            diasHastaReforma = 0;
            diasDesdeReforma = antiguedadTotal;
            numDiasIndemnizacion = antiguedadTotal * (33f / 365f);
                    if (numDiasIndemnizacion > topeImprocedente33) {
                        textoTopeMens = " (TOPE ALCANZADO)";
                        numDiasIndemnizacion = 720f;
                    }
            //El siguiente IF es cuando todo se produce ANTES de la reforma.
        } else if (fBajaMilis <= reformaMilis) {
            codigoDespido = 'b';
            antiguedadTotal = MetodosFechas.diferenciaEntreDosFechas(fechaBaja, fechaAlta);
            diasHastaReforma = antiguedadTotal;
            diasDesdeReforma = 0;
            numDiasIndemnizacion = antiguedadTotal * (45f / 365f);
            if (numDiasIndemnizacion > topeImprocedente45) {
                textoTopeMens = " (TOPE ALCANZADO)";
                numDiasIndemnizacion = 1260f;
            }

            /*
            El siguiente tramo es cuando la antigüedad es afectada por los dos tramos.
            El límite son 720dias de salario, salvo que del cálculo del periodo
            anterior a la reforma resultasen más días. En ese caso, la indemnización
            resultante (de entre 720d y 1260d) sería la máxima aplicable, desechando 
            la indemnización del periodo posterior a la reforma.
            */
        } else {
            antiguedadPREreforma = (reformaMilis - fAltaMilis) / MILISEGS_POR_DIA;
            antiguedadPOSTreforma = (fBajaMilis - reformaMilis) / MILISEGS_POR_DIA;
            antiguedadTotalSumada = antiguedadPREreforma + antiguedadPOSTreforma;
            antiguedadTotal = (fBajaMilis - fAltaMilis) / MILISEGS_POR_DIA;
            
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
                    if ((numDiasIndemnPreReforma < 720f) && ((numDiasIndemnPreReforma + numDiasIndemnPostReforma)>= 720f)) {
                        codigoDespido = 'e';
                        numDiasIndemnizacion = 720f;
                        textoTopeMensPOST = " (Tope 24m alcanzado entre los dos tramos)";
                    }
                    if ((numDiasIndemnPreReforma < 720f) && ((numDiasIndemnPreReforma + numDiasIndemnPostReforma)< 720f)) {
                        codigoDespido = 'f';
                        numDiasIndemnPostReforma = (antiguedadPREreforma * (45f / 365f)) + (antiguedadPOSTreforma * (33f / 365f));
                    }

            textoControl = "\n(" + MetodosFormatos.darFormatoEsp(diasHastaReforma) + textoTopeMensPRE + " antes de la reforma"
                    + " \ny " + MetodosFormatos.darFormatoEsp(diasDesdeReforma) + textoTopeMensPOST + " despúes de la reforma)";
        };

        importeIndemnizacion = numDiasIndemnizacion * bCotizDiaria;

        GregorianCalendar hoy = new GregorianCalendar();

        String informe = (
                "Informe emitido en " + MetodosFechas.formatearFechaBonita(hoy)
                + "\nDespido seleccionado: " + tipoDespido
                + "\n\nFecha de alta: " + MetodosFechas.formatearFechaBonita(fechaAlta)
                + "\nFecha de baja: " + MetodosFechas.formatearFechaBonita(fechaBaja)
                + "\n\nAntigüedad Total: " + MetodosFormatos.darFormatoEsp(antiguedadTotal) + " dias"
                + "\nBase de cotización diaria: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias"
                + "\nEl número de días de indemnización es: " + MetodosFormatos.darFormatoEsp(numDiasIndemnizacion)
                + "\nEl importe de la indemnización es: " + MetodosFormatos.darFormatoMoneda(importeIndemnizacion))
                + "\n\n---------------------\n"
                + "NOTAS:\n"
                + "Desglose antigüedad = " + MetodosFormatos.darFormatoEsp(antiguedadPREreforma) + " + " + MetodosFormatos.darFormatoEsp(antiguedadPOSTreforma)
                ;
                
        
        
        
        return informe;
    }

} //Fin de la Clase Informes
