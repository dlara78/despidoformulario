package DespidoFormulario;

import static DespidoFormulario.Trabajador.MILISEGS_POR_DIA;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public static float calculaImporteIndemnObjetiva(float diasIndemnizacion, float baseDiaria) {
        float importeIndemnObjetiva = diasIndemnizacion * baseDiaria;
        return importeIndemnObjetiva;
    }

} //Corchete final de la clase MetodosFechas.

//  METODOS PARA PASAR UN JCALENDAR A STRING
//        //El siguiente comando pasa el objeto jCalendar a un String de formato "dd/MM/yyyy"
//        String fechaBaja
//                = String.valueOf(jDateChooserFechaBaja.getCalendar().get(Calendar.DAY_OF_MONTH)) + "/"
//                + String.valueOf(jDateChooserFechaBaja.getCalendar().get(Calendar.MONTH)) + "/"
//                + String.valueOf(jDateChooserFechaBaja.getCalendar().get(Calendar.YEAR));
//
//        //El siguiente comando pasa el objeto jCalendar a un String de formato "dd/MM/yyyy"
//        String fechaAlta
//                = String.valueOf(jDateChooserFechaAlta.getCalendar().get(Calendar.DAY_OF_MONTH)) + "/"
//                + String.valueOf(jDateChooserFechaAlta.getCalendar().get(Calendar.MONTH)) + "/"
//                + String.valueOf(jDateChooserFechaAlta.getCalendar().get(Calendar.YEAR));
