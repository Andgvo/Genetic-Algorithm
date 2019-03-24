package com.ipn.mx.geneticos.modelo.dto;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author andres
 */
public class Poblacion<T extends Cromosoma> extends ArrayList<Cromosoma> {
    private Class<T> type;
    protected int n; //tamaño de la población
    protected BigDecimal sumatoriaF;
    private static int valorInicio = 1;
    private static int valorFinal = 10;

    public Poblacion(Class<T> type) {
        sumatoriaF = new BigDecimal(0);
        this.type = type;
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
    
    protected void getPoblacionAleatoria(int numElementos) {
        this.clear();
        T individuo;
        for (int i = 0; i < numElementos; i++) {
            individuo = instantiateFromType( new BigDecimal(new Random().nextInt( valorFinal ) + valorInicio ) );
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
        Poblacion.valorInicio = valorInicio;
        Poblacion.valorFinal = valorFinal;
    }
    
    @Override
    public boolean add(Cromosoma cromosoma) {
        return super.add(cromosoma);
    }

    

}
