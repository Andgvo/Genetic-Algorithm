
package com.ipn.mx.geneticos.modelo.dto.mutacion;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.ParseCromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.RandomC;
import java.util.List;

/**
 *
 * @author andres
 * @param <T>
 */
public class Intercambio <T extends Cromosoma> extends ParseCromosoma<T> implements Mutacion<T> {
    private static final RandomC RANDOM = new RandomC();
    private final int numElementos;
    private Poblacion<T> hijos;
    private T individuo;
    private List<Integer> indices;
    
    public Intercambio(int numElementos, Class<T> type) {
        super(type);
        this.numElementos = numElementos;
    }

    @Override
    public T mutar( T cromosoma ) {
        indices = RANDOM.cortesRandomDesorden(0, Cromosoma.longitud-1, numElementos );
        for(int i = 0; i < numElementos ; i+=2){
            byte alelo1 = cromosoma.getCadenaBinaria().get( indices.get(i) );
            byte alelo2 = cromosoma.getCadenaBinaria().get( indices.get(i+1) );
            cromosoma.getCadenaBinaria().set( indices.get(i), alelo2 );
            cromosoma.getCadenaBinaria().set( indices.get(i+1), alelo1 );
        }
        individuo = instanciaDeCromosoma(cromosoma.getCadenaBinaria());
        return individuo;
    }

    @Override
    public Poblacion<T> mutarPoblacion(Poblacion<T> poblacion) {
        hijos = new Poblacion(type);
        poblacion.forEach((cromosoma) -> {
            hijos.add(mutar( (T) cromosoma));
        });
        return hijos;
    }
}