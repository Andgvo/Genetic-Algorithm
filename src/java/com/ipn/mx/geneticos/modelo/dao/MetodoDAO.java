package com.ipn.mx.geneticos.modelo.dao;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Metodo;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.FuncCuadrado;
import com.ipn.mx.geneticos.utilerias.Funcion;
import java.util.List;

/**
 *
 * @author Andres
 * @param <T extends Cromosoma>
 */
public class MetodoDAO<T extends Cromosoma> {
    private final Class tipoIndividuo;
    private Metodo metodo;
    private Funcion funcion = new FuncCuadrado();
    
    public MetodoDAO(Class tipoIndividuo){
        this.tipoIndividuo = tipoIndividuo;
    }
    
    public List<Poblacion<Cromosoma>> executeAG(
            int numeroGeneraciones, int longitudCromosoma, String bloque,
            String seleccion, String porcentajeSeleccionPoblacion, String porcentajeSeleccionCromosoma,
            String cruza, int puntosCruza, String porcentajeCruzaPoblacion, String porcentajeCruzaCromosoma,
            String mutacion, int numElementosMutacion, String porcentajeMutacionPoblacion, String porcentajeMutacionCromosoma) {
        metodo = new Metodo(
            numeroGeneraciones, longitudCromosoma, bloque, funcion,
                seleccion, porcentajeSeleccionPoblacion, porcentajeSeleccionCromosoma,
                cruza, puntosCruza, porcentajeCruzaPoblacion, porcentajeCruzaCromosoma,
                mutacion, numElementosMutacion, porcentajeMutacionPoblacion, porcentajeMutacionCromosoma,
                tipoIndividuo);
        return metodo.executeGenetico();
    }
    
    public List<Poblacion<Cromosoma>> executeAG(
            int numeroGeneraciones, int longitudCromosoma, int noCromosomas, int min, int max,
            String seleccion, String porcentajeSeleccionPoblacion, String porcentajeSeleccionCromosoma,
            String cruza, int puntosCruza, String porcentajeCruzaPoblacion, String porcentajeCruzaCromosoma,
            String mutacion, int numElementosMutacion, String porcentajeMutacionPoblacion, String porcentajeMutacionCromosoma) {
        System.out.println("\t============> 2");
        metodo = new Metodo(
            numeroGeneraciones, longitudCromosoma, noCromosomas, min, max, funcion,
                seleccion, porcentajeSeleccionPoblacion, porcentajeSeleccionCromosoma,
                cruza, puntosCruza, porcentajeCruzaPoblacion, porcentajeCruzaCromosoma,
                mutacion, numElementosMutacion, porcentajeMutacionPoblacion, porcentajeMutacionCromosoma,
                tipoIndividuo);
        System.out.println("===============> 4");
        return metodo.executeGenetico();
    }
    
    

}
