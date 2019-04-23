package com.ipn.mx.geneticos.modelo.dto;

import com.ipn.mx.geneticos.modelo.dao.factory.MetodoFactory;
import com.ipn.mx.geneticos.modelo.dto.cruza.Cruza;
import com.ipn.mx.geneticos.modelo.dto.cruza.NPuntos;
import com.ipn.mx.geneticos.modelo.dto.mutacion.Mutacion;
import com.ipn.mx.geneticos.modelo.dto.mutacion.CambioBit;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Ruleta;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Seleccion;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Torneo;
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
            String cruza, String porcentajeCruzaPoblacion, String porcentajeCruzaCromosoma,
            String mutacion, String porcentajeMutacionPoblacion, String porcentajeMutacionCromosoma,
            Class tipoIndividuo) {
        this.numeroGeneraciones = numeroGeneraciones;
        Cromosoma.longitud = longitudCromosoma;
        this.funcion = funcion;
        this.metodoSeleccion = MetodoFactory.getSeleccion(seleccion, "5","10", tipoIndividuo);
        this.cruza = MetodoFactory.getCruza(cruza, 2, tipoIndividuo);
        this.tipoMutacion = MetodoFactory.getMutacion(mutacion, porcentajeMutacionCromosoma, tipoIndividuo);
        this.padres = Poblacion.parseToCromosoma(
                bloque, tipoIndividuo);
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
        System.out.println(generaciones.get(0));
        System.out.println(generaciones.get(1));
        System.out.println(generaciones.get(2));
    }

    public List<Poblacion<T>> getGeneraciones() {
        return generaciones;
    }
    
    public Poblacion<T> getGeneracion(int indice) {
        return generaciones.get(indice);
    }
    
    public static void main(String[] args) {
        BigDecimal numeroCromosomas = new BigDecimal(6);
        Cromosoma.longitud = 5;
        int numeroGeneraciones = 4;
        Rango rango = new Rango(1, 10);
        Funcion f2 = new FuncCuadrado();
        Seleccion<Cromosoma> torneo = new Torneo<>(Cromosoma.class);
        Cruza cruzaNPuntos = new NPuntos<>(2, Cromosoma.class);
        Mutacion<Cromosoma> simple = new CambioBit<>("20",Cromosoma.class);
//        Metodo<Cromosoma> ruletaBits
//                = new Metodo();
//        ruletaBits.executeGeneticoDebug();
        
        //Definimos la longitud de la cadena
//        ruletaBits.executeGenetico();
        
        //mr.execute();
    }
}
