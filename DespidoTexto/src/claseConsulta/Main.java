/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package despido04;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Main {

    @SuppressWarnings("empty-statement")
    public static void main(String args[]) {
        // TODO code application logic here

        int opcionElegida = 0;
        Scanner scan_Opcion = new Scanner(System.in);
        
        do {
            /* Repetimos este codigo hasta que el usuario seleccione la opcion 3 */
            System.out.println("Introduzca la opción deseada:");
            System.out.println("(1) - Calcular Despido");
            System.out.println("(2) - Introducir datos personales");
            System.out.println("(3) - Salir de la aplicación");
            opcionElegida = scan_Opcion.nextInt();
            
            
            switch (opcionElegida) {
                case 1:
                    /* Realizamos las acciones correspondientes a "Calcular Despido" */
                    System.out.println("Calcular Antiguedad...");

                    /* Empezamos obteniendo las fechas para poder realizar el calculo de antiguedad */
                    GregorianCalendar FechaAlta = LecturaDatosTmp.readFecha("FECHA DE ALTA");
                    GregorianCalendar FechaBaja = LecturaDatosTmp.readFecha("FECHA DE BAJA");

                    float diasIndemnizacion = Empleado.getDiasIndemnizacion(FechaAlta, FechaBaja);
                    
                   
                    /*revisar esta linea*/
                    Tramos[] var_tramos = MetodosAuxiliares.getTramo();
                    
                    break;
                
                case 2:
                    /* Realizamos las acciones correspondientes a "Introducir datos personales" */
                    System.out.println("Introducir datos personales...");
                    break;
                
            };
        } while (opcionElegida != 3);
    }
}
