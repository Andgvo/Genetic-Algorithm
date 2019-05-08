package com.ipn.mx.geneticos.modelo.dto.mutacion;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.ParseCromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.RandomC;
import java.util.List;

/**
 * Técnica de desplazamient ( forma extendida del metodo de inserción) retorna 
 * una población aplicando el valor especificado de elementos a realizar 
 * inserción.
 * @author andres
 * @param <T extends Cromosoma>
 */
public class Desplazamiento<T extends Cromosoma> extends ParseCromosoma<T> implements Mutacion<T> {
    private static final RandomC RANDOM = new RandomC();
    private final int numElementos;
    private Poblacion<T> hijos;
    private T individuo;
    private List<Integer> indices;
    private List<Integer> posicion;
    
    public Desplazamiento(int numElementos, Class<T> type) {
        super(type);
        this.numElementos = numElementos;
    }

    @Override
    public T mutar( T cromosoma ) {
        indices = RANDOM.cortesRandom(0, Cromosoma.longitud-1, numElementos );
        posicion = RANDOM.cortesRandom(0, Cromosoma.longitud-1, numElementos );
        System.out.println(indices);
        System.out.println(posicion);
        System.out.println(cromosoma.getCadenaBinaria());
        for(int i = 0; i < indices.size(); i++){
            byte alelo = cromosoma.getCadenaBinaria().get( indices.get(i) );
            cromosoma.getCadenaBinaria().add(posicion.get(i), alelo);
            cromosoma.getCadenaBinaria().remove( indices.get(i) + 1);
        }
        System.out.println(cromosoma.getCadenaBinaria());
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