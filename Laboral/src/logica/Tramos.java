package logica;

import java.util.GregorianCalendar;


public class Tramos {
    private final GregorianCalendar fInicioTramo;
    private final GregorianCalendar fFinTramo;
    private final int numDiasPorAno;
    private final int numMaxMensualidades;
    private final int numDiasTrabajados;
    private final float baseCotizacionDiariaTramo;

    public Tramos(
            GregorianCalendar fInicioTramo,
            GregorianCalendar fFinTramo,
            int numDiasPorAno,
            int numMaxMensualidades,
            int numDiasTrabajados,
            float baseCotizacionDiariaTramo) {
        
        this.fInicioTramo = fInicioTramo;
        this.fFinTramo = fFinTramo;
        this.numDiasPorAno = numDiasPorAno;
        this.numMaxMensualidades = numMaxMensualidades;
        this.numDiasTrabajados = numDiasTrabajados;
        this.baseCotizacionDiariaTramo = baseCotizacionDiariaTramo;
    }

    public GregorianCalendar getfInicioTramo() {
        return fInicioTramo;
    }

    public GregorianCalendar getfFinTramo() {
        return fFinTramo;
    }

    public int getNumDiasPorAno() {
        return numDiasPorAno;
    }

    public int getNumMaxMensualidades() {
        return numMaxMensualidades;
    }

    public int getNumDiasTrabajados() {
        return numDiasTrabajados;
    }

    public float getBaseCotizacionDiariaTramo() {
        return baseCotizacionDiariaTramo;
    }
        
    
}


/* Para instanciar un tramo...
 * Tramos tramo1 = new Tram(<fecha1>, <fecha2>, 45);
 * 
 * y si quieres obtener los dias seria
 * tramo1.getDiasPorAno();
 * o
 * tramo1.getFechaInicio();
 * o
 * tramo1.getFechaFin();
 */
