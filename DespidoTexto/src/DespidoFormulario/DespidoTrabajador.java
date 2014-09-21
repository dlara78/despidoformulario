package DespidoFormulario;

import java.util.GregorianCalendar;

public class DespidoTrabajador {

    static float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);
    /*    static float DIAS_ANIO = 365;*/

    private String nombre;
    private String empresa;
    private GregorianCalendar fechaAlta;
    private GregorianCalendar fechaBaja;
    private float baseCotizacion;
    private float antiguedadTotal;

    public DespidoTrabajador(String nombre, String empresa, GregorianCalendar fechaAlta, GregorianCalendar fechaBaja, float baseCotizacion) {

        this.nombre = nombre;
        this.empresa = empresa;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.baseCotizacion = baseCotizacion;
    }
    
    public DespidoTrabajador(String fechaAlta, String fechaBaja, float baseCotizacion) {

        this.nombre = "Nombre de prueba";
        this.empresa = "Empresa de prueba";
        this.fechaAlta = DespidoMetodosFechas.convertirFechaStringAGregorian(fechaAlta); //"dd/MM/yyyy"
        this.fechaBaja = DespidoMetodosFechas.convertirFechaStringAGregorian(fechaBaja); //"dd/MM/yyyy"
        this.baseCotizacion = baseCotizacion;
        this.antiguedadTotal = DespidoMetodosFechas.calcularFloatEntreDosFechasString(fechaBaja, fechaAlta);
    }
    
}
