
package com.ipn.mx.geneticos.modelo.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author andres
 */
public class Cromosoma {
    protected BigDecimal valorReal;
    protected BigDecimal valorEntero;
    protected BigDecimal valorGray;
    protected List<Byte> cadenaBinaria;
    protected List<Byte> cadenaGray;
    protected BigDecimal aptitud;
    
    public Cromosoma(BigDecimal valorDecimal) {
        this.valorReal = valorDecimal;
        valorEntero = new BigDecimal(valorReal.intValue());
        cadenaBinaria = parseByte();
        valorGray = new BigDecimal(parseGray());
        cadenaGray = parseByte( valorGray.intValue() );
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
    
    public static int parseGray(BigDecimal valorDecimal){
        int original = valorDecimal.intValue();
        int corrimiento = valorDecimal.intValue()>>1;
        return original^corrimiento;
    }
    
    protected final int parseGray(){
        int original = valorReal.intValue();
        int corrimiento = valorReal.intValue()>>1;
        return original^corrimiento;
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

    public BigDecimal getValorGray() {
        return valorGray;
    }

    public void setValorGray(BigDecimal valorGray) {
        this.valorGray = valorGray;
    }

    public List<Byte> getCadenaGray() {
        return cadenaGray;
    }

    public void setCadenaGray(List<Byte> cadenaGray) {
        this.cadenaGray = cadenaGray;
    }
    
}
