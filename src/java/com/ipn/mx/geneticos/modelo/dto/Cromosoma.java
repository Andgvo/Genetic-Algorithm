
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
    protected List<Byte> cadenaBinaria;
    protected BigDecimal aptitud;
    protected BigDecimal valorEsperado;
    
    public Cromosoma(BigDecimal valorDecimal) {
        this.valorReal = valorDecimal;
        cadenaBinaria = parseByte();
        aptitud = new BigDecimal(BigInteger.ZERO);
        valorEsperado = new BigDecimal(BigInteger.ZERO);
    }
    
    public static List<Byte> parseByte( int valor ){
        List<Byte> cadena = new ArrayList<>();
        while( valor > 0 ){
            cadena.add( (byte) (valor%2) );
            valor/=2;
        }
        return cadena;
    }
    
    public static double parseDouble( String valor ){
        double result=0;
        int base = 0;
        for(int i = valor.length(); i != 0; i--){
            byte r = Byte.parseByte(valor.charAt(i-1)+"");
            result+= (r<<base);
            base++;
        }
        return result;
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
    
    public BigDecimal getValorEsperado() {
        return valorEsperado;
    }
    
    public void setValorEsperado(BigDecimal valorEsperado){
        this.valorEsperado = valorEsperado;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("valorReal= ").append(valorReal)
        .append("\tcadenaBinaria= ").append(cadenaBinaria)
        .append("\taptitud= ").append(aptitud)
        .append("\tvalorEsperado= ").append(valorEsperado);
        return sb.toString();
    }
}