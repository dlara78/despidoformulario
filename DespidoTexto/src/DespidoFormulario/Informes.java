
package DespidoFormulario;

import java.util.GregorianCalendar;

/**
 *
 * @author david
 */
public class Informes {

//    public static String informeCausaObjetiva(
//            String tipoDespido, float antTotal, float bCotizDia, float diasIndemn, float importeFinal) {
//
//        String informe;
//
//        informe = (("Iniciando informe...\n"
//                + "\nTipo de despido: " + tipoDespido
//                + "\nLa antigüedad total en días es de " + MetodosFormatos.darFormatoEsp(antTotal) + " dias"
//                + "\nLa base de cotización diaria es: " + MetodosFormatos.darFormatoMoneda(bCotizDia) + "/dias\n"
//                + "\nEl número de días de indemnización es: " + MetodosFormatos.darFormatoEsp(diasIndemn)
//                + "\nEl importe de la indemnización es: " + MetodosFormatos.darFormatoMoneda(importeFinal)));
//
//        return informe;
//    }

    public static String informeCausaObjetiva(
            String tipoDespido, String fechaAlta, String fechaBaja,
            String bCotiz, String diasCotizados) {

        float antiguedadTotal = MetodosFechas.calcularDifEntreDosFechas(fechaBaja, fechaAlta);
        float bCotizDiaria = Float.valueOf(bCotiz) / Float.valueOf(diasCotizados);
        float numDiasIndemnizacion = MetodosFechas.calculaDiasIndemnObjetiva(antiguedadTotal);
        float importeIndemnizacion = MetodosFechas.calculaImporteIndemnObjetiva(numDiasIndemnizacion, bCotizDiaria);
        
        String informe = ("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nLa antigüedad total en días es de " + MetodosFormatos.darFormatoEsp(antiguedadTotal) + " dias"
                + "\nLa base de cotización diaria es: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias\n"
                + "\nEl número de días de indemnización es: " + MetodosFormatos.darFormatoEsp(numDiasIndemnizacion)
                + "\nEl importe de la indemnización es: " + MetodosFormatos.darFormatoMoneda(importeIndemnizacion)
                );

        return informe;
    }

}
