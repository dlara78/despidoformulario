package despido04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class LecturaDatosTmp {

    /**
     * ESTE MÉTODO (readFecha) SE ENCARGAR DE PEDIR POR LA CONSOLA LAS FECHAS, Y
     * PROCESAR POSTERIORMENTE LAS FECHAS INTRODUCIDAS. Recibe como argumento
     * una cadena de texto, y devuelve un objeto GregorianCalendar ('output').
     *
     */
    static GregorianCalendar readFecha(String msg) {

        /*En las siguientes lineas se crean los objetos output, sdf y date_txt*/
        GregorianCalendar output = (GregorianCalendar) GregorianCalendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date_txt = "";

        /* Repetimos el codigo hasta que se introduzca una fecha correcto */
        do {
            if (msg.length() > 0) {
                /* Si hemos enviado un texto como parametro, mostramos por pantalla el mensaje */
                System.out.println(msg);
            }
            System.out.println("(Recuerda introducir la fecha con formato 'dd/mm/aaaa')");
            Scanner scan01 = new Scanner(System.in);
            date_txt = scan01.next();
            try {
                /* Intentamos crear un objeto GregorianCalendar a partir del texto introducido */
                output.setTime(sdf.parse(date_txt));
            } catch (ParseException ex) {
                /* Si el dato introducido no es correcto, limpia la variable date_txt */
                date_txt = "";
            }
        } while (date_txt.length() == 0);

        return output;
    }

}
