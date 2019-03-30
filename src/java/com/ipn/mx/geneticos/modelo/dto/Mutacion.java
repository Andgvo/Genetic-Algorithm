package com.ipn.mx.geneticos.modelo.dto;

/**
 *
 * @author andres
 */
public interface Mutacion<E extends Cromosoma> {
    public E mutar(E cromosoma);
    public Poblacion<E> mutarPoblacion(Poblacion<E> poblacion);
}
