  
package com.ipn.mx.geneticos.modelo.dao;

import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.QuicksortC;

/**
 *
 * @author Andres
 */
public class CromosomaDAO {
    public Poblacion getPoblacionAleaotria(int num){
        return Poblacion.getAleatoria(num);
    }
    
    public Poblacion quicksort(Poblacion lista){
        return QuicksortC.quicksort(lista);
    }
}
