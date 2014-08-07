package despido2;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class DespidoTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcionElegida = 0;
        Scanner scan_Opcion = new Scanner(System.in);
        NewJFrame formulario = new NewJFrame();
        do {
            /* Repetimos este codigo hasta que el usuario seleccione la opcion 3 */
            System.out.println("\nIntroduzca la opción deseada:");
            System.out.println("(1) - Calcular Despido");
            System.out.println("(2) - Lanzar ventana");
            System.out.println("(3) - Salir de la aplicación");
            opcionElegida = scan_Opcion.nextInt();

            switch (opcionElegida) {
                case 1:
                    /* Realizamos las acciones correspondientes a "Calcular Despido" */
                    System.out.println("Calcular Antiguedad...");

                    /* Empezamos obteniendo las fechas para poder realizar el calculo de antiguedad */
                    GregorianCalendar FechaAlta = LecturaDatosTmp.readFecha("FECHA DE ALTA", 0, 0, 0);
                    GregorianCalendar FechaBaja = LecturaDatosTmp.readFecha("FECHA DE BAJA", 23, 59, 59);

                    //float diasIndemnizacion = Empleado.getDiasIndemnizacion(FechaAlta, FechaBaja);

                    /*revisar esta linea*/
                    //Tramos[] var_tramos = MetodosAuxiliares.getTramo();

                    break;

                case 2:
                    /* Realizamos las acciones correspondientes a "Introducir datos personales" */
                    NewJFrame ventana = new NewJFrame();
                    break;

            };
        } while (opcionElegida != 3);
    }
    
}
