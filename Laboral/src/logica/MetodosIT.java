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
    

    public int diasDelMesActual;
    public int diasDeEsteMesEnIT;
    public int diasTotalesEnIT;
    public float baseDiaria;
    public int diasAnterioresEnIT;
    
    public int[]    diasTramo   = {0, 0, 0, 0};
    public float[]  eurosTramo  = {0, 0, 0, 0};
    public float[]  porcTramo   = {0, 60, 60, 75};
    public float[]  complTramo  = {0, 0, 0, 0};

    public void objetoIncTmp(JDateChooser fInicio, JDateChooser fFinal, JTextField baseDiaria, JComboBox convenio, JMonthChooser mesActual, JYearChooser anoActual) {

        String normaAplicable = (String) convenio.getSelectedItem();

        switch (normaAplicable) {

            case "Estatuto de los trabajadores":

                this.complTramo[0] = 0;
                this.complTramo[1] = 0;
                this.complTramo[2] = 0;
                this.complTramo[3] = 0;
                break;

            case "Complemento al 100%":

                this.complTramo[0] = 100;
                this.complTramo[1] = 40;
                this.complTramo[2] = 40;
                this.complTramo[3] = 25;
                break;

            case "Construcción Cádiz":

                this.complTramo[0] = 0;
                this.complTramo[1] = 0;
                this.complTramo[2] = 0;
                this.complTramo[3] = 25;
                break;

            case "Construccion Sevilla":

                break;

            default:

                break;

        }

        //Usamos el valor de JTextField para pasarlo a baseDiaria como un float.    
        this.baseDiaria = Float.parseFloat(baseDiaria.getText());

       
        /*
        Iniciamos el procesamiento de las fechas.
        */

        //Usamos el argumento fInicio para establecer la fecha de la baja médica
        GregorianCalendar fBajaMedica = new GregorianCalendar();
        fBajaMedica.setTime(fInicio.getDate());

        //Usamos el argumento fFinal para establecer la fecha de la baja médica
        // y le añadimos las 24h del día para que los cálculos cuadren.
        GregorianCalendar fAltaMedica = new GregorianCalendar();
        fAltaMedica.set(
                fFinal.getCalendar().get(Calendar.YEAR),
                fFinal.getCalendar().get(Calendar.MONTH),
                fFinal.getCalendar().get(Calendar.DAY_OF_MONTH), 23, 59, 59);

        //Establecemos la fecha de la nómina que estamos calculando, usando los argumentos
        //pasados en las variables anoActual y mesActual.
        GregorianCalendar fechaNominaActual = new GregorianCalendar();
        fechaNominaActual.set (
                anoActual.getYear(),
                mesActual.getMonth(),
                1, 0, 0 ,0
        );
        
        this.diasDelMesActual = fechaNominaActual.getActualMaximum(Calendar.DAY_OF_MONTH);
        this.diasAnterioresEnIT = Fechas.difFechas(fBajaMedica, fechaNominaActual);
        this.diasTotalesEnIT = Fechas.difFechas(fBajaMedica, fAltaMedica);
        this.diasDeEsteMesEnIT = this.diasTotalesEnIT - this.diasAnterioresEnIT;
        
        if (this.diasDeEsteMesEnIT >= diasDelMesActual) this.diasDeEsteMesEnIT = diasDelMesActual;
        

        if (this.diasTotalesEnIT <= 3) {
            this.diasTramo[0] = this.diasTotalesEnIT;
        } else if (this.diasTotalesEnIT > 3 && this.diasTotalesEnIT <= 15) {
            this.diasTramo[0] = 3;
            this.diasTramo[1] = this.diasTotalesEnIT - this.diasTramo[0];
        } else if (this.diasTotalesEnIT > 15 && this.diasTotalesEnIT <= 20) {
            this.diasTramo[0] = 3;
            this.diasTramo[1] = 12;
            this.diasTramo[2] = this.diasTotalesEnIT - this.diasTramo[0] - this.diasTramo[1];

        } else {
            this.diasTramo[0] = 3;
            this.diasTramo[1] = 12;
            this.diasTramo[2] = 5;
            this.diasTramo[3] = this.diasTotalesEnIT - this.diasTramo[0] - this.diasTramo[1] - this.diasTramo[2];
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
