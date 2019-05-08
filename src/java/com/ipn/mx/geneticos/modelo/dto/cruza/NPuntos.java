package com.ipn.mx.geneticos.modelo.dto.cruza;

import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.ParseCromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.RandomC;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andres
 * @param <T>
 */
public class NPuntos<T extends Cromosoma> extends ParseCromosoma<T> implements Cruza<T> {
    private static final RandomC RANDOM = new RandomC();
    protected int puntos;
    private List<Byte> cadenaHijo1;
    private List<Byte> cadenaHijo2;

    public NPuntos(int puntos, Class type) {
        super(type);
        this.puntos = puntos;
    }

    @Override
    public void cruzar(Poblacion<T> descendientes, T cromosoma1, T cromosoma2) {
        if(Cromosoma.longitud > puntos){
            //Forzamos a que el random genere numeros excluyendo inicio y final
            List<Integer> cortes = RANDOM.cortesRandom(1, Cromosoma.longitud, puntos);
            cortes.add(0,0);                    //Se agrega el inicio de la cadena
            cortes.add(Cromosoma.longitud );    //Se agrega el final de la cadena
            cadenaHijo1 = new ArrayList<>();
            cadenaHijo2 = new ArrayList<>();
            int tam = cortes.size()-1;
            byte cambio = 0;
            for(int i= 0; i < tam; i++){
                if(cambio == 0){
                    cadenaHijo1.addAll( cromosoma1.getCadenaBinaria(cortes.get(i), cortes.get(i+1)) );
                    cadenaHijo2.addAll( cromosoma2.getCadenaBinaria(cortes.get(i), cortes.get(i+1)) );
                    cambio = 1;
                }else{
                    cadenaHijo1.addAll( cromosoma2.getCadenaBinaria(cortes.get(i), cortes.get(i+1)) );
                    cadenaHijo2.addAll( cromosoma1.getCadenaBinaria(cortes.get(i), cortes.get(i+1)) );
                    cambio = 0;
                }
            }
            descendientes.add( instanciaDeCromosoma( cadenaHijo1 ) );
            descendientes.add( instanciaDeCromosoma( cadenaHijo2 ) );
        }
    }
    
    @Override
    public Poblacion<T> cruzarPoblacion(Poblacion<T> poblacion) {
        Poblacion<T> descendientes = new Poblacion<>(type);
        for (int i = 0; i < poblacion.size(); i += 2) {
            cruzar(descendientes, poblacion.get(i), poblacion.get(i + 1));
        }
        return descendientes;
    }

    @Override
    public String toString() {
        return "NPuntos{" + "puntos=" + puntos + '}';
    }
    
}
