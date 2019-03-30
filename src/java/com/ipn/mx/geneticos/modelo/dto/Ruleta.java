
package com.ipn.mx.geneticos.modelo.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 *
 * @author andres
 */
public class Ruleta<T extends Cromosoma> extends ParseCromosoma<Cromosoma> implements Seleccion{

    public Ruleta(Class<Cromosoma> type) {
        super(type);
    }

    @Override
    public Poblacion execute(Poblacion padres) {
        //Se multiplica por 100 para posteriormente obtener decimales
        int sumatoriaVe = padres.getSumatoriaVe().intValue() * 100;
        BigDecimal cien = new BigDecimal(100);
        BigDecimal numeroRandom;
        BigDecimal r;
        Poblacion<T> nuevosPadres = new Poblacion(type);
        for(int i = 0; i < padres.size() ; i++){
            numeroRandom = new BigDecimal( new Random().nextInt( sumatoriaVe) );
            r = numeroRandom.divide( cien , 2, RoundingMode.HALF_UP );
            Cromosoma c = seleccion(padres, r);
            nuevosPadres.add(c);
        }
        return nuevosPadres;
    }
    
    private T seleccion(Poblacion poblacion, BigDecimal r){
        T individuo = null;
        for(Object cromosoma: poblacion){
            individuo = (T) cromosoma;
            if(individuo.getProbabilidadAcumulada().doubleValue() >  r.doubleValue() )
                return (T) instanciaDeCromosoma(individuo.getValorReal());
        }
        return individuo;
    }
}
