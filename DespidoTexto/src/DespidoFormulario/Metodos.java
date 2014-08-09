package DespidoFormulario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metodos {

        float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);

  /*El siguiente método devuelve el valor en milis (float) de la fecha enviada 
     * por string
     */
    public float calcularFechaEnMilis(String fechaString) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        //Fecha de alta
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

    /*
    * Al sgte método se le mandan dos fechas (en String) y devuelve la diferencia en días,
    * en un solo valor float.
    */
    public float calcularDifEntreDosFechas(String fechaBaja, String fechaAlta) {

        float diferenciaEnMilis = this.calcularFechaEnMilis(fechaBaja) - this.calcularFechaEnMilis(fechaAlta);
        float diferenciaEnDias = diferenciaEnMilis / MILISEGS_POR_DIA;

        return diferenciaEnDias;
    }
    
}
