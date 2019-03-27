package com.ipn.mx.geneticos.modelo.dto;

import com.ipn.mx.geneticos.utilerias.Funcion;
import com.ipn.mx.geneticos.utilerias.Rango;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author andres
 * @param <T extends Cromosoma>
 */
public class Poblacion<T extends Cromosoma> extends ArrayList<Cromosoma> {
    private final Class<T> type;
    private Rango rango;
    protected BigDecimal numeroIndividuos; //tamaño de la población
    protected BigDecimal sumatoriaAptitud;
    protected BigDecimal promedioAptitud;
    protected BigDecimal sumatoriaVe;
    protected BigDecimal promedioVe;
    
    //Tambien se usa en quicksort :'v
    public Poblacion(Class<T> type) {
        sumatoriaAptitud = new BigDecimal(0);
        this.type = type;
    }
    
    // PARA UN FUTURO. SE PUEDE ELIMINAR
    public Poblacion(Class<T> type, BigDecimal numIndividuos, Rango rango){
        sumatoriaAptitud = new BigDecimal(0);
        this.type = type;
        this.numeroIndividuos = numIndividuos;
        this.rango = rango;
        this.sumatoriaVe = new  BigDecimal(0);
        this.promedioVe = new BigDecimal(0);
    }
    
    //Se usa en Quicksort
    public Poblacion(Class<T> type, List<T> cromosomas) {
        sumatoriaAptitud = new BigDecimal(0);
        this.type = type;
        addAll(cromosomas);
    }
    
    /**
     * @param numElementos numero de elementos de la poblacion
     * @return Poblacion 
    **/
    public static Poblacion getAleatoria(int numElementos) {
        Poblacion resultado = new Poblacion(Cromosoma.class);
        Cromosoma individuo;
        for (int i = 0; i < numElementos; i++) {
            individuo = new Cromosoma(
                    new BigDecimal(new Random().nextInt(10))
            );
            resultado.add(individuo);
        }
        return resultado;
    }
    
    /**
     * Clase para convetir un String de forma "cromosoma, cromosoma, cromosoma" a
     * una poblacion de cromosomas de cierta clase.
     * @param elementos
     * @param type
     * @return 
     */
    public static Poblacion parseToCromosoma(String elementos, Class type){
        String[] valores = elementos.split(",");
        Poblacion p = new Poblacion(type);
        for (String valor : valores) {
            p.add( new Cromosoma( new BigDecimal( Cromosoma.parseDouble(valor) ) ));
        }
        return p;
    }
    
    /**
     * Se generan la población de manera aleatoria en un Rango definido previamente
     * a la par se va calculando la sumatoria de aptitud y finalmente el promedio
     * de ésta.
     * @param funcion
     */
    public void generarPoblacion(Funcion funcion){
        this.clear();
        T individuo;
        for (int i = 0; i < numeroIndividuos.intValue() ; i++) {
            //Se crea un individuo con un valor dentro de un Rango
            individuo = 
                instantiateFromType(
                    new BigDecimal(
                            new Random().nextInt(rango.getValorMaximo() ) + rango.getValorMinimo() ) );
            individuo.setAptitud( funcion.f( individuo.getValorReal() ) );
            this.add(individuo);
            sumatoriaAptitud = sumatoriaAptitud.add(individuo.getAptitud());
        }
        promedioAptitud = sumatoriaAptitud.divide(numeroIndividuos);
    }
    
    /**
     * Se generan la población de manera aleatoria en un Rango definido previamente
     * a la par se va calculando la sumatoria de aptitud y finalmente el promedio
     * de ésta.
     * @param funcion
     */
    public void evaluarPoblacion( Funcion funcion ){
        for (Cromosoma individuo: this) {
            individuo.setAptitud( funcion.f( individuo.getValorReal() ) );
            sumatoriaAptitud = sumatoriaAptitud.add(individuo.getAptitud());
        }
        promedioAptitud = sumatoriaAptitud.divide(numeroIndividuos);
    }
    
    public void setValoresEsperados(){
        this.stream().forEachOrdered((individuo) -> {
            individuo.setValorEsperado( 
                individuo.getAptitud().divide( 
                    promedioAptitud, 2, RoundingMode.HALF_UP ) );
            sumatoriaVe = sumatoriaVe.add(individuo.getValorEsperado());
        });
        promedioVe = sumatoriaVe.divide(numeroIndividuos);
    }
    
    private T instantiateFromType( BigDecimal valor ) {
      try {
          Constructor constructor = type.getConstructor(BigDecimal.class);
          T interfaceType = (T) constructor.newInstance( valor );
          return interfaceType;
      }
      catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
          return null;
       }         
    }
    
    public int getN() {
        return size();
    }
    
    public BigDecimal getSumatoriaAptitud(){
       return sumatoriaAptitud; 
    }
    
    public String imprimirPoblacion(){
        StringBuilder sb = new StringBuilder();
        this.forEach((t) -> {
            sb.append(t).append("\n");
        });
        return sb.toString();
    }
    
    @Override
    public boolean add(Cromosoma cromosoma) {
        return super.add(cromosoma);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("SumatoriaAptitud= ").append(sumatoriaAptitud)
        .append(" PromedioAptitud= ").append(promedioAptitud)
        .append(" SumatoriaVe= ").append(sumatoriaVe)
        .append(" PromedioVe= ").append(promedioVe);
        return sb.toString();
    }
    
}
