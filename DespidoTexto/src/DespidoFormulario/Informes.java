package DespidoFormulario;

import java.text.DateFormat;
import java.util.GregorianCalendar;
import static DespidoFormulario.Trabajador.MILISEGS_POR_DIA;

public class Informes {

    public static String informeCausaObjetiva(
            String tipoDespido, String fechaAlta, String fechaBaja,
            String bCotiz, String diasCotizados) {

        float antiguedadTotal = MetodosFechas.calcularFloatEntreDosFechasString(fechaBaja, fechaAlta);
        float bCotizDiaria = Float.valueOf(bCotiz) / Float.valueOf(diasCotizados);
        float numDiasIndemnizacion = MetodosFechas.calculaDiasIndemnObjetiva(antiguedadTotal);
        float importeIndemnizacion = MetodosFechas.calculaImporteIndemnObjetiva(numDiasIndemnizacion, bCotizDiaria);

        String informe = ("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nALTA: " + MetodosFechas.convertirAFechaBonita(fechaAlta)
                + "\nBAJA: " + MetodosFechas.convertirAFechaBonita(fechaBaja)
                + "\n(Antigüedad total: " + MetodosFormatos.darFormatoEsp(antiguedadTotal) + " dias)"
                + "\nLa base de cotización diaria es: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias\n"
                + "\nEl número de días de indemnización es: " + MetodosFormatos.darFormatoEsp(numDiasIndemnizacion)
                + "\nEl importe de la indemnización es: " + MetodosFormatos.darFormatoMoneda(importeIndemnizacion));

        return informe;
    }

    public static String informeImprocedente(
            String tipoDespido, String fechaAlta, String fechaBaja,
            String bCotiz, String diasCotizados) {

        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 0, 0);

        float antiguedadTotal = 0;
        float reformaMilis = reforma.getTimeInMillis();
        float fAltaMilis = MetodosFechas.convertirFechaInicialStringEnMilis(fechaAlta);
        float fBajaMilis = MetodosFechas.convertirFechaFinalStringEnMilis(fechaBaja);
        float bCotizDiaria = Float.valueOf(bCotiz) / Float.valueOf(diasCotizados);
        float numDiasIndemnizacion = 0;
        float importeIndemnizacion = 0;
        float diasHastaReforma = MetodosFechas.diasHastaReforma(fechaAlta);
        float diasDesdeReforma = MetodosFechas.diasDesdeReforma(fechaBaja);

        if (fAltaMilis > reformaMilis) {

            antiguedadTotal = MetodosFechas.calcularFloatEntreDosFechasString(fechaBaja, fechaAlta);
            diasHastaReforma = 0;
            diasDesdeReforma = antiguedadTotal;
            numDiasIndemnizacion = antiguedadTotal * (33f / 365f);
            importeIndemnizacion = numDiasIndemnizacion * bCotizDiaria;

        } else if (fBajaMilis < reformaMilis) {

            antiguedadTotal = MetodosFechas.calcularFloatEntreDosFechasString(fechaBaja, fechaAlta);
            diasHastaReforma = antiguedadTotal;
            diasDesdeReforma = 0;
            numDiasIndemnizacion = antiguedadTotal * (45f / 365f);
            importeIndemnizacion = numDiasIndemnizacion * bCotizDiaria;
        
        } else {
            
            float antiguedadPREreforma;
            float antiguedadPOSTreforma;
            
            
        };

        String informe = ("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nALTA: " + MetodosFechas.convertirAFechaBonita(fechaAlta)
                + "\nBAJA: " + MetodosFechas.convertirAFechaBonita(fechaBaja)
                + "\n\n(Antigüedad total: " + MetodosFormatos.darFormatoEsp(antiguedadTotal) + " dias)"
                + "\nAntigüedad antes de reforma: " + MetodosFormatos.darFormatoEsp(diasHastaReforma)
                + "\nAntigüedad después de reforma: " + MetodosFormatos.darFormatoEsp(diasDesdeReforma)
                + "\n\nLa base de cotización diaria es: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias\n"
                + "\nEl número de días de indemnización es: " + MetodosFormatos.darFormatoEsp(numDiasIndemnizacion)
                + "\nEl importe de la indemnización es: " + MetodosFormatos.darFormatoMoneda(importeIndemnizacion)
                );

        return informe;
    }

}
