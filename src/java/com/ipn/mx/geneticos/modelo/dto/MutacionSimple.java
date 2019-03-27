package com.ipn.mx.geneticos.modelo.dto;

/**
 *
 * @author andres
 */
public class MutacionSimple extends ParseCromosoma implements Mutacion{

    public MutacionSimple(Class type) {
        super(type);
    }

    @Override
    public Cromosoma mutar(Cromosoma cromosoma) {
        return cromosoma;
    }

    @Override
    public Poblacion mutarPoblacion(Poblacion<Cromosoma> poblacion) {
        poblacion.forEach((cromosoma) -> {
            mutar(cromosoma);
        });
        return poblacion;
    }
    
}
