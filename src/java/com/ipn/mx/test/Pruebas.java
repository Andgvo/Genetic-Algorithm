
package com.ipn.mx.test;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import java.math.BigDecimal;

/**
 *
 * @author andres
 */
public class Pruebas {
    public static void convertir(Cromosoma cromosoma){
        cromosoma.setAptitud(BigDecimal.TEN);
    }
    
    public static void main(String[] args) {
        Poblacion<Cromosoma> p = Poblacion.parseToCromosoma(
                "01101,11000,01000,10011,10111,01111",Cromosoma.class);
        System.out.println(p.imprimirPoblacion());
        convertir( p.get(0) );
        System.out.println(p.imprimirPoblacion());
        System.out.println(p.imprimirPoblacion());
    }
}
