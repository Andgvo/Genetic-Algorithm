package com.ipn.mx.geneticos.modelo.dto;

import java.math.BigDecimal;

/**
 *
 * @author andres
 * @param <T extends Cromosoma>
 */
public class MutacionSimple<T extends Cromosoma> extends ParseCromosoma<T> implements Mutacion{

    public MutacionSimple(Class type) {
        super(type);
    }

    @Override
    public T mutar(Cromosoma cromosoma) {
        T individuo = instanciaDeCromosoma(BigDecimal.ZERO);
        return individuo;
    }

    @Override
    public Poblacion<T> mutarPoblacion(Poblacion poblacion) {
        Poblacion<T> hijos = new Poblacion(type);
        poblacion.forEach((cromosoma) -> {
            hijos.add(mutar( (T) cromosoma));
        });
        return hijos;
    }
    
}
