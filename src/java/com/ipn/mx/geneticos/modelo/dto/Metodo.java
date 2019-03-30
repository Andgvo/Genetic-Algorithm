package com.ipn.mx.geneticos.modelo.dto;

import com.ipn.mx.geneticos.utilerias.FuncCuadrado;
import com.ipn.mx.geneticos.utilerias.Funcion;
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
    private Funcion funcion;
    private Seleccion metodoSeleccion;
    private Mutacion tipoMutacion;
    private Class tipoIndividuo;
    private Poblacion<Cromosoma> padres;
    private Poblacion<Cromosoma> padresSeleccionados;
    private Poblacion<Cromosoma> hijos;
    private List<Poblacion<Cromosoma>> generaciones;

    public Metodo(BigDecimal numeroIndividuos, int numeroGeneraciones, Rango rango,
            Funcion funcion, Seleccion metodoSeleccion, Mutacion tipoMutacion,
                Poblacion<Cromosoma> padres, Class tipoIndividuo) {
        this.numeroIndividuos = numeroIndividuos;
        this.numeroGeneraciones = numeroGeneraciones;
        this.rango = rango;
        this.funcion = funcion;
        this.metodoSeleccion = metodoSeleccion;
        this.tipoMutacion = tipoMutacion;
        this.tipoIndividuo = tipoIndividuo;
        this.padres = padres;
        generaciones = new ArrayList<>();
    }

    public Metodo(BigDecimal numeroIndividuos, int numeroGeneraciones, Rango rango,
            Funcion funcion, Seleccion metodoSeleccion, Mutacion tipoMutacion, Class tipoIndividuo) {
        this.numeroIndividuos = numeroIndividuos;
        this.numeroGeneraciones = numeroGeneraciones;
        this.rango = rango;
        this.funcion = funcion;
        this.metodoSeleccion = metodoSeleccion;
        this.tipoMutacion = tipoMutacion;
        this.tipoIndividuo = tipoIndividuo;
        padres = new Poblacion(tipoIndividuo, numeroIndividuos, rango);
        generaciones = new ArrayList<>();
    }
    
    public Metodo(BigDecimal numeroIndividuos, int numeroGeneraciones, Rango rango,
            Funcion funcion, Seleccion metodoSeleccion, Mutacion tipoMutacion,
                String padres, Class tipoIndividuo) {
        this.numeroIndividuos = numeroIndividuos;
        this.numeroGeneraciones = numeroGeneraciones;
        this.rango = rango;
        this.funcion = funcion;
        this.metodoSeleccion = metodoSeleccion;
        this.tipoMutacion = tipoMutacion;
        this.tipoIndividuo = tipoIndividuo;
        this.padres = Poblacion.parseToCromosoma(
                "01101,11000,01000,10011,10111,01111",tipoIndividuo);
        generaciones = new ArrayList<>();
    }
    
    public void executeGenetico(){
        for(int i = 0; i < numeroGeneraciones; i++){
            padres.evaluarPoblacion(funcion);
            padres.setValoresEsperados();
            padresSeleccionados = metodoSeleccion.execute(padres);
            //hijos = tipoMutacion.mutar(padresSeleccionados);
            //generaciones.add(Collections.);
            //padres = hijos;
            System.out.println(padres.imprimirPoblacion());
            System.out.println(padres);
            padresSeleccionados.evaluarPoblacion(funcion);
            padresSeleccionados.setValoresEsperados();
            System.out.println(padresSeleccionados.imprimirPoblacion());
            System.out.println(padresSeleccionados);
        }
    }
    
    public static void main(String[] args) {
        BigDecimal numeroCromosomas = new BigDecimal(6);
        Cromosoma.longitud = 5;
        int numeroGeneraciones = 1;
        Rango rango = new Rango(1, 10);
        Funcion f2 = new FuncCuadrado();
        Seleccion<Cromosoma> ruleta = new Ruleta<>(Cromosoma.class);
        Mutacion<Cromosoma> simple = new MutacionSimple<>(Cromosoma.class);
        Metodo<Cromosoma> ruletaBits = 
            new Metodo(numeroCromosomas,numeroGeneraciones,rango, f2,
                ruleta, simple, "01101,11000,01000,10011,10111,01111", Cromosoma.class);
        //Definimos la longitud de la cadena
        
        ruletaBits.executeGenetico();
        //mr.execute();
    }
}