package com.ipn.mx.geneticos.modelo.dto;

import com.ipn.mx.geneticos.utilerias.Rango;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 * @param <T> extends Cromosoma
 */
public class Metodo<T extends Cromosoma> {
    private BigDecimal numeroIndividuos;
    private int numeroGeneraciones;
    private Rango rango;
    private Seleccion metodoSeleccion;
    private Mutacion tipoMutacion;
    private Class tipoIndividuo;
    private Poblacion<T> padres;
    private Poblacion<T> hijos;
    private List<Poblacion<T>> generaciones;

    public Metodo(BigDecimal numeroIndividuos, int numeroGeneraciones, Rango rango, Seleccion metodoSeleccion, Mutacion tipoMutacion, Class tipoIndividuo, Poblacion<T> padres) {
        this.numeroIndividuos = numeroIndividuos;
        this.numeroGeneraciones = numeroGeneraciones;
        this.rango = rango;
        this.metodoSeleccion = metodoSeleccion;
        this.tipoMutacion = tipoMutacion;
        this.tipoIndividuo = tipoIndividuo;
        this.padres = padres;
        generaciones = new ArrayList<>();
    }

    public Metodo(BigDecimal numeroIndividuos, int numeroGeneraciones, Rango rango, Seleccion metodoSeleccion, Mutacion tipoMutacion, Class tipoIndividuo) {
        this.numeroIndividuos = numeroIndividuos;
        this.numeroGeneraciones = numeroGeneraciones;
        this.rango = rango;
        this.metodoSeleccion = metodoSeleccion;
        this.tipoMutacion = tipoMutacion;
        this.tipoIndividuo = tipoIndividuo;
        Poblacion nueva = new Poblacion(tipoIndividuo, numeroIndividuos, rango);
        padres = Poblacion.getAleatoria(numeroGeneraciones);
        generaciones = new ArrayList<>();
    }
    
    public void executeGenetico(){
        for(int i = 0; i < numeroGeneraciones; i++){
            
        }
    }
    
    public static void main(String[] args) {
        Rango rango = new Rango(1, 10);
        BigDecimal num = new BigDecimal(10);
        Seleccion ruleta = new Ruleta();
        //Metodo ruletaBits = new Metodo(num,3,rango, ruleta);
        //mr.execute();
    }
}
