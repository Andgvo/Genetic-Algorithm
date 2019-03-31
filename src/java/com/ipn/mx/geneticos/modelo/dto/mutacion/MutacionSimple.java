package com.ipn.mx.geneticos.modelo.dto.mutacion;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.ParseCromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import java.math.BigDecimal;

/**
 *
 * @author andres
 * @param <T extends Cromosoma>
 */
public class MutacionSimple<T extends Cromosoma> extends ParseCromosoma<T> implements Mutacion<T>{

    public MutacionSimple(Class type) {
        super(type);
    }

    @Override
    public T mutar(T cromosoma) {
        T individuo = instanciaDeCromosoma(BigDecimal.ZERO);
        return individuo;
    }

    @Override
    public Poblacion<T> mutarPoblacion(Poblacion<T> poblacion) {
        Poblacion<T> hijos = new Poblacion(type);
        poblacion.forEach((cromosoma) -> {
            hijos.add(mutar( (T) cromosoma));
        });
        return hijos;
    }
    
}
