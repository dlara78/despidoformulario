package logica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fechas {

    static float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);

    /*
    El siguiente método recibe un argumento GregorianCalendar y devuelve
    una fecha elegante de clase String.
    */
    public static String formatearFechaBonita(GregorianCalendar fechaDate) {
        DateFormat formatoElegante = DateFormat.getDateInstance(DateFormat.FULL);
        String fechaBonita = formatoElegante.format(fechaDate.getTime());
        return fechaBonita;
    }

    /*
    El siguiente método recibe un argumento de tipo GregorianCalendar y devuelve
    una fecha completa, con día de la semana, en una clase String.
    */
    public static String formatearFechaCompleta(GregorianCalendar fechaDate) {
        DateFormat formatoCompleto = new SimpleDateFormat("EEE, dd/MM/yyyy, HH:mm:S");
        String fechaBonita = formatoCompleto.format(fechaDate.getTime());
        return fechaBonita;
    }

    static int diferenciaDosGregorian(Date fechaBajaIT, Date fechaAltaIT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    El siguiente método recibe un argumento jCalendar y devuelve
    un String de formato "dd/MM/yyyy"
    */
    public String fechaGregCalAString(GregorianCalendar fecha){    
        String fechaString
                = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)) + "/"
                + String.valueOf(fecha.get(Calendar.MONTH)) + "/"
                + String.valueOf(fecha.get(Calendar.YEAR));
    
        return fechaString;
    }

    

    public static int diferenciaDosGregorian(GregorianCalendar fechaInicial, GregorianCalendar fechaFinal) {
        int diferenciaEnDias = 
                Math.round((fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis())/MILISEGS_POR_DIA);
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
    
    
} //Corchete final de la clase Fechas.

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
