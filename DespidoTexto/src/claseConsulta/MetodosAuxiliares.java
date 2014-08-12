package despido04;

import java.util.GregorianCalendar;

/**
 * @author david
 */
public class MetodosAuxiliares {

    public static Tramos[] getTramo() {

        //Creamos un array llamado 'salida', del tipo Tramos.
        Tramos[] salida = new Tramos[2];
        
        // Pasamos los parámetros de cada uno de los elementos del array.
        // Parámetros: fecha de inicio, fecha de fin, dias por año a indemnizar, mensualidades máximas
        salida[0] = new Tramos(new GregorianCalendar(1970, 1, 1), new GregorianCalendar(2012,1,12), 45, 42);
        salida[1] = new Tramos(new GregorianCalendar(2012,1,13), new GregorianCalendar(2099,11,31), 33, 24);

        //Devolvemos el array de tipo Tramos.
        return salida;
    }

}
