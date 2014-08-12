package despido04;

import java.util.GregorianCalendar;

/**
 * @author david
 * 
 * Esta clase contiene la estructura y métodos necesarios para trabajar
 * con tramos.
 */
public class Tramos {

    private GregorianCalendar fInicioTramo;
    private GregorianCalendar fFinTramo;
    private int numDiasPorAno;
    private int numMaxMensualidades;

    /* Constructor */
    Tramos(GregorianCalendar p_FechaInicio, GregorianCalendar p_FechaFin, int p_numDiasPorAno, int p_numMaxMensualidades) {

        this.numDiasPorAno = p_numDiasPorAno;
        this.numMaxMensualidades = p_numMaxMensualidades;
        this.fInicioTramo = p_FechaInicio;
        this.fFinTramo = p_FechaFin;
    }

    GregorianCalendar getFechaInicio() {
        return this.fInicioTramo;
    }

    GregorianCalendar getFechaFin() {
        return this.fFinTramo;
    }

    int getDiasPorAno() {
        return this.numDiasPorAno;
    }

    int getMaxMensualidades() {
        return this.numMaxMensualidades;
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
