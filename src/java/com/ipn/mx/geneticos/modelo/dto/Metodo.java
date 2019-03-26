package com.ipn.mx.geneticos.modelo.dto;

import com.ipn.mx.geneticos.utilerias.Rango;
import java.math.BigDecimal;

/**
 *
 * @author Andres
 * @param <T> extends Cromosoma
 */
public class Metodo<T extends Cromosoma> {
    private BigDecimal numeroIndividuos;
    private Rango rango;
    private Seleccion metodoSeleccion;
    private Poblacion<T> padres;
    private Poblacion<T> hijos;
    
    public Metodo(BigDecimal numeroIndividuos, Rango rango, Seleccion metoSeleccion) {
        this.numeroIndividuos = numeroIndividuos;
        this.rango = rango;
        this.metodoSeleccion = metodoSeleccion;
    }
    
    public void execute(){
        
    }
    
    public static void main(String[] args) {
        Rango rango = new Rango(1, 10);
        BigDecimal num = new BigDecimal(20);
        Seleccion ruleta = new Ruleta();
        Metodo mr = new Metodo(num,rango, ruleta);
        mr.execute();
    }
}
