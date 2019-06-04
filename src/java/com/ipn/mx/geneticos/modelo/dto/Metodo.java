package com.ipn.mx.geneticos.modelo.dto;

import com.ipn.mx.geneticos.modelo.dao.factory.MetodoFactory;
import com.ipn.mx.geneticos.modelo.dto.cruza.Cruza;
import com.ipn.mx.geneticos.modelo.dto.mutacion.Mutacion;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Seleccion;
import com.ipn.mx.geneticos.utilerias.FuncCuadrado;
import com.ipn.mx.geneticos.utilerias.Funcion;
import com.ipn.mx.geneticos.utilerias.Rango;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 * @param <T> extends Cromosoma
 */
public class Metodo<T extends Cromosoma> {

    private final int numeroGeneraciones;
    private final Funcion funcion;
    private final Seleccion metodoSeleccion;
    private final Cruza cruza;
    private final Mutacion tipoMutacion;
    private final List<Poblacion<T>> generaciones;
    private Poblacion<T> padres;
    private Poblacion<T> padresSeleccionados;
    private Poblacion<T> hijos;
    
    
    public Metodo( int numeroGeneraciones, int longitudCromosoma,
            String bloque, Funcion funcion,
            String seleccion, String porcentajeSeleccionPoblacion, String porcentajeSeleccionCromosoma,
            String cruza, int puntosCruza, String porcentajeCruzaPoblacion, String porcentajeCruzaCromosoma,
            String mutacion, int numElementosMutacion, String porcentajeMutacionPoblacion, String porcentajeMutacionCromosoma,
            Class tipoIndividuo ) {
        this.numeroGeneraciones = numeroGeneraciones;
        Cromosoma.longitud = longitudCromosoma;
        this.funcion = funcion;
        this.metodoSeleccion = MetodoFactory.getSeleccion(seleccion, porcentajeSeleccionPoblacion, porcentajeSeleccionCromosoma, tipoIndividuo);
        this.cruza = MetodoFactory.getCruza(cruza, porcentajeCruzaPoblacion, porcentajeCruzaCromosoma, puntosCruza, tipoIndividuo);
        this.tipoMutacion = MetodoFactory.getMutacion(mutacion, numElementosMutacion,porcentajeMutacionPoblacion ,porcentajeMutacionCromosoma, tipoIndividuo);
        this.padres = Poblacion.parseToCromosoma(
                bloque, tipoIndividuo);
        generaciones = new ArrayList<>();
    }
    
    public Metodo( int numeroGeneraciones, int longitudCromosoma,
            int noCromosomas, int min, int max, Funcion funcion,
            String seleccion, String porcentajeSeleccionPoblacion, String porcentajeSeleccionCromosoma,
            String cruza, int puntosCruza, String porcentajeCruzaPoblacion, String porcentajeCruzaCromosoma,
            String mutacion, int numElementosMutacion, String porcentajeMutacionPoblacion, String porcentajeMutacionCromosoma,
            Class tipoIndividuo ) {
        this.numeroGeneraciones = numeroGeneraciones;
        Cromosoma.longitud = longitudCromosoma;
        this.funcion = funcion;
        this.metodoSeleccion = MetodoFactory.getSeleccion(seleccion, porcentajeSeleccionPoblacion, porcentajeSeleccionCromosoma, tipoIndividuo);
        this.cruza = MetodoFactory.getCruza(cruza, porcentajeCruzaPoblacion, porcentajeCruzaCromosoma, puntosCruza, tipoIndividuo);
        this.tipoMutacion = MetodoFactory.getMutacion(mutacion, numElementosMutacion,porcentajeMutacionPoblacion ,porcentajeMutacionCromosoma, tipoIndividuo);
        this.padres = Poblacion.getAleatoria(noCromosomas, longitudCromosoma, min, max, tipoIndividuo);
        generaciones = new ArrayList<>();
    }

    public List<Poblacion<T>> executeGenetico() {
        for (int i = 0; i < numeroGeneraciones; i++) {
            padres.evaluarPoblacion(funcion);
            padres.setValoresEsperados();
            padresSeleccionados = metodoSeleccion.execute(padres);
            padresSeleccionados = cruza.cruzarPoblacion(padresSeleccionados);
            hijos = tipoMutacion.mutarPoblacion(padresSeleccionados);
            generaciones.add(padres);
            padres = hijos;
        }
        return generaciones;
    }
    
    public void executeGeneticoDebug() {
        for (int i = 0; i < numeroGeneraciones; i++) {
            System.out.println("********** PADRES ************* ");
            padres.evaluarPoblacion(funcion);
            padres.setValoresEsperados();
            System.out.println(padres.imprimirPoblacion());       // <---------------------
            System.out.println(padres);                           // <---------------------
            System.out.println("********** SELECCION ************* ");    // <-------------
            padresSeleccionados = metodoSeleccion.execute(padres);
            System.out.println(padresSeleccionados.imprimirPoblacion());  // <-------------
            System.out.println("********** CRUZA  ************* ");       // <-------------
            padresSeleccionados = cruza.cruzarPoblacion(padresSeleccionados);
            System.out.println(padresSeleccionados.imprimirPoblacion());  // <-------------
            System.out.println("********** MUTACION  ************* ");    // <-------------
            hijos = tipoMutacion.mutarPoblacion(padresSeleccionados);
            System.out.println(hijos.imprimirPoblacion());                // <-------------
            generaciones.add(padres);
            padres = hijos;
            System.out.println("\n---------------------------------------\n\n");
        }
    }

    public List<Poblacion<T>> getGeneraciones() {
        return generaciones;
    }
    
    public Poblacion<T> getGeneracion(int indice) {
        return generaciones.get(indice);
    }
    
    public static void main(String[] args) {
        Cromosoma.longitud = 5;
        
        Rango rango = new Rango(1, 10);
        Funcion f2 = new FuncCuadrado();
        
        //Prueba de algoritmo
        int numeroGeneraciones = 3;
        int longitudCromosoma = 5;
        String bloque = "01101,11000,01000,10011,10111,01111";
        String seleccion = "RULETA";
        String porcentajeSeleccionPoblacion = "100";
        String porcentajeSeleccionCromosoma = "10";
        String cruza = "UNIFORME";
        int puntosCruza = 2;
        String porcentajeCruzaPoblacion = "100";
        String porcentajeCruzaCromosoma = "3";
        String mutacion = "INTERCAMBIO";
        int numElementosMutacion = 4;
        String porcentajeMutacionPoblacion = "100";
        String porcentajeMutacionCromosoma = "20";
        
        Metodo<Cromosoma> metodo = new Metodo<>
            ( numeroGeneraciones, longitudCromosoma, bloque, f2, 
                seleccion, porcentajeSeleccionPoblacion, porcentajeSeleccionCromosoma, 
                cruza, puntosCruza, porcentajeCruzaPoblacion, porcentajeCruzaCromosoma, 
                mutacion, numElementosMutacion, porcentajeMutacionPoblacion, porcentajeMutacionCromosoma,
                Cromosoma.class
            );
        metodo.executeGeneticoDebug();
    }
}
