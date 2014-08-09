package DespidoFormulario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metodos {

        


        
    //Este método recibe una fecha en String y devuelve si valor en milis (float)
    //---OJO--- puede que desprecie horas del día, lo que provoque un fallo.
    // en el cálculo de diferencia entre días.
    public static float calcularFechaEnMilis(String fechaString) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateFecha = null;
        try {
            dateFecha = df.parse(fechaString);
        } catch (ParseException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calFechaIntroducida = Calendar.getInstance();
        calFechaIntroducida.setTime(dateFecha);
        float fechaEnMilis = calFechaIntroducida.getTimeInMillis();

        return fechaEnMilis;
    }
    
    
    // Al sgte método se le mandan dos fechas (en String) y devuelve la diferencia en días,
    // en un solo valor float.
    public static float calcularDifEntreDosFechas(String fechaBaja, String fechaAlta) {
        float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);
        float diferenciaEnMilis = calcularFechaEnMilis(fechaBaja) - calcularFechaEnMilis(fechaAlta);
        float diferenciaEnDias = diferenciaEnMilis / MILISEGS_POR_DIA;

        return diferenciaEnDias;
    }
    
}
