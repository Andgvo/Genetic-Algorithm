package com.ipn.mx.geneticos.modelo.dto;

import com.ipn.mx.geneticos.utilerias.Rango;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
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
    protected int tamanioPoblacion; //tamaño de la población
    protected BigDecimal sumatoriaF;
    private static int valorMinimo = 1;
    private static int valorMaximo = 10;

    public Poblacion(Class<T> type) {
        sumatoriaF = new BigDecimal(0);
        this.type = type;
    }
    
    public Poblacion(Class<T> type, Rango rango){
        sumatoriaF = new BigDecimal(0);
        this.type = type;
        this.rango = rango;
    }

    public Poblacion(Class<T> type, List<T> cromosomas) {
        sumatoriaF = new BigDecimal(0);
        this.type = type;
        addAll(cromosomas);
    }
    
    public Poblacion(Class<T> type, int numElement) {
        sumatoriaF = new BigDecimal(0);
        this.type = type;
        getPoblacionAleatoria(numElement);
    }
    
    public Poblacion(Class<T> type, int numElement, Rango rango) {
        sumatoriaF = new BigDecimal(0);
        this.type = type;
        getPoblacionAleatoria(numElement, rango);
    }
    
    public void generarPoblacion(){
        this.clear();
        T individuo;
        for (int i = 0; i < tamanioPoblacion ; i++) {
            individuo = 
                instantiateFromType(
                    new BigDecimal(
                            new Random().nextInt(rango.getValorMaximo() ) + rango.getValorMinimo() ) );
            this.add(individuo);
            sumatoriaF = sumatoriaF.add(individuo.getAptitud());
        }
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
    
    private void getPoblacionAleatoria(int numElementos, Rango rango) {
        this.clear();
        T individuo;
        for (int i = 0; i < numElementos; i++) {
            individuo = 
                instantiateFromType(
                    new BigDecimal(
                            new Random().nextInt(rango.getValorMaximo() ) + rango.getValorMinimo() ) );
            this.add(individuo);
            sumatoriaF = sumatoriaF.add(individuo.getAptitud());
        }
    }
    
    protected void getPoblacionAleatoria(int numElementos) {
        this.clear();
        T individuo;
        for (int i = 0; i < numElementos; i++) {
            individuo = instantiateFromType(new BigDecimal(new Random().nextInt(valorMaximo ) + valorMinimo ) );
            this.add(individuo);
            sumatoriaF = sumatoriaF.add(individuo.getAptitud());
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
    
    public int getN() {
        return size();
    }
    
    public BigDecimal getSumatoriaF(){
       return sumatoriaF; 
    }
    
    public void setRangos(int valorInicio, int valorFinal) {
        Poblacion.valorMinimo = valorInicio;
        Poblacion.valorMaximo = valorFinal;
    }
    
    @Override
    public boolean add(Cromosoma cromosoma) {
        return super.add(cromosoma);
    }

}
