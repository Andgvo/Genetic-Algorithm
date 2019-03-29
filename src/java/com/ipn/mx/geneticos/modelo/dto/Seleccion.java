
package com.ipn.mx.geneticos.modelo.dto;

/**
 *
 * @author Andres
 */
public interface Seleccion<T extends Cromosoma> {
    public Poblacion execute(Poblacion<T> padres);
}
