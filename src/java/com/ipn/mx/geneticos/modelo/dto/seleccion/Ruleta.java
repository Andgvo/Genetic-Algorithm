
package com.ipn.mx.geneticos.modelo.dto.seleccion;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.ParseCromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 *
 * @author andres
 * @param <T extends Cromosoma>
 */
public class Ruleta<T extends Cromosoma> extends ParseCromosoma<T> implements Seleccion<T>{

    private static final BigDecimal CIEN = new BigDecimal(100);
    private final BigDecimal porcentajePoblacion;
    private final BigDecimal porcentajeCromosoma;
    
    public Ruleta( String porcentajePoblacion, String porcentajeCromosoma, Class<T> type ) {
        super(type);
        this.porcentajePoblacion = new BigDecimal(porcentajePoblacion);
        this.porcentajeCromosoma = new BigDecimal(porcentajeCromosoma);
    }

    @Override
    public Poblacion execute(Poblacion<T> padres) {
        //Se multiplica por 100 para posteriormente obtener decimales
        int sumatoriaVe = (int) (padres.getSumatoriaVe().doubleValue() * 100.0);
        BigDecimal numeroRandom;
        BigDecimal r;
        Poblacion<T> nuevosPadres = new Poblacion(type);
        for(int i = 0; i < padres.size() ; i++){
            numeroRandom = new BigDecimal( new Random().nextInt( sumatoriaVe ) );
            r = numeroRandom.divide( CIEN  , 2, RoundingMode.HALF_UP );
            T individuo = seleccion(padres, r);
            nuevosPadres.add(individuo);
        }
        return nuevosPadres;
    }
    
    public Poblacion executeVe(Poblacion<T> padres) {
        //Se multiplica por 100 para posteriormente obtener decimales
        int sumatoriaVe = (int) (padres.getSumatoriaVe().doubleValue() * 100.0);
        BigDecimal numeroRandom;
        BigDecimal r;
        Poblacion<T> nuevosPadres = new Poblacion(type);
        for(int i = 0; i < padres.size() ; i++){
            numeroRandom = new BigDecimal( new Random().nextInt( sumatoriaVe ) );
            r = numeroRandom.divide( CIEN  , 2, RoundingMode.HALF_UP );
            T individuo = seleccion(padres, r);
            nuevosPadres.add(individuo);
        }
        return nuevosPadres;
    }
    
    private T seleccion(Poblacion<T> poblacion, BigDecimal r){
        T individuo = null;
        for(Object cromosoma: poblacion){
            individuo = (T) cromosoma;
            if(individuo.getProbabilidadAcumulada().doubleValue() >  r.doubleValue() )
                return (T) instanciaDeCromosoma(individuo.getValorReal());
        }
        return individuo;
    }

}
