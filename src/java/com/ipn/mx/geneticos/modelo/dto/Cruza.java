
package com.ipn.mx.geneticos.modelo.dto;

import java.util.List;

/**
 * Utileria de técnicas de Cruzamiento
 * @author Andres
 */
public abstract class Cruza {
    
    public static boolean cruzaSimple(List vector1, List vector2, int  indiceCruza){
       if(vector1.size() > indiceCruza && vector2.size() > indiceCruza)
           
           return true;
       return false;
    }
    
    public static void main(String[] args) {
        
    }
}
