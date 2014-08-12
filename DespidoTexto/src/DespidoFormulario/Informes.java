
package DespidoFormulario;

/**
 *
 * @author david
 */
public class Informes {

    public static String informeCausaObjetiva(String tipoDespido, float antTotal, float bCotizDia, 
            float diasIndemn, float importeFinal) {

        String informe;

        informe = (("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nLa antigüedad total en días es de " + Metodos.darFormatoEsp(antTotal) + " dias"
                + "\nLa base de cotización diaria es: " + Metodos.darFormatoMoneda(bCotizDia) + "/dias\n"
                + "\nEl número de días de indemnización es: " + Metodos.darFormatoEsp(diasIndemn)
                + "\nEl importe de la indemnización es: " + Metodos.darFormatoMoneda(importeFinal)));

        return informe;
    }
}
