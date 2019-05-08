
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
    
    public List cortesRandom(int inicio, int longitud,int puntos){
        List<Integer> numeros = IntStream.range(inicio, longitud).mapToObj(Integer::valueOf)
            .collect(Collectors.toList());
        Collections.shuffle(numeros);
        return Quicksort.quicksortInt(numeros.subList(0, puntos));
    }
    
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
        System.out.println(cadenaBinaria);
        return cadenaBinaria;
    }
    
    public static void main(String[] args) {
        RandomC random = new RandomC();
        List<Integer> r = new ArrayList<>();
        r.add(1);
        r.add(2);
        r.add(3);
        r.add(4);
        r.add(5);
        List l = random.desordenar(0, r.size(), r.size());
        System.out.println(l);
        System.out.println("---------_>");
        random.generarCadenaBinaria(5);
    }
}
