package com.ipn.mx.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("*************************************************");
        List<Integer> lista = new ArrayList();
        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        System.out.println("size: "+ lista.size());
        System.out.println(lista);
        System.out.println("*************************************************");
        lista.remove(2);
        System.out.println(lista);
        System.out.println("**********************************************+");
        System.out.println(lista.subList(0, 0));
        System.out.println(lista.subList(0, lista.size()));
        System.out.println("**********************************************+");
        int aux = lista.remove(3);
        lista.add(1,aux);
        System.out.println(lista);
        System.out.println("----------------------------------------------");
        Poblacion p2 = Poblacion.getAleatoria(6, 5, 0, 20, Cromosoma.class);
        System.out.println("**********************************************__");
        System.out.println(p2.size());
        System.out.println(p2.imprimirPoblacion());   
    }
}

interface LamdaFunction {
    void call();
}