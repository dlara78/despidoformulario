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

        String informe
                = ("\nDespido seleccionado: " + tipoDespido
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
        float antiguedadTotalSumada = 0;
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

        //El siguiente IF es cuando todo se produce DESPUÉS de la reforma.
        if (fAltaMilis > reformaMilis) {
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
            antiguedadTotal = MetodosFechas.diferenciaEntreDosFechas(fechaBaja, fechaAlta);
            diasHastaReforma = antiguedadTotal;
            diasDesdeReforma = 0;
            numDiasIndemnizacion = antiguedadTotal * (45f / 365f);
            if (numDiasIndemnizacion > topeImprocedente45) {
                textoTopeMens = " (TOPE ALCANZADO)";
                numDiasIndemnizacion = 1260f;
            }

            //El siguiente IF es cuando la reforma afecta al periodo.    
        } else {
            antiguedadPREreforma = (reformaMilis - fAltaMilis) / MILISEGS_POR_DIA;
            antiguedadPOSTreforma = (fBajaMilis - reformaMilis) / MILISEGS_POR_DIA;
            antiguedadTotalSumada = antiguedadPREreforma + antiguedadPOSTreforma;
            antiguedadTotal = (fBajaMilis - fAltaMilis) / MILISEGS_POR_DIA;
            numDiasIndemnPreReforma = antiguedadPREreforma * (45f / 365f);
            numDiasIndemnPostReforma = antiguedadPOSTreforma * (33f / 365f);
            numDiasIndemnizacion = numDiasIndemnPreReforma + numDiasIndemnPostReforma;

            if (numDiasIndemnPreReforma > 1260f) {
                numDiasIndemnPreReforma = 1260f;
                textoTopeMensPRE = " (TOPE ALCANZADO)";
                numDiasIndemnizacion = 1260f;
                numDiasIndemnPostReforma = 0;
            }

            if (numDiasIndemnPostReforma > 720f) {
                numDiasIndemnPostReforma = 720f;
                textoTopeMensPOST = " (TOPE ALCANZADO)";
            }

            textoControl
                    = "\n( " + MetodosFormatos.darFormatoEsp(diasHastaReforma) + textoTopeMensPRE + " antes de la reforma"
                    + " y " + MetodosFormatos.darFormatoEsp(diasDesdeReforma) + textoTopeMensPOST + " despúes de la reforma)";
        };

        importeIndemnizacion = numDiasIndemnizacion * bCotizDiaria;

        String informe
                = ("\nDespido seleccionado: " + tipoDespido
                + "\nFecha de alta: " + MetodosFechas.formatearFechaBonita(fechaAlta)
                + "\nFecha de baja: " + MetodosFechas.formatearFechaBonita(fechaBaja)
                + "\n(Antigüedad Total: " + MetodosFormatos.darFormatoEsp(antiguedadTotal) + " dias)"
                + textoControl
                + "\nBase de cotización diaria: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias"
                + "\nEl número de días de indemnización es: " + MetodosFormatos.darFormatoEsp(numDiasIndemnizacion)
                + textoTopeMens
                + "\nEl importe de la indemnización es: " + MetodosFormatos.darFormatoMoneda(importeIndemnizacion));

        return informe;
    }

} //Fin de la Clase Informes
