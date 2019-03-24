package com.ipn.mx.geneticos.tecnica.ruleta;

import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 *
 * @author andres
 */
public final class PoblacionRuleta extends Poblacion{

    public PoblacionRuleta(Class type) {
        super(type);
    }

    public PoblacionRuleta(Class type, List cromosomas) {
        super(type, cromosomas);
    }

    public PoblacionRuleta(Class type, int numElement) {
        super(type, numElement);
    }
    
    /*@Override
    public void getPoblacionAleatoria(int numElementos) {
        this.clear();
        IndividuoRuleta individuo;
        for (int i = 0; i < numElementos; i++) {
            individuo = new IndividuoRuleta(
                new BigDecimal( new Random().nextInt(12) )
            );
            this.add(individuo);
            sumatoriaF = sumatoriaF.add(individuo.getAptitud());
        }
    }*/

}
