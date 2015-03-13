package IncTemp;

import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;


public class MetodosIT {
    
    GregorianCalendar fBajaMedica;
    GregorianCalendar fAltaMedica;
    
    int numDiasIT;
    float baseDiaria;
    
    int diasTramo1;
    int diasTramo2;
    int diasTramo3;
    int diasTramo4;
    
    float eurosTramo1;
    float eurosTramo2;
    float eurosTramo3;
    float eurosTramo4;
    
    float porcTramo1 = 0;
    float porcTramo2 = (float) 0.6;
    float porcTramo3 = (float) 0.6;
    float porcTramo4 = (float) 0.75;


public void calculaIncTmp(JDateChooser fInicio, JDateChooser fFinal, JTextField baseDiaria){

    //Usamos el valor de JTextField para pasarlo a baseDiaria como un float.    
    this.baseDiaria = Float.parseFloat(baseDiaria.getText());
            
    GregorianCalendar fBajaMedica = new GregorianCalendar();
        fBajaMedica.setTime(fInicio.getDate());
        
        GregorianCalendar fAltaMedica = new GregorianCalendar();
        fAltaMedica.set(
                fFinal.getCalendar().get(Calendar.YEAR),
                fFinal.getCalendar().get(Calendar.MONTH),
                fFinal.getCalendar().get(Calendar.DAY_OF_MONTH), 23, 59, 59);

        // int valorRedondeado = Math.round(valorFloat);

        this.numDiasIT = Math.round(MetodosComunes.MetodosFechas.diferenciaDosGregorian(fBajaMedica, fAltaMedica));
        
        if (this.numDiasIT <= 3){
            this.diasTramo1 = this.numDiasIT;
        } else if (this.numDiasIT > 3 && this.numDiasIT <= 15) {
            this.diasTramo1 = 3;
            this.diasTramo2 = this.numDiasIT - this.diasTramo1;
        
        } else if (this.numDiasIT > 15 && this.numDiasIT <= 20){
            this.diasTramo1 = 3;
            this.diasTramo2 = 12;
            this.diasTramo3 = this.numDiasIT - this.diasTramo1 - this.diasTramo2;
            
        } else {
            this.diasTramo1 = 3;
            this.diasTramo2 = 12;
            this.diasTramo3 = 5;
            this.diasTramo4 = this.numDiasIT - this.diasTramo1 - this.diasTramo2 - this.diasTramo3 - this.diasTramo4;
        }
        
        this.eurosTramo1 = this.diasTramo1 * (this.baseDiaria * this.porcTramo1);
        this.eurosTramo2 = this.diasTramo2 * (this.baseDiaria * this.porcTramo2);
        this.eurosTramo3 = this.diasTramo3 * (this.baseDiaria * this.porcTramo3);
        this.eurosTramo4 = this.diasTramo4 * (this.baseDiaria * this.porcTramo4);
        
    }    

}
