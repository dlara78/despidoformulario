package DespidoFormulario;

import java.text.DateFormat;
import java.util.GregorianCalendar;
import static DespidoFormulario.Trabajador.MILISEGS_POR_DIA;

public class Informes {

    public static String informeCausaObjetiva(
            String tipoDespido, String fechaAlta, String fechaBaja,
            String bCotiz, String diasCotizados) {

        float antiguedadTotal = MetodosFechas.calcularFloatEntreDosFechasString(fechaBaja, fechaAlta);
        float bCotizDiaria = Float.valueOf(bCotiz) / Float.valueOf(diasCotizados);
        float numDiasIndemnizacion = MetodosFechas.calculaDiasIndemnObjetiva(antiguedadTotal);
        float importeIndemnizacion = MetodosFechas.calculaImporteIndemnObjetiva(numDiasIndemnizacion, bCotizDiaria);

        //GregorianCalendar (int AÑO, int MES-1, int DIA, int HORA, int MINUTOS)
        GregorianCalendar fechaInicial = new GregorianCalendar(2012, 0, 1, 0, 0);
        GregorianCalendar reforma = new GregorianCalendar(2012, 1, 12, 23, 59);
        GregorianCalendar fechaFinal = new GregorianCalendar(2012, 11, 31, 23, 59);
        
        float antiguedadCalendar = (fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis())/MILISEGS_POR_DIA;
        
        String informe = ("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nALTA: " + MetodosFechas.convertirAFechaBonita(fechaAlta)
                + "\nBAJA: " + MetodosFechas.convertirAFechaBonita(fechaBaja)
                + "\n(Antigüedad total: " + MetodosFormatos.darFormatoEsp(antiguedadTotal) + " dias)"
                + "\nLa base de cotización diaria es: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias\n"
                + "\nEl número de días de indemnización es: " + MetodosFormatos.darFormatoEsp(numDiasIndemnizacion)
                + "\nEl importe de la indemnización es: " + MetodosFormatos.darFormatoMoneda(importeIndemnizacion)
                + "\n\n\nAntigüedad metodo DANI: " 
                + MetodosFechas.calcularAntiguedad(
                        MetodosFechas.convertirFechaStringAGregorian(fechaAlta), //Argumento #1
                        MetodosFechas.convertirFechaStringAGregorian(fechaBaja)) //Argumento #2
                + "\n\n\nAntiguedad con Calendar completa: " + MetodosFormatos.darFormatoEsp(antiguedadCalendar)
                
                );

        return informe;
    }

    public static String informeImprocedente(
            String tipoDespido, String fechaAlta, String fechaBaja,
            String bCotiz, String diasCotizados) {

        float antiguedadTotal = 0;
        float reformaMilis = MetodosFechas.calcularFechaEnMilis("12/02/2012");
        float fAltaMilis = MetodosFechas.calcularFechaEnMilis(fechaAlta);
        float fBajaMilis = MetodosFechas.calcularFechaEnMilis(fechaBaja);
        float bCotizDiaria = Float.valueOf(bCotiz) / Float.valueOf(diasCotizados);
        float numDiasIndemnizacion = MetodosFechas.calculaDiasIndemnObjetiva(antiguedadTotal);
        float importeIndemnizacion = MetodosFechas.calculaImporteIndemnObjetiva(numDiasIndemnizacion, bCotizDiaria);
        float diasHastaReforma = MetodosFechas.diasHastaReforma(fechaAlta);
        float diasDesdeReforma = MetodosFechas.diasDesdeReforma(fechaBaja);
        
        if ( fAltaMilis > reformaMilis){
            
            antiguedadTotal = MetodosFechas.calcularFloatEntreDosFechasString(fechaBaja, fechaAlta);
            diasHastaReforma = 0;
            diasDesdeReforma = antiguedadTotal;
            
            
        } else if (fBajaMilis < reformaMilis){
            
            antiguedadTotal = MetodosFechas.calcularFloatEntreDosFechasString(fechaBaja, fechaAlta);
            diasHastaReforma = antiguedadTotal;
            diasDesdeReforma = 0;
                    
            
        };
        
        
        
        
        
        
        String informe = ("Iniciando informe...\n"
                + "\nTipo de despido: " + tipoDespido
                + "\nALTA: " + MetodosFechas.convertirAFechaBonita(fechaAlta)
                + "\nBAJA: " + MetodosFechas.convertirAFechaBonita(fechaBaja)
                + "\n\n(Antigüedad total: " + (MetodosFormatos.darFormatoEsp(diasDesdeReforma + diasHastaReforma) + " dias)"
                + "\nAntigüedad antes de reforma: " + MetodosFormatos.darFormatoEsp(diasHastaReforma)
                + "\nAntigüedad después de reforma: " + MetodosFormatos.darFormatoEsp(diasDesdeReforma)
                + "\n\nLa base de cotización diaria es: " + MetodosFormatos.darFormatoMoneda(bCotizDiaria) + "/dias\n"
                + "\nEl número de días de indemnización es: <pendiente>"
                + "\nEl importe de la indemnización es: <pendiente>"
                )
                );

        return informe;
    }

}
