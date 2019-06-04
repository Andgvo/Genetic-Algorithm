
package com.ipn.mx.geneticos.utilerias;

import java.math.BigDecimal;

/**
 *  Interfas en donde defines la función fitness que sera evaluada durante el
 *  algoritmo Genético
 * @author andres
 */
public interface Funcion{
    public BigDecimal f(BigDecimal x);
}
