/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DespidoFormulario;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author david
 */
public class DespidoMetodosFormatos {
 
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

        DecimalFormat formatoEsp = new DecimalFormat("#####00.00");
        String nuevaCantidad = formatoEsp.format(cantidad);
        return nuevaCantidad;
    }
    
}
