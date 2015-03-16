package logica;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MetodosIT {

    GregorianCalendar fBajaMedica;  //Fecha de la baja médica
    GregorianCalendar fAltaMedica;  //Fecha del alta médica
    GregorianCalendar fechaNomina;  //Fecha (mes) del recibo de salario.
    
    public String normaAplicable;

    public int totalDiasIT;
    public int mensualDiasIT;
    public float baseDiaria;
    public int diasGastadosNominasAnteriores;
    public int diasMesActual;

    public int[]    diasTramo   = {0, 0, 0, 0};
    public float[]  eurosTramo  = {0, 0, 0, 0};
    public float[]  porcTramo   = {0, 60, 60, 75};
    public float[]  complTramo  = {0, 0, 0, 0};

    public void objetoIncTmp(JDateChooser fInicio, JDateChooser fFinal, JTextField baseDiaria, JComboBox convenio, JMonthChooser mesActual, JYearChooser anoActual) {

        this.normaAplicable = (String) convenio.getSelectedItem();

        switch (this.normaAplicable) {

            case "Estatuto de los trabajadores":

                break;

            case "Complemento al 100%":

                this.complTramo[0] = 100;
                this.complTramo[1] = 40;
                this.complTramo[2] = 40;
                this.complTramo[3] = 25;

                this.normaAplicable = "Complemento 100%";
                break;

            case "opcion 3":

                break;

            case "opcion 4":

                break;

            default:

                break;

        }

        //Usamos el valor de JTextField para pasarlo a baseDiaria como un float.    
        this.baseDiaria = Float.parseFloat(baseDiaria.getText());

       
        /*
        Iniciamos el procesamiento de las fechas.
        */
        
        GregorianCalendar fBajaMedica = new GregorianCalendar();
        fBajaMedica.setTime(fInicio.getDate());

        GregorianCalendar fAltaMedica = new GregorianCalendar();
        fAltaMedica.set(
                fFinal.getCalendar().get(Calendar.YEAR),
                fFinal.getCalendar().get(Calendar.MONTH),
                fFinal.getCalendar().get(Calendar.DAY_OF_MONTH), 23, 59, 59);

        GregorianCalendar fechaNominaActual = new GregorianCalendar();
        this.diasMesActual = fechaNominaActual.getActualMaximum(Calendar.DAY_OF_MONTH);
        this.diasGastadosNominasAnteriores = (int) Fechas.diferenciaDosGregorian(fBajaMedica, fechaNominaActual);
        this.totalDiasIT = Math.round(logica.Fechas.diferenciaDosGregorian(fBajaMedica, fAltaMedica));
        this.mensualDiasIT = this.totalDiasIT - this.diasGastadosNominasAnteriores;
        if (this.mensualDiasIT >= diasMesActual) this.mensualDiasIT = diasMesActual;
        

        if (this.totalDiasIT <= 3) {
            this.diasTramo[0] = this.totalDiasIT;
        } else if (this.totalDiasIT > 3 && this.totalDiasIT <= 15) {
            this.diasTramo[0] = 3;
            this.diasTramo[1] = this.totalDiasIT - this.diasTramo[0];
        } else if (this.totalDiasIT > 15 && this.totalDiasIT <= 20) {
            this.diasTramo[0] = 3;
            this.diasTramo[1] = 12;
            this.diasTramo[2] = this.totalDiasIT - this.diasTramo[0] - this.diasTramo[1];

        } else {
            this.diasTramo[0] = 3;
            this.diasTramo[1] = 12;
            this.diasTramo[2] = 5;
            this.diasTramo[3] = this.totalDiasIT - this.diasTramo[0] - this.diasTramo[1] - this.diasTramo[2];
        }

        //El siguiente bucle FOR asigna los euros a cada uno de los tramos existentes.
        for (int i = 0; i < eurosTramo.length; i++) {
            this.eurosTramo[i] = (this.diasTramo[i] * this.baseDiaria * (this.porcTramo[i] / 100));
        }
        //El siguiente bucle FOR asigna los euros a cada uno de los tramos de complementos existentes.
        for (int i = 0; i < complTramo.length; i++) {
            this.complTramo[i] = (this.diasTramo[i] * this.baseDiaria * (this.complTramo[i] / 100));
        }

    }

}
