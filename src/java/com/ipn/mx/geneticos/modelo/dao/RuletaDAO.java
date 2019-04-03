package com.ipn.mx.geneticos.modelo.dao;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Metodo;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.modelo.dto.cruza.Cruza;
import com.ipn.mx.geneticos.modelo.dto.mutacion.Mutacion;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Seleccion;
import com.ipn.mx.geneticos.utilerias.FuncCuadrado;
import com.ipn.mx.geneticos.utilerias.Funcion;
import com.ipn.mx.geneticos.utilerias.Rango;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Andres
 * @param <T extends Cromosoma>
 */
public class RuletaDAO<T extends Cromosoma> {
    private final Class tipoIndividuo;
    private Metodo metodo;
    
    public RuletaDAO(Class tipoIndividuo){
        this.tipoIndividuo = tipoIndividuo;
    }
    
    private int numeroGeneraciones;
    private int longitudCromosoma;
    private String porcentajeMutacion;
    private Seleccion<T> seleccion;
    private Cruza<T> cruza;
    private Mutacion<T> mutacion;
    private Funcion funcion = new FuncCuadrado();
    
    //Variables para población bloques Constructores
    private String tipoBloque;
    private String bloque;
    
    //Variables para población Aleatorio
    private BigDecimal numeroCromosomas;
    private Rango rango;
    
    public List<Poblacion<Cromosoma>> executeAG(
            int numeroGeneraciones, int longitudCromosoma, String porcentajeMutacion,
                String bloque, String seleccion, String cruza, String mutacion) {
        metodo = new Metodo(
            numeroGeneraciones, longitudCromosoma, porcentajeMutacion, bloque, funcion, seleccion, cruza, mutacion, tipoIndividuo);
        return metodo.executeGenetico();
    }
}
