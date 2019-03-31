
package com.ipn.mx.geneticos.modelo.dto.seleccion;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;

/**
 *
 * @author Andres
 * @param <T>
 */
public interface Seleccion<T extends Cromosoma> {
    public Poblacion execute(Poblacion<T> padres);
}
