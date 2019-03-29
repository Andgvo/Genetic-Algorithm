
package com.ipn.mx.geneticos.modelo.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 *
 * @author andres
 */
public class Ruleta extends ParseCromosoma<Cromosoma> implements Seleccion{

    public Ruleta(Class<Cromosoma> type) {
        super(type);
    }

    @Override
    public Poblacion execute(Poblacion padres) {
        //Se multiplica por 100 para posteriormente obtener decimales
        int promedioVe = padres.getSumatoriaVe().intValue() * 100;
        BigDecimal cien = new BigDecimal(100);
        BigDecimal numeroRandom;
        BigDecimal r;
        int i = 0;
        System.out.println("promedioVe = "+promedioVe);
        for(Object individuo: padres){
            numeroRandom = new BigDecimal( new Random().nextInt( promedioVe) );
            r = numeroRandom.divide( cien , 2, RoundingMode.HALF_UP );
            System.out.println("num"+i+": "+r);
            i++;
        }
        return null;
    }
    
}
