package com.ipn.mx.geneticos.modelo.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andres
 * @param <T extends Cromosoma>
 */
public class JsonPoblacion<T extends Cromosoma> {

    public BigDecimal numeroIndividuos; //tamaño de la población
    public BigDecimal sumatoriaAptitud;
    public BigDecimal promedioAptitud;
    public BigDecimal sumatoriaVe;
    public BigDecimal promedioVe;
    public Poblacion<T> cromosomas;

    public JsonPoblacion(Poblacion<T> poblacion) {
        this.cromosomas = poblacion;
        this.numeroIndividuos = poblacion.getNumeroIndividuos(); //tamaño de la población
        this.sumatoriaAptitud = poblacion.getSumatoriaAptitud();
        promedioAptitud = poblacion.getPromedioAptitud();
        sumatoriaVe = poblacion.getSumatoriaVe();
        promedioVe = poblacion.getPromedioVe();
    }
    
    public static List<JsonPoblacion> parseToJSON( List<Poblacion<Cromosoma>> generaciones ){
        List<JsonPoblacion> lista = new ArrayList<>();
        generaciones.stream().forEach( (poblacion) -> lista.add( new JsonPoblacion(poblacion)) );
        return lista;
    }
}
