
package com.ipn.mx.geneticos.modelo.dto.seleccion;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.ParseCromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.RandomC;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andres
 * @param <T extends Cromosoma>
 */
public class Torneo<T extends Cromosoma> extends ParseCromosoma<T> implements Seleccion<T>{

    private static final RandomC RANDOM = new RandomC();
    
    public Torneo(String porcentajePoblacion, String porcentajeCromosoma,Class<T> type) {
        super(type);
    }

    @Override
    public Poblacion execute(Poblacion<T> padres) {
        Poblacion<T> nuevosPadres = new Poblacion(type);
        //Como siempre son pares por eso se repite dos veces el torneo
        for(int i = 0; i != 2 ; i++){
            nuevosPadres.addAll(seleccion(padres));
        }
        return nuevosPadres;
    }
    
    private List<T> seleccion(Poblacion<T> padres){
        T competidor1;
        T competidor2;
        List<T> ganadores = new ArrayList<>();
        List<Integer> competidores = RANDOM.desordenar(0, padres.size(), padres.size());
        int veces = padres.size() /2 ;
        for(int i =0; i < veces; i++){
            competidor1 = instanciaDeCromosoma( padres.get( competidores.get(i) ).getValorReal() );
            competidor2 = instanciaDeCromosoma( padres.get( competidores.get(i+1) ).getValorReal() );
            if( competidor1.getAptitud().subtract( competidor2.getAptitud() ).doubleValue() > 0 )
                ganadores.add( competidor1 );
            else
                ganadores.add( competidor2 );
        }
        return ganadores;
    }
}
