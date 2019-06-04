  
package com.ipn.mx.geneticos.modelo.dao;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.QuicksortC;

/**
 *
 * @author Andres
 */
public class CromosomaDAO {
    public Poblacion getPoblacionAleaotria(int num, int longitud, int min, int max){
        return Poblacion.getAleatoria(num,longitud, min, max, Cromosoma.class);
    }
    
    public Poblacion getPoblacionExtendida(int num, int longitud, int min, int max){
        return Poblacion.getAleatoriaExtendida(num,longitud, min, max);
    }
    
    public Poblacion quicksort(Poblacion lista){
        return QuicksortC.quicksort(lista);
    }
}
