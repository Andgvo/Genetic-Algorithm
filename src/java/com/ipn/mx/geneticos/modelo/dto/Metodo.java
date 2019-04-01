package com.ipn.mx.geneticos.modelo.dto;

import com.ipn.mx.geneticos.modelo.dto.cruza.Cruza;
import com.ipn.mx.geneticos.modelo.dto.cruza.NPuntos;
import com.ipn.mx.geneticos.modelo.dto.mutacion.Mutacion;
import com.ipn.mx.geneticos.modelo.dto.mutacion.CambioBit;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Ruleta;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Seleccion;
import com.ipn.mx.geneticos.utilerias.FuncCuadrado;
import com.ipn.mx.geneticos.utilerias.Funcion;
import com.ipn.mx.geneticos.utilerias.Rango;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
    private Cruza cruza;
    private Mutacion tipoMutacion;
    private Class tipoIndividuo;
    private Poblacion<T> padres;
    private Poblacion<T> padresSeleccionados;
    private Poblacion<T> hijos;
    private List<Poblacion<T>> generaciones;

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
            Funcion funcion, Seleccion metodoSeleccion, Cruza cruza, Mutacion tipoMutacion,
            String padres, Class tipoIndividuo) {
        this.numeroIndividuos = numeroIndividuos;
        this.numeroGeneraciones = numeroGeneraciones;
        this.rango = rango;
        this.funcion = funcion;
        this.metodoSeleccion = metodoSeleccion;
        this.cruza = cruza;
        this.tipoMutacion = tipoMutacion;
        this.tipoIndividuo = tipoIndividuo;
        this.padres = Poblacion.parseToCromosoma(
                padres, tipoIndividuo);
        generaciones = new ArrayList<>();
    }

    public void executeGenetico() {
        for (int i = 0; i < numeroGeneraciones; i++) {
            System.out.println("********** PADRES ************* ");
            padres.evaluarPoblacion(funcion);
            padres.setValoresEsperados();
            System.out.println(padres.imprimirPoblacion());  // <---------------------
            System.out.println(padres);                      // <---------------------
            System.out.println("********** SELECCION ************* "); // <----------
            padresSeleccionados = metodoSeleccion.execute(padres);
            System.out.println(padresSeleccionados.imprimirPoblacion()); // <---------
            System.out.println("********** CRUZA  ************* ");      // <---------
            padresSeleccionados = cruza.cruzarPoblacion(padresSeleccionados);
            System.out.println(padresSeleccionados.imprimirPoblacion()); // <---------
            System.out.println("********** MUTACION  ************* ");  // <----------
            hijos = tipoMutacion.mutarPoblacion(padresSeleccionados);
            System.out.println(hijos.imprimirPoblacion());              // <----------
            generaciones.add(padres);
            padres = hijos;
            System.out.println("\n---------------------------------------\n\n");
        }
    }

    public static void main(String[] args) {
        BigDecimal numeroCromosomas = new BigDecimal(6);
        Cromosoma.longitud = 5;
        int numeroGeneraciones = 10;
        Rango rango = new Rango(1, 10);
        Funcion f2 = new FuncCuadrado();
        Seleccion<Cromosoma> ruleta = new Ruleta<>(Cromosoma.class);
        Cruza cruzaNPuntos = new NPuntos<>(Cromosoma.class, 2);
        Mutacion<Cromosoma> simple = new CambioBit<>(Cromosoma.class, "20");
        Metodo<Cromosoma> ruletaBits
                = new Metodo(numeroCromosomas, numeroGeneraciones, rango, f2,
                        ruleta, cruzaNPuntos, simple, "01101,11000,01000,10011,10111,01111", Cromosoma.class);
        //Definimos la longitud de la cadena
        ruletaBits.executeGenetico();
        //mr.execute();
    }
}
