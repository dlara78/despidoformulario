/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package despidotexto;

import java.util.GregorianCalendar;

/**
 *
 * @author david
 */
public class Trabajador {
   
    String nombre;
    String empresa;
    GregorianCalendar fechaAlta;
    GregorianCalendar fechaBaja;
    float baseCotizacion;
    
    
    public Trabajador(String nombre, String empresa, GregorianCalendar fechaAlta, GregorianCalendar fechaBaja, float baseCotizacion){
        
        this.nombre = nombre;
        this.empresa = empresa;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.baseCotizacion = baseCotizacion;
        
    }
    
    public float calcularAntiguedad(GregorianCalendar fechaAlta, GregorianCalendar fechaBaja){
              
        //Calculamos aqui la antiguedad total del trabajador
        
        return 0;
    }
    
}
