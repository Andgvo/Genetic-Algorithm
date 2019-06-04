
package com.ipn.mx.geneticos.utilerias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 *
 * @author andres
 */
public class RandomC {
     
    /**
     * Funcion para obtener puntos random de un conjunto de numeros
     * @param inicio indica el valor minimo o de inicio del random
     * @param longitud indica el valor máximo o fin del random
     * @param puntos numero de elementos que se desean del random
     * @return retorna los puntos ranmdom en orden
     */
    public List cortesRandom(int inicio, int longitud,int puntos){
        List<Integer> numeros = IntStream.range(inicio, longitud).mapToObj(Integer::valueOf)
            .collect(Collectors.toList());
        Collections.shuffle(numeros);
        return Quicksort.quicksortInt(numeros.subList(0, puntos));
    }
    
    /**
     * Funcion para obtener puntos random de un conjunto de numeros
     * @param inicio indica el valor minimo o de inicio del random
     * @param longitud indica el valor máximo o fin del random
     * @param puntos numero de elementos que se desean del random
     * @return retorna los puntos ranmdom en desorden
     */
    public List cortesRandomDesorden(int inicio, int longitud,int puntos){
        List<Integer> numeros = IntStream.range(inicio, longitud).mapToObj(Integer::valueOf)
            .collect(Collectors.toList());
        Collections.shuffle(numeros);
        return numeros.subList(0, puntos);
    }
    
    public List desordenar(int inicio, int longitud,int puntos){
        List<Integer> numeros = IntStream.range(inicio, longitud).mapToObj(Integer::valueOf)
            .collect(Collectors.toList());
        Collections.shuffle(numeros);
        return numeros.subList(0, puntos);
    }
    
    /**
     * Genera cadenas binarias de una longitud 'n', donde el valor de cada
     * cada alelo 'ni' tiene una probabilidad del 50% de ser 0 o 1
     * @param longitud
     * @return 
     */
    public List<Byte> generarCadenaBinaria( int longitud ){
        Random random = new Random();
        List<Byte> cadenaBinaria = new ArrayList<>(longitud);
        int valorRandom;
        for(int i= 0 ; i < longitud; i++){
            valorRandom = random.nextInt(100);
            byte valor = 0;
            if(valorRandom>50){
                valor = 1;
            }
            cadenaBinaria.add(valor);
        }
        return cadenaBinaria;
    }
}
