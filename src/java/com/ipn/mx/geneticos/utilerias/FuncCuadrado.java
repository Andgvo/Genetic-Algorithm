package com.ipn.mx.geneticos.utilerias;

import java.math.BigDecimal;

/**
 *  Funcion fitness x^2
 * @author andres
 */
public final class FuncCuadrado implements Funcion {

    @Override
    public BigDecimal f(BigDecimal x) {
        return x.multiply(x);
    }

}
