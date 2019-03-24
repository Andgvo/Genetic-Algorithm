
package com.ipn.mx.geneticos.utilerias;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public abstract class Quicksort {
    
    public static void cambioElementos(List<BigDecimal> array, int izq, int der){
        BigDecimal aux = array.get(der);
        array.set(der, array.get(izq));
        array.set(izq, aux);
    }
    
    public static List<BigDecimal> quicksort( List<BigDecimal> array ){
        List  arrayResult = new ArrayList();
        int tam = array.size();
        if( tam != 0 ){
            int pibote = 0;
            int ptrIzq = 0;
            int ptrDer = tam - 1 ;
            boolean izqMayor = false;
            boolean derMenor = false;
            //Saber si el arreglo es par o impar, para elegir el pibote en medio
            if( (tam % 2) != 0 )
                pibote = (int)( Math.ceil((double) tam / 2 ) - 1 );
            else
                pibote = (int)( Math.floor((double) tam / 2 ) - 1 );
            //Recorrido de los punteros
            while( ptrIzq < ptrDer ){
                //Verifica si la regla de quicksort, sino cumple avanza al siguiente
                if ( ( array.get(ptrIzq).intValue()  >= array.get(pibote).intValue() ) )
                    izqMayor = true;
                else
                    ptrIzq += 1;
                if ( array.get(ptrDer).intValue() <= array.get(pibote).intValue() )
                    derMenor = true;
                else
                    ptrDer -= 1;
                //Caso en el que el putero continue en el centro de ptrIzq y ptrDer
                if( izqMayor && derMenor ){
                    cambioElementos(array, ptrDer, ptrIzq);
                    if( ptrIzq == pibote )
                        pibote = ptrDer;
                    else if( ptrDer == pibote )
                        pibote = ptrIzq;
                    ptrIzq += 1;
                    ptrDer -= 1;
                    izqMayor = false; 
                    derMenor = false;
                }

                //Caso ptrIzq y ptrDer quedaron después del Puntero  
                if( ( pibote < ptrIzq ) && ( pibote < ptrDer ) ){
                    if (  array.get( ptrIzq ).intValue() < array.get(pibote).intValue()  ){
                        cambioElementos(array, pibote, ptrIzq);
                        pibote = ptrIzq;
                    } else if ( array.get(ptrDer).intValue() < array.get(pibote).intValue() ){
                        cambioElementos(array, pibote, ptrDer);
                        pibote = ptrDer;
                    }
                //Caso ptrIzq y ptrDer quedaron antes del Puntero
                }else if( ( pibote > ptrIzq ) && ( pibote > ptrDer ) ){
                    if ( ( array.get( ptrIzq ).intValue() > array.get(pibote).intValue() ) ){
                        cambioElementos(array, pibote, ptrIzq);
                        pibote = ptrIzq;
                    } else if ( array.get(ptrDer).intValue() > array.get(pibote).intValue() ){
                        cambioElementos(array, pibote, ptrDer);
                        pibote = ptrDer;
                    }
                }
            }
            //Una vez ordenados los menores a la izq del pibote y los mayores a la der
            //sepramos en dos arreglso y se repite el algoritmo de ordenamiento
            List<BigDecimal> arrIzq = array.subList(0, pibote);
            List<BigDecimal> arrDer = array.subList(pibote+1, tam );
            
            //Se una la parte izquierda y derecha ordenadas junto con el pibote
            arrIzq = quicksort( arrIzq );
            arrDer = quicksort( arrDer );
            //arrayAux = [ array[pibote] ]
            
            arrayResult.addAll(arrIzq);
            arrayResult.add( array.get(pibote) );
            arrayResult.addAll(arrDer);
        }
        return arrayResult;
    }
    
    public static List<BigDecimal> converir(int[] array){
        List  arrayResult = new ArrayList();
        for(int i=0; i < array.length; i++){
            arrayResult.add( new BigDecimal(array[i]) );
        }
        return arrayResult;
    }
    
    public static void main(String[] args) {
        int[] lista = {2, 10, 3, 13, -1, 13, -10, 55, 11, 39, 1, 5, 8, 16, 17, 18, 8, 12, 4, 6, 15, 100, 7, 14, 9};
        //int[] lista = { 2, 10, 3, 1, 5, 8, 4, 6, 7, 9};
        System.out.println(Quicksort.converir(lista));
        List l = Quicksort.quicksort(Quicksort.converir(lista));
        System.out.println(l);
        BigDecimal bg = new BigDecimal(8);
        System.out.println(bg.doubleValue());
    }
}