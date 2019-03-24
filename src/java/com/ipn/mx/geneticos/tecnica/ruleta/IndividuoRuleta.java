package com.ipn.mx.geneticos.tecnica.ruleta;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author andres
 */
public final class IndividuoRuleta extends Cromosoma {
    private BigDecimal valorEsperado;

    public IndividuoRuleta(BigDecimal valorX) {
        super(valorX);
        aptitud = Ruleta.funcion(valorX);
        valorEsperado = new BigDecimal(BigInteger.ZERO);
    }

    public BigDecimal getValorEsperado() {
        return valorEsperado;
    }
    
    public void setValorEsperado(BigDecimal valorEsperado){
        this.valorEsperado = valorEsperado;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Cadena: ").append(getCadenaBinariaR())
        .append("\tx: ").append(valorReal)
        .append("\taptitud: ").append(aptitud)
        .append("\tVe: ").append(valorEsperado);
        return str.toString();
    }
    
    
}