
package com.ipn.mx.geneticos.utilerias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author andres
 */
public class RandomC {
    public static void random(int number){
        Random r = new Random(number);
    }
    
    public static void main(String[] args) {
        RandomC.random(8);
    }
}
