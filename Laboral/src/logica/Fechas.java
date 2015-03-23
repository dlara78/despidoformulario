package logica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fechas {

    static float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);

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

    public String fechaGregCalAString(GregorianCalendar fecha) {
        String fechaString
                = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)) + "/"
                + String.valueOf(fecha.get(Calendar.MONTH)) + "/"
                + String.valueOf(fecha.get(Calendar.YEAR));
        return fechaString;
    }

    public static int difFechas(GregorianCalendar fechaInicial, GregorianCalendar fechaFinal) {
        int diferenciaEnDias
                = Math.round((fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis()) / MILISEGS_POR_DIA);
        return diferenciaEnDias;
    }

    public static int diasHastaReforma(GregorianCalendar fecha) {
        int dias;
        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 0, 0, 0);
        dias = Fechas.difFechas(fecha, reforma);
        return dias;
    }

    public static int diasDesdeReforma(GregorianCalendar fecha) {
        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 0, 0, 0);
        int dias = Fechas.difFechas(reforma, fecha);
        return dias;
    }

    public static float calculaDiasIndemnObjetiva(float antiguedadTotal) {
        float diasIndemnizacion = antiguedadTotal * (20f / 365f);
        return diasIndemnizacion;
    }

}
