
package com.ipn.mx.geneticos.modelo.dao.factory;

import com.ipn.mx.geneticos.modelo.dto.cruza.Cruza;
import com.ipn.mx.geneticos.modelo.dto.cruza.NPuntos;
import com.ipn.mx.geneticos.modelo.dto.mutacion.CambioBit;
import com.ipn.mx.geneticos.modelo.dto.mutacion.Mutacion;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Jerarquia;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Seleccion;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Ruleta;
import com.ipn.mx.geneticos.modelo.dto.seleccion.Torneo;

/**
 *
 * @author andres
 */
public abstract class MetodoFactory {

    public static Seleccion getSeleccion(String tipo, Class type){
        if(null == tipo){
            return null;
        }else switch (tipo) {
            case "RULETA":
                return new Ruleta(type);
            case "TORNEO":
                return new Torneo(type);
            case "JERARQUICO":
                return new Jerarquia(type);
            default:
                return null;
        }
    }
    
    public static Cruza getCruza(String tipo, int puntos, Class type){
        if(tipo == null){
            return null;
        }else switch(tipo){
            case "N_PUNTOS":
                return new NPuntos(puntos,type);
            default:
                return null;
        }
    }
    
    public static Mutacion getMutacion(String tipo, String porcentaje, Class type){
        if(tipo == null){
            return null;
        }else switch(tipo){
            case "CAMBIO_BTI":
                return new CambioBit(porcentaje, type);
            default:
                return null;
        }
    }
    
}
