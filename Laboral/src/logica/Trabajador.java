package logica;

import java.util.GregorianCalendar;

public class Trabajador {

    static float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);
    GregorianCalendar reforma2012 = new GregorianCalendar(2012, 1, 12, 0, 0, 0);

    //Variables generales
    public String nombre;
    public String empresa;
    public GregorianCalendar fechaAltaEmpresa;
    public GregorianCalendar fechaBajaEmpresa;

    //Variables específicas para los despidos
    public String tipoDespido;
    public float baseDiariaDespido;
    public int antiguedadTotalEmpresa;
    public int antigAntesReforma;
    public int antigDespuesReforma;
    public GregorianCalendar[] tramos;
    public float indemnAntesReforma;
    public float indemnDespuesReforma;
    public float indemnTotal;

    //Variables especificas para los procesos IT
    GregorianCalendar fechaAltaIT;
    GregorianCalendar fechaBajaIT;
    float baseCotizacionIT;
    int antiguedadTotalIT;

    /*
     Método constructor para casos de despido
     */
    public Trabajador(
            GregorianCalendar fechaAltaEmpresa, //
            GregorianCalendar fechaBajaEmpresa,
            float baseCotizacionDespido,
            float diasCotizadosMesAnterior,
            String tipoDespido) {

        this.fechaAltaEmpresa = fechaAltaEmpresa;
        this.fechaBajaEmpresa = fechaBajaEmpresa;
        this.antiguedadTotalEmpresa = Fechas.difFechas(fechaAltaEmpresa, fechaBajaEmpresa);
        this.baseDiariaDespido = baseCotizacionDespido / diasCotizadosMesAnterior;
        this.tipoDespido = tipoDespido;

        if (fechaBajaEmpresa.getTimeInMillis() < reforma2012.getTimeInMillis()) {
            this.antigAntesReforma = this.antiguedadTotalEmpresa;
            this.antigDespuesReforma = 0;
            this.indemnAntesReforma = (this.antigAntesReforma * (45 / 365)) * this.baseDiariaDespido;
            this.indemnDespuesReforma = 0;
            this.indemnTotal = this.indemnAntesReforma;
        } else if (fechaAltaEmpresa.getTimeInMillis() >= reforma2012.getTimeInMillis()) {
            this.antigAntesReforma = 0;
            this.antigDespuesReforma = this.antiguedadTotalEmpresa;
            this.indemnAntesReforma = 0;
            this.indemnDespuesReforma = (this.antigDespuesReforma * (33 / 365)) * this.baseDiariaDespido;
            this.indemnTotal = this.indemnAntesReforma;
        } else {
            this.antigAntesReforma = Fechas.difFechas(fechaAltaEmpresa, reforma2012);
            this.antigDespuesReforma = Fechas.difFechas(reforma2012, fechaBajaEmpresa);
            this.indemnAntesReforma = (this.antigAntesReforma * (45 / 365)) * this.baseDiariaDespido;
            this.indemnDespuesReforma = (this.antigDespuesReforma * (33 / 365)) * this.baseDiariaDespido;
        }

    }

    /*
     Métodos constructor para casos de Incapacidad Temporal
     */
    public Trabajador(GregorianCalendar fechaBajaIT, GregorianCalendar fechaAltaIT, float baseCotizacionIT) {

        this.nombre = "Nombre de prueba";
        this.empresa = "Empresa de prueba";
        this.fechaBajaIT = fechaBajaIT;
        this.fechaAltaIT = fechaAltaIT;
        this.baseCotizacionIT = baseCotizacionIT;
        this.antiguedadTotalIT = logica.Fechas.difFechas(fechaBajaIT, fechaAltaIT);
    }

}
