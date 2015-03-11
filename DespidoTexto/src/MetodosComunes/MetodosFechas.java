package MetodosComunes;

import static MetodosComunes.Trabajador.MILISEGS_POR_DIA;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MetodosFechas {

    public static String formatearFechaBonita(GregorianCalendar fechaDate) {
        DateFormat formatoElegante = DateFormat.getDateInstance(DateFormat.FULL);
        String fechaBonita = formatoElegante.format(fechaDate.getTime());
        return fechaBonita;
    }

    public static String formatearFechaCompleta(GregorianCalendar fechaDate) {
        DateFormat formatoCompleto = new SimpleDateFormat("EEE, dd/MM/yyyy, HH:mm:S");
        String fechaBonita = formatoCompleto.format(fechaDate.getTime());
        return fechaBonita;
    }

    public static float diferenciaEntreDosFechas(GregorianCalendar fechaInicial, GregorianCalendar fechaFinal) {
        float diferenciaEnMilis = fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis();
        float diferenciaEnDias = diferenciaEnMilis / MILISEGS_POR_DIA;
        return diferenciaEnDias;
    }

    public static float diasHastaReforma(GregorianCalendar fecha) {
        float dias;
        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 0, 0, 0);
        float temp1 = reforma.getTimeInMillis() - fecha.getTimeInMillis();
        dias = temp1 / MILISEGS_POR_DIA;
        return dias;
    }

    public static float diasDesdeReforma(GregorianCalendar fecha) {
        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 0, 0, 0);
        float temp1 = fecha.getTimeInMillis() - reforma.getTimeInMillis();
        float dias = temp1 / MILISEGS_POR_DIA;
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
