package DespidoFormulario;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metodos {

//METODOS RELATIVOS A --FECHAS--
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

    public static float calcularDifEntreDosFechas(String fechaBaja, String fechaAlta) {
        float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);
        float diferenciaEnMilis = calcularFechaEnMilis(fechaBaja) - calcularFechaEnMilis(fechaAlta);
        float diferenciaEnDias = diferenciaEnMilis / MILISEGS_POR_DIA;

        return diferenciaEnDias;
    }

    public static float calculaDiasIndemnObjetiva(float antiguedadTotal) {
        float diasIndemnizacion = antiguedadTotal * (20f / 365f);
        return diasIndemnizacion;
    }

//============================ fin bloque métodos de FECHAS.                
//METODOS RELATIVOS A ---FORMATOS---
    public static String darFormatoMoneda(float cantidad) {

        NumberFormat money = NumberFormat.getCurrencyInstance();
        String cantidadEuros = money.format(cantidad);
        return cantidadEuros;
    }

    public static String darFormatoMoneda(String cantidad) {

        NumberFormat money = NumberFormat.getCurrencyInstance();
        String cantidadEuros = money.format(cantidad);
        return cantidadEuros;
    }

    public static String darFormatoEsp(float cantidad) {

        DecimalFormat formatoEsp = new DecimalFormat("#######.00");
        String nuevaCantidad = formatoEsp.format(cantidad);
        return nuevaCantidad;
    }
//============================ fin bloque métodos de FORMATOS.

//METODOS VARIOS
    public static float baseCotizDiaria(String baseMensual, String diasTrabajados) {
        float baseCotizDia = (Float.parseFloat(baseMensual) / Float.parseFloat(diasTrabajados));
        return baseCotizDia;
    }

    public static float calculaImporteIndemnObjetiva(float diasIndemnizacion, float baseDiaria) {
        float importeIndemnObjetiva = diasIndemnizacion * baseDiaria;
        return importeIndemnObjetiva;
    }
//============================ fin bloque métodos de FORMATOS.

//METODOS RELATIVOS A ---INFÓRMENES---
    public static String informeCausaObjetiva(
            String tipoDespido, 
            float antTotal, 
            float bCotizDia, 
            float diasIndemn, 
            float importeFinal) {

        String informe;

        informe = (("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nLa antigüedad total en días es de " + Metodos.darFormatoEsp(antTotal) + " dias"
                + "\nLa base de cotización diaria es: " + Metodos.darFormatoMoneda(bCotizDia) + "/dias\n"
                + "\nEl número de días de indemnización es: " + Metodos.darFormatoEsp(diasIndemn)
                + "\nEl importe de la indemnización es: " + Metodos.darFormatoMoneda(importeFinal)));

        return informe;
    }

//============================ fin bloque métodos de INFÓRMENES.                
} //Corchete final de la clase Metodos.
