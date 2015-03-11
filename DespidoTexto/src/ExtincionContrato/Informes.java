package ExtincionContrato;

import MetodosComunes.MetodosFormatos;
import MetodosComunes.MetodosFechas;
import java.util.GregorianCalendar;

public class Informes {

    static float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);

        public static String informeCausaObjetiva(String tipoDespido, GregorianCalendar fechaAlta, GregorianCalendar fechaBaja, float bCotiz, float diasCotizados) {

        float antiguedadTotal = MetodosFechas.diferenciaEntreDosFechas(fechaBaja, fechaAlta);
        float bCotizDiaria = bCotiz / diasCotizados;
        float numDiasIndemnizacion = MetodosFechas.calculaDiasIndemnObjetiva(antiguedadTotal);
        float importeIndemnizacion = MetodosFechas.calculaImporteIndemnObjetiva(numDiasIndemnizacion, bCotizDiaria);
        float topeCObjetiva = 360f;
        String textoTopeMens = "";

        if (numDiasIndemnizacion > topeCObjetiva) {
            numDiasIndemnizacion = topeCObjetiva;
            textoTopeMens = " (TOPE ALCANZADO)";
        }

        GregorianCalendar hoy = new GregorianCalendar();

        String informe
                = ("Informe emitido en " + MetodosFechas.formatearFechaBonita(hoy)
                + "\nDespido seleccionado: " + tipoDespido
                + "\nFecha de alta: " + MetodosFechas.formatearFechaBonita(fechaAlta)
                + "\nFecha de baja: " + MetodosFechas.formatearFechaBonita(fechaBaja)
                + "\n(Antigüedad Total: " + MetodosFormatos.pasar_Float_a_String(antiguedadTotal) + " dias)"
                + "\nBase de cotización diaria: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias"
                + "\nDías a indemnizar: " + MetodosFormatos.pasar_Float_a_String(numDiasIndemnizacion) + textoTopeMens
                + "\nIndemnización total: " + MetodosFormatos.darFormatoMoneda(importeIndemnizacion));

        return informe;
    }

    public static String informeImprocedente(
            String tipoDespido, GregorianCalendar f_Alta, GregorianCalendar f_Baja,
            float bCotiz, float diasCotizados) {

        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 0, 0, 0);

        float antTotal;
        float antTotalSumada;
        float milisReforma = reforma.getTimeInMillis();
        float fAltaMilis = f_Alta.getTimeInMillis();
        float fBajaMilis = f_Baja.getTimeInMillis();
        float bCotizDiaria = bCotiz / diasCotizados;
        float numDiasIndemnizacion;
        float numDiasIndemnPreReforma;
        float numDiasIndemnPostReforma;
        float importeIndemnizacion;
        float diasHastaReforma = MetodosFechas.diasHastaReforma(f_Alta);
        float diasDesdeReforma = MetodosFechas.diasDesdeReforma(f_Baja);
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
        if (fAltaMilis > milisReforma) {
            codigoDespido = 'a';
            antTotal = MetodosFechas.diferenciaEntreDosFechas(f_Baja, f_Alta);
            diasHastaReforma = 0;
            diasDesdeReforma = antTotal;
            numDiasIndemnizacion = antTotal * (33f / 365f);
                    if (numDiasIndemnizacion > topeImprocedente33) {
                        textoTopeMens = " (TOPE ALCANZADO)";
                        numDiasIndemnizacion = 720f;
                    }
            //El siguiente IF es cuando todo se produce ANTES de la reforma.
        } else if (fBajaMilis <= milisReforma) {
            codigoDespido = 'b';
            antTotal = MetodosFechas.diferenciaEntreDosFechas(f_Baja, f_Alta);
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
            anterior a la reforma resultasen más días. En ese caso, la indemnización
            resultante (de entre 720d y 1260d) sería la máxima aplicable, desechando 
            la indemnización del periodo posterior a la reforma.
            */
        } else {
            antiguedadPREreforma = (milisReforma - fAltaMilis) / MILISEGS_POR_DIA;
            antiguedadPOSTreforma = (fBajaMilis - milisReforma) / MILISEGS_POR_DIA;
            antTotalSumada = antiguedadPREreforma + antiguedadPOSTreforma;
            antTotal = (fBajaMilis - fAltaMilis) / MILISEGS_POR_DIA;
            
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

            textoControl = "\n(" + MetodosFormatos.pasar_Float_a_String(diasHastaReforma) + textoTopeMensPRE + " antes de la reforma"
                    + " \ny " + MetodosFormatos.pasar_Float_a_String(diasDesdeReforma) + textoTopeMensPOST + " despúes de la reforma)";
        };

        importeIndemnizacion = numDiasIndemnizacion * bCotizDiaria;

        GregorianCalendar hoy = new GregorianCalendar();

        String informe = (
                "Informe emitido en " + MetodosFechas.formatearFechaBonita(hoy)
                + "\nDespido seleccionado: " + tipoDespido
                + "\n\nFecha de alta: " + MetodosFechas.formatearFechaBonita(f_Alta)
                + "\nFecha de baja: " + MetodosFechas.formatearFechaBonita(f_Baja)
                + "\n\nAntigüedad Total: " + MetodosFormatos.pasar_Float_a_String(antTotal) + " dias"
                + "\nBase de cotización diaria: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias"
                + "\nEl número de días de indemnización es: " + MetodosFormatos.pasar_Float_a_String(numDiasIndemnizacion)
                + "\nEl importe de la indemnización es: " + MetodosFormatos.darFormatoMoneda(importeIndemnizacion))
                ;
                
         /* Ejemplo Switch - aprenderaprogramar.com */
        switch (codigoDespido) {
        case 'a':
        case 'b':
        case 'c':

        String comentarios;
        break;

        case 'd':

        String comentarios2 = (
                "\n\n---------------------" 
                + "\nNOTAS:"
                + "Desglose antigüedad = " + MetodosFormatos.pasar_Float_a_String(antiguedadPREreforma) + " + " + MetodosFormatos.pasar_Float_a_String(antiguedadPOSTreforma)
                );
        break;

        } /* Fin de la condicional Switch*/
                
        
        
        return informe;
    } /* Fin del informe de despido improcedente */

} //Fin de la Clase Informes
