package DespidoFormulario;

import java.text.DateFormat;

public class Informes {

    public static String informeCausaObjetiva(
            String tipoDespido, String fechaAlta, String fechaBaja,
            String bCotiz, String diasCotizados) {

        float antiguedadTotal = MetodosFechas.calcularDifEntreDosFechas(fechaBaja, fechaAlta);
        float bCotizDiaria = Float.valueOf(bCotiz) / Float.valueOf(diasCotizados);
        float numDiasIndemnizacion = MetodosFechas.calculaDiasIndemnObjetiva(antiguedadTotal);
        float importeIndemnizacion = MetodosFechas.calculaImporteIndemnObjetiva(numDiasIndemnizacion, bCotizDiaria);

        String informe = ("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nALTA: " + MetodosFechas.convertirFechaBonita(fechaAlta)
                + "\nBAJA: " + MetodosFechas.convertirFechaBonita(fechaBaja)
                + "\n(Antigüedad total: " + MetodosFormatos.darFormatoEsp(antiguedadTotal) + " dias)"
                + "\nLa base de cotización diaria es: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias\n"
                + "\nEl número de días de indemnización es: " + MetodosFormatos.darFormatoEsp(numDiasIndemnizacion)
                + "\nEl importe de la indemnización es: " + MetodosFormatos.darFormatoMoneda(importeIndemnizacion));

        return informe;
    }

    public static String informeImprocedente(
            String tipoDespido, String fechaAlta, String fechaBaja,
            String bCotiz, String diasCotizados) {

        float antiguedadTotal = MetodosFechas.calcularDifEntreDosFechas(fechaBaja, fechaAlta);
        float bCotizDiaria = Float.valueOf(bCotiz) / Float.valueOf(diasCotizados);
        float numDiasIndemnizacion = MetodosFechas.calculaDiasIndemnObjetiva(antiguedadTotal);
        float importeIndemnizacion = MetodosFechas.calculaImporteIndemnObjetiva(numDiasIndemnizacion, bCotizDiaria);
        float diasHastaReforma = MetodosFechas.diasHastaReforma(fechaAlta);
        float diasDesdeReforma = MetodosFechas.diasHastaReforma(fechaBaja);
        String informe = ("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nALTA: " + MetodosFechas.convertirFechaBonita(fechaAlta)
                + "\nBAJA: " + MetodosFechas.convertirFechaBonita(fechaBaja)
                + "\n\n(Antigüedad total: " + (MetodosFormatos.darFormatoEsp(diasDesdeReforma + diasHastaReforma) + " dias)"
                + "\nAntigüedad antes de reforma: " + MetodosFormatos.darFormatoEsp(diasHastaReforma)
                + "\nAntigüedad después de reforma: " + MetodosFormatos.darFormatoEsp(diasDesdeReforma)
                + "\n\nLa base de cotización diaria es: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias\n"
                + "\nEl número de días de indemnización es: <pendiente>"
                + "\nEl importe de la indemnización es: <pendiente>"
                )
                );

        return informe;
    }

}
