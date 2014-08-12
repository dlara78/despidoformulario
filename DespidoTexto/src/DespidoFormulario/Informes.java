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

        String informe = ("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nLa antigüedad total en días es de " + " dias"
                + "\nLa base de cotización diaria es: " + "/dias\n"
                + "\nEl número de días de indemnización es: "
                + "\nEl importe de la indemnización es: " 
                );

        return informe;
    }

}
