package com.ipn.mx.geneticos.modelo.dto;

import com.ipn.mx.geneticos.tecnica.ruleta.Ruleta;
import com.ipn.mx.geneticos.utilerias.Rango;
import java.math.BigDecimal;

/**
 *
 * @author Andres
 */
public class Metodo<T extends Cromosoma> {
    private BigDecimal numeroIndividuos;
    private Rango rango;
    private Seleccion metodoSeleccion;
    private Poblacion padres;
    private Poblacion hijos;

    public Metodo(BigDecimal numeroIndividuos, Rango rango) {
        this.numeroIndividuos = numeroIndividuos;
        this.rango = rango;
          
    }
    
    public void execute(){
        
    }
    
    public static void main(String[] args) {
        Rango rango = new Rango(1, 10);
        BigDecimal num = new BigDecimal(20);
        Metodo mr = new Metodo(num,rango);
        mr.execute();
    }
}
