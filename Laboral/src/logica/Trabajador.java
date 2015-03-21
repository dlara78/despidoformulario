package logica;

import java.util.GregorianCalendar;

public class Trabajador {

    static float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);
    GregorianCalendar reforma2012 = new GregorianCalendar(2012, 1, 12, 0, 0, 0);

    //Variables generales
    private String nombre;
    private String empresa;
    private GregorianCalendar fechaAltaEmpresa;
    private GregorianCalendar fechaBajaEmpresa;

    //Variables específicas para los despidos
    private String tipoDespido;
    private float baseDiariaDespido;
    private int antiguedadTotalEmpresa;
    private int antigAntesReforma;
    private int antigDespuesReforma;
    private GregorianCalendar[] tramos = {fechaAltaEmpresa, reforma2012, fechaBajaEmpresa};

    //Variables especificas para los procesos IT
    private GregorianCalendar fechaAltaIT;
    private GregorianCalendar fechaBajaIT;
    private float baseCotizacionIT;
    private int antiguedadTotalIT;

    /*
     Método constructor para casos de despido
     */
    public Trabajador(
            GregorianCalendar fechaAltaEmpresa,
            GregorianCalendar fechaBajaEmpresa,
            float baseCotizacionDespido,
            int diasCotizadosMesAnterior,
            String tipoDespido) {

        this.fechaAltaEmpresa = fechaAltaEmpresa;
        this.fechaBajaEmpresa = fechaBajaEmpresa;
        this.baseDiariaDespido = baseCotizacionDespido / (float) diasCotizadosMesAnterior;
        this.tipoDespido = tipoDespido;
        this.antiguedadTotalEmpresa = Fechas.diferenciaDosGregorian(fechaAltaEmpresa, fechaBajaEmpresa);

    }

    public Trabajador(GregorianCalendar fechaBajaIT, GregorianCalendar fechaAltaIT, float baseCotizacionIT) {

        this.nombre = "Nombre de prueba";
        this.empresa = "Empresa de prueba";
        this.fechaBajaIT = fechaBajaIT;
        this.fechaAltaIT = fechaAltaIT;
        this.baseCotizacionIT = baseCotizacionIT;
        this.antiguedadTotalIT = logica.Fechas.diferenciaDosGregorian(fechaBajaIT, fechaAltaIT);
    }

}
