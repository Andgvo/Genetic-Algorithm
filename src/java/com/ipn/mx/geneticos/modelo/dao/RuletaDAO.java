package com.ipn.mx.geneticos.modelo.dao;

import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.tecnica.ruleta.Ruleta;
import com.ipn.mx.geneticos.utilerias.QuicksortC;
import com.ipn.mx.geneticos.utilerias.Rango;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Andres
 */
public class RuletaDAO {
    private Ruleta ruleta;
    private Rango rango;
    private BigDecimal numeroIndividuos;
    
    public RuletaDAO(){
        rango = new Rango(1,10);
        numeroIndividuos = new BigDecimal(10);
        ruleta = new Ruleta(numeroIndividuos,rango);
    }
    
    public Ruleta getRuleta(){
        return ruleta;
    }
    
    public void setRuleta(BigDecimal numeroIndividuos, Rango rango){
        ruleta = new Ruleta(numeroIndividuos, rango);
    }
    
    public Poblacion getPoblacionAleaotria(){
        return ruleta.getPoblacion();
    }
    
    public Poblacion quicksort(Poblacion lista){
        return QuicksortC.quicksort(lista);
    }
}
