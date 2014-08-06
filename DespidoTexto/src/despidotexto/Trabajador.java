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
   
    static float MILISEGS_POR_DIA = (24 * 60 * 60 * 1000);
    static float DIAS_ANIO = 365;
    
    String nombre;
    String empresa;
    GregorianCalendar fechaAlta;
    GregorianCalendar fechaBaja;
    float baseCotizacion;
    float antiguedadTotal;
        
    
    public Trabajador(String nombre, String empresa, GregorianCalendar fechaAlta, GregorianCalendar fechaBaja, float baseCotizacion){
        
        this.nombre = nombre;
        this.empresa = empresa;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.baseCotizacion = baseCotizacion;
        
    }
    
    public float calcularAntiguedad(GregorianCalendar fechaAlta, GregorianCalendar fechaBaja){
              
    this.antiguedadTotal = (this.fechaBaja.getTimeInMillis() - this.fechaAlta.getTimeInMillis())/MILISEGS_POR_DIA;
          
        return antiguedadTotal;
    }
    
}
