package com.ipn.mx.geneticos.modelo.dao;

import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.tecnica.ruleta.Ruleta;
import com.ipn.mx.geneticos.utilerias.QuicksortC;

/**
 *
 * @author Andres
 */
public class RuletaDAO {
    private Ruleta ruleta;
    
    public RuletaDAO(){
        ruleta = new Ruleta(10);
    }
    
    public Ruleta getRuleta(){
        return ruleta;
    }
    
    public void setRuleta(int numElement){
        ruleta = new Ruleta(numElement);
    }
    
    public void setRango(int valorInicio, int valorFinal){
        ruleta.getPoblacion().setRangos(valorInicio, valorFinal);
    }
    
    public Poblacion getPoblacionAleaotria(){
        return ruleta.getPoblacion();
    }
    
    public Poblacion quicksort(Poblacion lista){
        return QuicksortC.quicksort(lista);
    }
}
