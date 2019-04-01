package com.ipn.mx.geneticos.modelo.dto.cruza;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;

/**
 *
 * @author andres
 * @param <E extends Cromosoma>
 */
public interface Cruza <E extends Cromosoma>{
    public void cruzar(Poblacion<E> descendientes, E cromosoma1, E cromosoma2);
    public Poblacion<E> cruzarPoblacion(Poblacion<E> poblacion);
}
