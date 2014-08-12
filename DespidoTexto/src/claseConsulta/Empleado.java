package despido04;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author daniel
 */
public class Empleado {

    GregorianCalendar fechaAlta = null;

    Empleado(GregorianCalendar p_fechaAlta) {
        this.fechaAlta = p_fechaAlta;
    }

    static float getDiasIndemnizacion(GregorianCalendar p_FechaAlta, GregorianCalendar p_FechaBaja) {

        //long MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);
        float diasTotalesTrabajados = 0;
        float diasTotalesIndemnizacion = 0;
        GregorianCalendar tmpFechaAlta = p_FechaAlta;       //Creamos dos variables temporales de 
        GregorianCalendar tmpFechaBaja = p_FechaBaja;       // tipo GregorianCalendar para usar en los tramos.

        Tramos[] tramosActuales = MetodosAuxiliares.getTramo();

        
        /**
         * ESTE CONJUNTO 'FOR' RECORRE LOS TRAMOS DEL ARRAY "tramosActuales".
         */
        for (int z = 0; z < tramosActuales.length; z++) {

            long diasTramoActual = 0; // Establecemos el valor inicial de la variable. Para evitar operaciones con NULL.
            Calendar c = GregorianCalendar.getInstance(); //Este calendario se usa para no modificar las fechas reales.
            
            /*El siguiente tramo IF calcula los dias en funcion del tramo en qué se encuentre.*/
            //Si la fecha de alta se encuentra dentro del tramo en el que estamos...
            if (tmpFechaAlta.getTimeInMillis() >= tramosActuales[z].getFechaInicio().getTimeInMillis()
                    && tmpFechaAlta.getTimeInMillis() <= tramosActuales[z].getFechaFin().getTimeInMillis()) {
                
                //... y además, si la fecha de baja se encuentra dentro del tramo en el que estamos...
                if (tmpFechaBaja.getTimeInMillis() <= tramosActuales[z].getFechaFin().getTimeInMillis()) {
                    c.setTimeInMillis(tmpFechaBaja.getTimeInMillis() - tmpFechaAlta.getTimeInMillis());

                } else {
                    c.setTimeInMillis(tramosActuales[z].getFechaFin().getTimeInMillis() - tmpFechaAlta.getTimeInMillis());

                    if (z + 1 < tramosActuales.length) {
                        tmpFechaAlta = tramosActuales[z + 1].getFechaInicio();
                    }
                }
                diasTramoActual = c.get(Calendar.DAY_OF_YEAR);
                diasTotalesTrabajados += diasTramoActual;

                /* REVISAR: ESTE CALCULO NO LO REALIZA CORRECTAMENTE, DEVUELVE 0*/
                diasTotalesIndemnizacion += (diasTramoActual * ((1.0 * tramosActuales[z].getDiasPorAno()) / 365));

                //Este bloque contiene lineas de control. (borrar las irrelevantes cuando la aplicación funcione)
                System.out.println("\n----------------------------");
                System.out.println("Nº de tramo: " + (z + 1));
                System.out.println("Variable 'dias'= " + diasTramoActual);
                System.out.println("Variable 'diastotalesTrabajados'= " + diasTotalesTrabajados);
                System.out.println("Variable 'diasTotalesIndemnizacion'= " + diasTotalesIndemnizacion);
                System.out.println("## Número de días del tramo " + (z + 1) + " es: " + diasTramoActual);
                System.out.println("## Número de días de indemnización del tramo " + (z + 1) + " es: " + (diasTramoActual * ((1.0 * tramosActuales[z].getDiasPorAno()) / 365)));
                System.out.println("-----------------------------");
                //Fin del bloque que contiene lineas de control.

            }   //Final del IF

        } // FINAL DEL RECORRIDO DE TRAMOS (segundo FOR).

        System.out.println("\n----------------------------");
        System.out.println("## TOTAL ");
        System.out.println("El número de días totales trabajados es: " + diasTotalesTrabajados);
        System.out.println("El número de días totales a indemnizar es: " + diasTotalesIndemnizacion);
        System.out.println("-----------------------------");

        return 0;
    } //FINAL DEL METODO getDiasIndemnizacion().

}
