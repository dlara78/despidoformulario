package despido2;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class LecturaDatosTmp {

    static GregorianCalendar metodoProcesarFecha(String dateFormulario) {

        GregorianCalendar output = (GregorianCalendar) GregorianCalendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date_txt = "";

        do {
            if (dateFormulario.length() > 0) {
                /* Si hemos enviado un texto como parametro, mostramos por pantalla el mensaje */
            }
            
        } while (date_txt.length() == 0);

        return output;
    }

}
