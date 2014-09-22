package DespidoFormulario;

import static DespidoFormulario.Trabajador.MILISEGS_POR_DIA;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodosFechas {

    public static String convertirDateAFechaBonita(Date fechaDate) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dfCompleta = DateFormat.getDateInstance(DateFormat.FULL);
        Calendar calFechaIntroducida = Calendar.getInstance();
        calFechaIntroducida.setTime(fechaDate);
        String fechaBonita = dfCompleta.format(fechaDate);
        return fechaBonita;
    }

    public static float calcularDiasEntreDosFechasDate(Date fechaBaja, Date fechaAlta) {

        Calendar fBaja = Calendar.getInstance();
        Calendar fAlta = Calendar.getInstance();
        fBaja.setTime(fechaBaja);
        fBaja.add(Calendar.HOUR, 24);
        fAlta.setTime(fechaAlta);
        float diferenciaEnMilis = fBaja.getTimeInMillis() - fAlta.getTimeInMillis();
        float diferenciaEnDias = diferenciaEnMilis / MILISEGS_POR_DIA;
        return diferenciaEnDias;
    }

    public static float convertirFechaInicialDateEnMilis(Date fechaInicial) {
        Calendar calFechaIntroducida = Calendar.getInstance();
        calFechaIntroducida.setTime(fechaInicial);
        float fechaEnMilis = calFechaIntroducida.getTimeInMillis();
        return fechaEnMilis;
    }

    public static float convertirFechaFinalDateEnMilis(Date fechaFinal) {
        Calendar calFechaIntroducida = Calendar.getInstance();
        calFechaIntroducida.setTime(fechaFinal);
        calFechaIntroducida.add(Calendar.HOUR, 24);  //Esta linea es para que cuente el día completo.
        float fechaEnMilis = calFechaIntroducida.getTimeInMillis();
        return fechaEnMilis;
    }

    public static float diasHastaReforma(Date fecha) {
        float dias;
        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 0, 0, 0);
        float temp1 = reforma.getTimeInMillis() - MetodosFechas.convertirFechaInicialDateEnMilis(fecha);
        dias = temp1 / MILISEGS_POR_DIA;
        return dias;
    }

    public static float diasDesdeReforma(Date fecha) {
        float dias;
        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 0, 0, 0);
        float temp1 = MetodosFechas.convertirFechaFinalDateEnMilis(fecha) - reforma.getTimeInMillis();
        dias = temp1 / MILISEGS_POR_DIA;
        return dias;
    }

    public static float calculaDiasIndemnObjetiva(float antiguedadTotal) {
        float diasIndemnizacion = antiguedadTotal * (20f / 365f);
        return diasIndemnizacion;
    }

    

    public static float baseCotizDiaria(String baseMensual, String diasTrabajados) {
        float baseCotizDia = (Float.parseFloat(baseMensual) / Float.parseFloat(diasTrabajados));
        return baseCotizDia;
    }

    public static float calcularAntiguedad(GregorianCalendar fechaAlta, GregorianCalendar fechaBaja) {
        float antiguedadTotal;
        antiguedadTotal = (fechaBaja.getTimeInMillis() - fechaAlta.getTimeInMillis()) / MILISEGS_POR_DIA;
        return antiguedadTotal;
    }

    public static float calculaImporteIndemnObjetiva(float diasIndemnizacion, float baseDiaria) {
        float importeIndemnObjetiva = diasIndemnizacion * baseDiaria;
        return importeIndemnObjetiva;
    }

    static long convertirFechaInicialStringEnMilis(String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} //Corchete final de la clase MetodosFechas.
