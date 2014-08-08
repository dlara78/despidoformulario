/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package despido2;

/**
 *
 * @author david
 */
public class Metodos {
    private float baseDiaria;
    
    public float calculaBaseDiaria (float bCotizacion, float numDiasMes){
        
        baseDiaria = bCotizacion/numDiasMes;
        
        return baseDiaria;
        }
    
}
