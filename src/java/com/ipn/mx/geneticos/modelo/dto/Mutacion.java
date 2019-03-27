package com.ipn.mx.geneticos.modelo.dto;

/**
 *
 * @author andres
 */
public interface Mutacion {
    public Cromosoma mutar(Cromosoma cromosoma);
    public Poblacion mutarPoblacion(Poblacion<Cromosoma> poblacion);
}
