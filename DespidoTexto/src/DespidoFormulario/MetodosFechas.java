package DespidoFormulario;

import static DespidoFormulario.Trabajador.MILISEGS_POR_DIA;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodosFechas {

    public static float diasHastaReforma(String fecha) {
        float dias;
        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 23, 59);
        float temp1 = reforma.getTimeInMillis() - MetodosFechas.calcularFechaEnMilis(fecha);
        dias = temp1 / MILISEGS_POR_DIA;
        return dias;
    }

    public static float diasDesdeReforma(String fecha) {
        float dias;
        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 23, 59);
        float temp1 = MetodosFechas.calcularFechaEnMilis(fecha) - reforma.getTimeInMillis();
        dias = temp1 / MILISEGS_POR_DIA;
        return dias;
    }

//---OJO--- puede que desprecie horas del día, lo que provoque un fallo.
    // en el cálculo de diferencia entre días.
    public static float calcularFechaEnMilis(String fechaString) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateFecha = null;
        try {
            dateFecha = df.parse(fechaString);
        } catch (ParseException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calFechaIntroducida = Calendar.getInstance();
        calFechaIntroducida.setTime(dateFecha);
        float fechaEnMilis = calFechaIntroducida.getTimeInMillis();

        return fechaEnMilis;
    }

    public static GregorianCalendar convertirFechaStringAGregorian(String fechaImportada) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar fechaGregorian = (GregorianCalendar) GregorianCalendar.getInstance();
        
        try {
            fechaGregorian.setTime(df.parse(fechaImportada));
        } catch (ParseException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fechaGregorian;
    }
    
    
    public static String convertirAFechaBonita(String fechaString) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);

        Date dateFecha = null;
        try {
            dateFecha = df.parse(fechaString);
        } catch (ParseException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calFechaIntroducida = Calendar.getInstance();
        calFechaIntroducida.setTime(dateFecha);

        String fechaBonita = df4.format(dateFecha);

        return fechaBonita;
    }

    public static float calcularDifEntreDosFechas(String fechaBaja, String fechaAlta) {
        float diferenciaEnMilis = calcularFechaEnMilis(fechaBaja) - calcularFechaEnMilis(fechaAlta);
        float diferenciaEnDias = diferenciaEnMilis / MILISEGS_POR_DIA;
        return diferenciaEnDias;
    }

    public static float calculaDiasIndemnObjetiva(float antiguedadTotal) {
        float diasIndemnizacion = antiguedadTotal * (20f / 365f);
        return diasIndemnizacion;
    }

    public static float calculaDiasImprocedente(String fechaFin, String fechaInicio) {

        //Metodo "en construccion"       
        float diasIndemnizacion = 0;
        Calendar fechaAlta = Calendar.getInstance();
        Calendar fechaBaja = Calendar.getInstance();
        Calendar reforma = Calendar.getInstance();

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

    public static float calcularAntiguedad(GregorianCalendar fechaAlta, GregorianCalendar fechaBaja) {

        float antiguedadTotal;
        antiguedadTotal = (fechaBaja.getTimeInMillis() - fechaAlta.getTimeInMillis()) / MILISEGS_POR_DIA;
        return antiguedadTotal;
    }

} //Corchete final de la clase MetodosFechas.
