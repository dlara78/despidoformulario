package especificos;

import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class MetodosIT {
    
    GregorianCalendar fBajaMedica;
    GregorianCalendar fAltaMedica;
    
    public String normaAplicable;
    
    public int numDiasIT;
    public float baseDiaria;
    
    public int diasTramo1;
    public int diasTramo2;
    public int diasTramo3;
    public int diasTramo4;
    
    public float eurosTramo1;
    public float eurosTramo2;
    public float eurosTramo3;
    public float eurosTramo4;
    
    public float porcTramo1 = (float) 0.00;
    public float porcTramo2 = (float) 0.60;
    public float porcTramo3 = (float) 0.60;
    public float porcTramo4 = (float) 0.75;

    public float complTramo1 = (float) 0.00;
    public float complTramo2 = (float) 0.00;
    public float complTramo3 = (float) 0.00;
    public float complTramo4 = (float) 0.00;

public void calculaIncTmp(JDateChooser fInicio, JDateChooser fFinal, JTextField baseDiaria, JComboBox convenio){

    
    this.normaAplicable = (String) convenio.getSelectedItem();
    
        switch (this.normaAplicable) {
        
        case "Estatuto de los trabajadores":
            this.normaAplicable = "Es el ET, estúpido!";
            break;
        
        case "Complemento al 100%":
            this.porcTramo1 = 1;
            this.porcTramo2 = (float) 0.40;
            this.porcTramo3 = (float) 0.40;
            this.porcTramo4 = (float) 0.25;
            break;
        
        default:
            this.normaAplicable = "opcion por defecto!";
            break;
        
    }
      

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

        this.numDiasIT = Math.round(utilidades.Fechas.diferenciaDosGregorian(fBajaMedica, fAltaMedica));
        
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
        
        this.eurosTramo1 = (this.diasTramo1 * (this.baseDiaria * this.porcTramo1));
        this.eurosTramo2 = (this.diasTramo2 * (this.baseDiaria * this.porcTramo2));
        this.eurosTramo3 = (this.diasTramo3 * (this.baseDiaria * this.porcTramo3));
        this.eurosTramo4 = (this.diasTramo4 * (this.baseDiaria * this.porcTramo4));

        this.complTramo1 = (this.diasTramo1 * (this.baseDiaria * this.complTramo1));
        this.complTramo2 = (this.diasTramo2 * (this.baseDiaria * this.complTramo2));
        this.complTramo3 = (this.diasTramo3 * (this.baseDiaria * this.complTramo3));
        this.complTramo4 = (this.diasTramo4 * (this.baseDiaria * this.complTramo4));

    }    

}
