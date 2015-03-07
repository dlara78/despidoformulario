package Despido;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Trabajador {

    static float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);
    /*    static float DIAS_ANIO = 365;*/

    private String nombre;
    private String empresa;
    private GregorianCalendar fechaAlta;
    private GregorianCalendar fechaBaja;
    private float baseCotizacion;
    private float antiguedadTotal;

    public Trabajador(Date fechaAlta, Date fechaBaja, float baseCotizacion) {

        this.nombre = "Nombre de prueba";
        this.empresa = "Empresa de prueba";
        this.fechaAlta.setTime(fechaAlta);
        this.fechaBaja.setTime(fechaBaja);
        this.baseCotizacion = baseCotizacion;
        this.antiguedadTotal = this.fechaBaja.getTimeInMillis() - this.fechaAlta.getTimeInMillis();
    }
    
    public String fechaGregCalAString(GregorianCalendar fecha){    //El siguiente comando pasa el objeto jCalendar a un String de formato "dd/MM/yyyy"
        String fechaString
                = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)) + "/"
                + String.valueOf(fecha.get(Calendar.MONTH)) + "/"
                + String.valueOf(fecha.get(Calendar.YEAR));
    
        return fechaString;
    }
    
}
