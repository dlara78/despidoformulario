/*
 * Copyright (C) 2015 david
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package IncTemp;

import java.util.GregorianCalendar;

/**
 *
 * @author david
 */
public class ProcesoIT {

    private final String nombre;
    private final GregorianCalendar fBaja;
    private final GregorianCalendar fAlta;
    private final float baseDiaria;
    private final String convenioAplicacion;
    private float diasTramoUno = 0;
    private float diasTramoDos = 0;
    private float diasTramoTres = 0;
    private float diasTramoCuatro = 0;
    private float eurosTramoUno = 0;
    private float eurosTramoDos = 0;
    private float eurosTramoTres = 0;
    private float eurosTramoCuatro = 0;
    private float complTramoUno = 0;
    private float complTramoDos = 0;
    private float complTramoTres = 0;
    private float complTramoCuatro = 0;
    
    public ProcesoIT(GregorianCalendar fBaja, GregorianCalendar fAlta, float baseDiaria, String convenioAplicacion) {
        this.nombre = "Nombre";
        this.fBaja = fBaja;
        this.fAlta = fAlta;
        this.baseDiaria = baseDiaria;
        this.convenioAplicacion = convenioAplicacion;
        
        float diasTotalIT = MetodosComunes.MetodosFechas.diferenciaDosGregorian(fBaja, fBaja);
        
        if (diasTotalIT <= 3) {
            this.diasTramoUno = diasTotalIT;
            }
    }

    public float getDiasTramoUno() {
        return diasTramoUno;
    }

    public float getDiasTramoDos() {
        return diasTramoDos;
    }

    public float getDiasTramoTres() {
        return diasTramoTres;
    }

    public float getDiasTramoCuatro() {
        return diasTramoCuatro;
    }

    public float getEurosTramoUno() {
        return eurosTramoUno;
    }

    public float getEurosTramoDos() {
        return eurosTramoDos;
    }

    public float getEurosTramoTres() {
        return eurosTramoTres;
    }

    public float getEurosTramoCuatro() {
        return eurosTramoCuatro;
    }

    public float getComplTramoUno() {
        return complTramoUno;
    }

    public float getComplTramoDos() {
        return complTramoDos;
    }

    public float getComplTramoTres() {
        return complTramoTres;
    }

    public float getComplTramoCuatro() {
        return complTramoCuatro;
    }
    
    
}
