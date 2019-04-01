package com.ipn.mx.geneticos.modelo.dto.mutacion;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;

/**
 *
 * @author andres
 * @param <E extends Cromosoma>
 */
public interface Mutacion<E extends Cromosoma> {
    public E mutar(E cromosoma);
    public Poblacion<E> mutarPoblacion(Poblacion<E> poblacion);
}