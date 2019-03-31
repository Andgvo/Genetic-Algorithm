
package com.ipn.mx.geneticos.modelo.dto.cruza;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.ParseCromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;

/**
 *
 * @author andres
 * @param <T>
 */
public class NPuntos<T extends Cromosoma> extends ParseCromosoma implements Cruza<T>{

    public NPuntos(Class type) {
        super(type);
    }

    @Override
    public void cruzar(T cromosoma1, T cromosoma2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Poblacion<T> cruzarPoblacion(Poblacion<T> poblacion) {
        Poblacion<T> decendientes = new Poblacion<>(type);
        for(int i=0; i < poblacion.size(); i+=2){
            
        }
        return decendientes;
    }
    
}
