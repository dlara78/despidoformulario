package despido2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LecturaDatosTmp {

    static GregorianCalendar readFecha(String dateFormulario) {

        GregorianCalendar output = (GregorianCalendar) GregorianCalendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date_txt = "";

        do {
            if (dateFormulario.length() > 0) {
                /* Si hemos enviado un texto como parametro, mostramos por pantalla el mensaje */
                System.out.println(dateFormulario);
            }
            
        } while (date_txt.length() == 0);

        return output;
    }

}
