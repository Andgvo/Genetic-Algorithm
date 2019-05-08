package com.ipn.mx.geneticos.modelo.dto.seleccion;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.ParseCromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.QuicksortC;
import com.ipn.mx.geneticos.utilerias.RandomC;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author andres
 * @param <T>
 */
public class Jerarquia <T extends Cromosoma> extends ParseCromosoma<T> implements Seleccion<T>{

    private final Ruleta<T> ruleta;
    private final QuicksortC<T> ordenamiento = new QuicksortC<>();
    private BigDecimal minimo;
    private BigDecimal maximo;
    private BigDecimal diferencia;
    private BigDecimal divisor;
    private BigDecimal Jit;
    
    public Jerarquia(String porcentajePoblacion, String porcentajeCromosoma, Class<T> type) {
        super(type);
        maximo = new BigDecimal(1.1);
        minimo = new BigDecimal(2).subtract(maximo);
        ruleta = new Ruleta(porcentajePoblacion, porcentajeCromosoma, type);
    }
    
    public Jerarquia(String porcentajePoblacion, String maximo, String porcentajeCromosoma, Class<T> type) {
        super(type);
        this.maximo = new BigDecimal(maximo);
        minimo = new BigDecimal(2).subtract(this.maximo);
        ruleta = new Ruleta(porcentajePoblacion, porcentajeCromosoma, type);
    }

    @Override
    public Poblacion execute(Poblacion<T> padres) {
        //Se tiene la siguiente formula: 
        //Ve(i,t) = Min + (Max - Min)( (jerarquia(i,t) - 1) / (N -1) )
        //Se calcula la diferencia (Max - Min )
        diferencia = maximo.subtract(minimo);
        //Se calcula el divisor (N - 1)
        divisor = new BigDecimal( padres.size()-1 );
        Poblacion<T> nuevosPadres = new Poblacion(type);
        nuevosPadres.addAll(padres);
        nuevosPadres = ordenamiento.quicksortAptitud(nuevosPadres, type);
        calValoresEsperados(nuevosPadres);
        nuevosPadres.setAcumulacionValoresEsperados();
        return ruleta.execute( nuevosPadres );
    }
    
    private Poblacion<T> calValoresEsperados(Poblacion<T> padres){
        //Ve(i,t) = Min + (Max - Min)( (jerarquia(i,t) - 1) / (N -1) )
        for(int i = 0; i < padres.size(); i++){
            //(jerarquia(i,t) - 1) / (N -1)
            Jit = new BigDecimal(i).divide(divisor, 2, RoundingMode.HALF_UP);
            padres.get(i).setValorEsperado(
                //Min + (diferencia) ( jerarquia(i,t) )
                minimo.add( diferencia.multiply(Jit) )
            );
        }
        return padres;
    }
    
}
