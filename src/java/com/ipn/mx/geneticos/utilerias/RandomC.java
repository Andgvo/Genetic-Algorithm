
package com.ipn.mx.geneticos.utilerias;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author andres
 */
public class RandomC {
    
    public List cortesRandom(int inicio, int longitud,int puntos){
        List<Integer> numeros = IntStream.range(inicio, longitud).mapToObj(Integer::valueOf)
            .collect(Collectors.toList());
        Collections.shuffle(numeros);
        return Quicksort.quicksortInt(numeros.subList(0, puntos));
    }
    
    public static void main(String[] args) {
        RandomC random = new RandomC();
        List r = random.cortesRandom(1, 10, 3);
        System.out.println(r);
    }
}
