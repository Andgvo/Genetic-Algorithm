package com.ipn.mx.geneticos.modelo.dto;

/**
 *
 * @author andres
 */
public interface Mutacion {
    public Cromosoma mutar();
    public Poblacion mutarPoblacion(Poblacion poblacion);
}
