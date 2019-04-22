package com.ipn.mx.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import java.util.function.Predicate;

/**
 *
 * @author andres
 */
public class Pruebas {
    public static final Gson GSON = new GsonBuilder().create();
    
    public static void hola(Cromosoma c, Predicate<Cromosoma> p){
        System.out.println(p.test(c));
    }
    
    public static void main(String[] args) {
        Poblacion<Cromosoma> p = Poblacion.parseToCromosoma(
                "01101,11000", Cromosoma.class);
        System.out.println(p.imprimirPoblacion());
        System.out.println( Pruebas.GSON.toJson(p) );   
        System.out.println("***********+");
        LamdaFunction helloWord = () -> System.out.println("Hola mundo");
        helloWord.call();
    }
}

interface LamdaFunction {
    void call();
}