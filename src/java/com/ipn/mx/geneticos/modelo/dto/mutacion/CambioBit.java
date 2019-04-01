package com.ipn.mx.geneticos.modelo.dto.mutacion;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.ParseCromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.RandomC;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author andres
 * @param <T extends Cromosoma>
 */
public class CambioBit<T extends Cromosoma> extends ParseCromosoma<T> implements Mutacion<T>{
    private static final RandomC RANDOM = new RandomC();
    private BigDecimal porcentaje;
    //Mejorar memoria
    private Poblacion<T> hijos;
    private T individuo;
    private List<Integer> indices;
    
    public CambioBit(Class type, String porcentajeSting) {
        super(type);
        //Pasando cantidad a porcentaje dividiendo entre 100
        porcentaje = new BigDecimal(porcentajeSting).movePointLeft(2);
        //Equivalente en porcentaje
        porcentaje =  porcentaje.multiply(new BigDecimal(Cromosoma.longitud));
    }

    @Override
    public T mutar( T cromosoma ) {
        indices = RANDOM.cortesRandom(0, Cromosoma.longitud-1, porcentaje.intValue());
        indices.forEach((indice) -> {
            byte alelo = (byte) (cromosoma.getCadenaBinaria().get(indice)^(byte)1);
            cromosoma.getCadenaBinaria().set(indice, alelo);
        });
        individuo = instanciaDeCromosoma(cromosoma.getCadenaBinaria());
        return individuo;
    }

    @Override
    public Poblacion<T> mutarPoblacion(Poblacion<T> poblacion) {
        hijos = new Poblacion(type);
        poblacion.forEach((cromosoma) -> {
            hijos.add(mutar( (T) cromosoma));
        });
        return hijos;
    }
    
}