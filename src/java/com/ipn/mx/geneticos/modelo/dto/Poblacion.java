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
public class Poblacion<T extends Cromosoma> extends ArrayList<T> {
    private final Class<T> type;
    private Rango rango;
    protected BigDecimal numeroIndividuos; //tamaño de la población
    protected BigDecimal sumatoriaAptitud;
    protected BigDecimal promedioAptitud;
    protected BigDecimal sumatoriaVe;
    protected BigDecimal promedioVe;
    protected T cromosomaMin;
    protected T cromosomaMax;
    
    //Tambien se usa en quicksort :'v
    public Poblacion(Class<T> type) {
        numeroIndividuos = new BigDecimal(0);
        sumatoriaAptitud = new BigDecimal(0);
        promedioAptitud = new BigDecimal(0);
        sumatoriaVe = new BigDecimal(0);
        promedioVe = new BigDecimal(0);
        this.type = type;
        cromosomaMin = instantiateFromType(BigDecimal.ZERO);
        cromosomaMax = instantiateFromType(BigDecimal.ZERO);
    }
    
    // PARA UN FUTURO. SE PUEDE ELIMINAR
    public Poblacion(Class<T> type, BigDecimal numIndividuos, Rango rango){
        sumatoriaAptitud = new BigDecimal(0);
        this.type = type;
        this.numeroIndividuos = numIndividuos;
        this.rango = rango;
        this.sumatoriaVe = new  BigDecimal(0);
        this.promedioVe = new BigDecimal(0);
        cromosomaMin = instantiateFromType(BigDecimal.ZERO);
        cromosomaMax = instantiateFromType(BigDecimal.ZERO);
    }
    
    //Se usa en Quicksort
    public Poblacion(Class<T> type, List<T> cromosomas) {
        sumatoriaAptitud = new BigDecimal(0);
        numeroIndividuos = new BigDecimal(0);
        this.type = type;
        addAll(cromosomas);
        cromosomaMin = instantiateFromType(BigDecimal.ZERO);
        cromosomaMax = instantiateFromType(BigDecimal.ZERO);
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
        promedioAptitud = sumatoriaAptitud.divide(numeroIndividuos, 2, RoundingMode.HALF_UP);
    }
    
    /**
     * Se generan la población de manera aleatoria en un Rango definido previamente
     * a la par se va calculando la sumatoria de aptitud y finalmente el promedio
     * de ésta.
     * @param funcion
     */
    public void evaluarPoblacion( Funcion funcion ){
        cromosomaMin = this.get(0);
        this.stream().forEachOrdered((individuo) -> {
            individuo.setAptitud( funcion.f( individuo.getValorReal() ) );
            sumatoriaAptitud = sumatoriaAptitud.add(individuo.getAptitud());
            comparaMinMax(individuo);
        });
        promedioAptitud = sumatoriaAptitud.divide(numeroIndividuos, 2, RoundingMode.HALF_UP );
    }
    
    public void setValoresEsperados(){
        this.stream().forEachOrdered((individuo) -> {
            individuo.setValorEsperado( 
                individuo.getAptitud().divide( 
                    sumatoriaAptitud, 2, RoundingMode.HALF_UP ) );
            sumatoriaVe = sumatoriaVe.add(individuo.getValorEsperado());
            individuo.setProbabilidadAcumulada(sumatoriaVe);
        });
        promedioVe = sumatoriaVe.divide(numeroIndividuos, 2, RoundingMode.HALF_UP );
    }
    
    private void comparaMinMax(T prospecto){
        if(cromosomaMax.getAptitud().subtract(prospecto.getAptitud()).doubleValue() < 0){
            cromosomaMax = prospecto;
        }else if(cromosomaMin.getAptitud().subtract(prospecto.getAptitud()).doubleValue() > 0){
            cromosomaMin = prospecto;
        }
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
    
    public BigDecimal getSumatoriaAptitud(){
       return sumatoriaAptitud; 
    }

    public BigDecimal getSumatoriaVe() {
        return sumatoriaVe;
    }

    public Class<T> getType() {
        return type;
    }

    public Rango getRango() {
        return rango;
    }

    public BigDecimal getNumeroIndividuos() {
        return numeroIndividuos;
    }

    public BigDecimal getPromedioAptitud() {
        return promedioAptitud;
    }

    public BigDecimal getPromedioVe() {
        return promedioVe;
    }
        
    public String imprimirPoblacion(){
        StringBuilder sb = new StringBuilder();
        this.forEach((cromosoma) -> {
            sb.append(cromosoma).append("\n");
        });
        return sb.toString();
    }
    
    /**
     * Convierte los individuos de la poblacion a notación JSON
     * @return JSON de individuos de la poblacion
     */
    public String individuosToJSON(){
        StringBuilder sb = new StringBuilder("[");
        this.forEach((cromosoma) -> {
            sb.append(cromosoma.toJSON()).append(",");
        });
        sb.setCharAt( sb.lastIndexOf(","), ' ');
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Convierte los valores finales de sumatoria y promedio aptidud y Ve 
     * de la poblacion en JSON.
     * @return JSON resultado de la poblacion
     */
    public String resulToJSON(){
        StringBuilder sb = new StringBuilder("{");
        sb.append(" \"SumatoriaAptitud\" : ").append(sumatoriaAptitud)
        .append(", \"PromedioAptitud\" : ").append(promedioAptitud)
        .append(", \"SumatoriaVe\" : ").append(sumatoriaVe)
        .append(", \"PromedioVe\": ").append(promedioVe).append("}");
        return sb.toString();
    }
    
    @Override
    public boolean add(T cromosoma) {
        numeroIndividuos = numeroIndividuos.add(BigDecimal.ONE);
        return super.add(cromosoma);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        sb.append(" \"SumatoriaAptitud\" : ").append(sumatoriaAptitud)
        .append(", \"PromedioAptitud\" : ").append(promedioAptitud)
        .append(", \"cromosomaMax\" : ").append(cromosomaMax)
        .append(", \"cromosomaMin\" : ").append(cromosomaMin)
        .append(", \"SumatoriaVe\" : ").append(sumatoriaVe)
        .append(", \"PromedioVe\": ").append(promedioVe).append("}");
        return sb.toString();
    }
    
}