
package com.ipn.mx.geneticos.modelo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author andres
 */
public class Cromosoma implements Serializable{
    protected BigDecimal valorReal;
    protected BigDecimal valorEntero;
    protected List<Byte> cadenaBinaria;
    protected BigDecimal aptitud;
    
    public Cromosoma(BigDecimal valorDecimal) {
        this.valorReal = valorDecimal;
        valorEntero = new BigDecimal(valorReal.intValue());
        cadenaBinaria = parseByte();
        aptitud = new BigDecimal(BigInteger.ZERO);
    }
    
    public static List<Byte> parseByte( int valor ){
        List<Byte> cadena = new ArrayList<>();
        while( valor > 0 ){
            cadena.add( (byte) (valor%2) );
            valor/=2;
        }
        return cadena;
    }
    
    protected final List<Byte> parseByte(){
        int valor = valorReal.intValue();
        List<Byte> cadena = new ArrayList<>();
        while( valor > 0 ){
            cadena.add( (byte) (valor%2) );
            valor/=2;
        }
        return cadena;
    }
    
    
    
    // GETTERS AND SETTERS 
    public BigDecimal getValorReal() {
        return valorReal;
    }

    public void setValorReal(BigDecimal valorReal) {
        this.valorReal = valorReal;
    }

    public List<Byte> getCadenaBinaria() {
        return cadenaBinaria;
    }
    
    public List<Byte> getCadenaBinariaR() {
        List<Byte> reverse = new ArrayList<>(cadenaBinaria);
        Collections.reverse(reverse);
        return reverse;
    }

    public BigDecimal getAptitud(){
        return aptitud;
    };

    public void setAptitud(BigDecimal aptitud) {
        this.aptitud = aptitud;
    }

    public BigDecimal getValorEntero() {
        return valorEntero;
    }

    public void setValorEntero(BigDecimal valorEntero) {
        this.valorEntero = valorEntero;
    }
    
}