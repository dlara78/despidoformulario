
package DespidoFormulario;

import java.util.GregorianCalendar;

/**
 *
 * @author david
 */
public class Informes {

    public static String informeCausaObjetiva(
            String tipoDespido, float antTotal, float bCotizDia, float diasIndemn, float importeFinal) {

        String informe;

        informe = (("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nLa antigüedad total en días es de " + MetodosFormatos.darFormatoEsp(antTotal) + " dias"
                + "\nLa base de cotización diaria es: " + MetodosFormatos.darFormatoMoneda(bCotizDia) + "/dias\n"
                + "\nEl número de días de indemnización es: " + MetodosFormatos.darFormatoEsp(diasIndemn)
                + "\nEl importe de la indemnización es: " + MetodosFormatos.darFormatoMoneda(importeFinal)));

        return informe;
    }

    public static String informeCausaObjetiva(
            String tipoDespido, GregorianCalendar fechaAlta, GregorianCalendar fechaBaja,
            String tipoBaseCotiz, float bCotiz) {

        float antiguedadTotal = 0;
        float bCotizDiaria = 0;
        float numDiasIndemnizacion = 0;
        float importeIndemnizacion = 0;
        
        String informe = ("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nLa antigüedad total en días es de " + antiguedadTotal + " dias"
                + "\nLa base de cotización diaria es: " + bCotizDiaria + "/dias\n"
                + "\nEl número de días de indemnización es: " + numDiasIndemnizacion
                + "\nEl importe de la indemnización es: " + importeIndemnizacion
                );

        return informe;
    }

}
