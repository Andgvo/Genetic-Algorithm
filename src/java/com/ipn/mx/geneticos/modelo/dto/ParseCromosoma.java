package com.ipn.mx.geneticos.modelo.dto;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author andres
 * @param <T extens Cromosoma>
 */
public abstract class ParseCromosoma<T extends Cromosoma> {
    protected Class<T> type;
    
    public ParseCromosoma(Class<T> type) {
        this.type = type;
    }
    
    protected T instanciaDeCromosoma( BigDecimal valor ) {
      try {
          Constructor constructor = type.getConstructor(BigDecimal.class);
          T interfaceType = (T) constructor.newInstance( valor );
          return interfaceType;
      }
      catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
          return null;
       }         
    }
    
    protected T instanciaDeCromosoma( List<Byte> cadena ) {
      try {
          Constructor constructor = type.getConstructor(List.class);
          T interfaceType = (T) constructor.newInstance( cadena );
          return interfaceType;
      }
      catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
          return null;
       }         
    }
}
