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
public class Cromosoma implements Serializable {

    public static int longitud = 0;
    protected BigDecimal valorReal;
    protected List<Byte> cadenaBinaria;
    protected BigDecimal aptitud;
    protected BigDecimal valorEsperado;
    protected BigDecimal probabilidadAcumulada;

    public Cromosoma(BigDecimal valorDecimal) {
        this.valorReal = valorDecimal;
        cadenaBinaria = parseByte();
        aptitud = new BigDecimal(BigInteger.ZERO);
        valorEsperado = new BigDecimal(BigInteger.ZERO);
        probabilidadAcumulada = new BigDecimal(BigInteger.ZERO);
    }

    public Cromosoma(List<Byte> cadenaBinaria) {
        valorReal = parseReal(cadenaBinaria);
        this.cadenaBinaria = cadenaBinaria;
        aptitud = new BigDecimal(BigInteger.ZERO);
        valorEsperado = new BigDecimal(BigInteger.ZERO);
        probabilidadAcumulada = new BigDecimal(BigInteger.ZERO);
    }

    public static List<Byte> parseByte(int valor) {
        List<Byte> cadena = new ArrayList<>();
        while (valor > 0) {
            cadena.add((byte) (valor % 2));
            valor /= 2;
        }
        return cadena;
    }

    public static BigDecimal parseReal(List<Byte> cadena) {
        int result = 0;
        int potencia = 0;
        for (Byte valorAlelo : cadena) {
            result += (valorAlelo << potencia);
            potencia++;
        }
        return new BigDecimal(result);
    }

    public static double parseDouble(String valor) {
        double result = 0;
        int potencia = 0;
        for (int i = valor.length(); i != 0; i--) {
            byte r = Byte.parseByte(valor.charAt(i - 1) + "");
            result += (r << potencia);
            potencia++;
        }
        return result;
    }

    protected final List<Byte> parseByte() {
        int valor = valorReal.intValue();
        List<Byte> cadena = new ArrayList<>();
        while (valor > 0) {
            cadena.add((byte) (valor % 2));
            valor /= 2;
        }
        while (cadena.size() < longitud) {
            cadena.add((byte) 0);
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

    public List<Byte> getCadenaBinaria(int ini, int fin) {
        return cadenaBinaria.subList(ini, fin);
    }

    public List<Byte> getCadenaBinariaR() {
        List<Byte> reverse = new ArrayList<>(cadenaBinaria);
        Collections.reverse(reverse);
        return reverse;
    }

    public BigDecimal getAptitud() {
        return aptitud;
    }

    ;

    public void setAptitud(BigDecimal aptitud) {
        this.aptitud = aptitud;
    }

    public BigDecimal getValorEsperado() {
        return valorEsperado;
    }

    public void setValorEsperado(BigDecimal valorEsperado) {
        this.valorEsperado = valorEsperado;
    }

    public BigDecimal getProbabilidadAcumulada() {
        return probabilidadAcumulada;
    }

    public void setProbabilidadAcumulada(BigDecimal probabilidadAcumulada) {
        this.probabilidadAcumulada = probabilidadAcumulada;
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"valorReal\": ").append(valorReal)
                .append(",\"cadenaBinaria\": \"").append(cadenaBinaria).append("\"")
                .append(",\"aptitud\": ").append(aptitud)
                .append(",\"valorEsperado\": ").append(valorEsperado)
                .append(",\"probabilidadAcumulada\": ").append(probabilidadAcumulada).append("}");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"valorReal\": ").append(valorReal)
                .append(",\"cadenaBinaria\": \"").append(cadenaBinaria).append("\"")
                .append(",\"aptitud\": ").append(aptitud)
                .append(",\"valorEsperado\": ").append(valorEsperado)
                .append(",\"probabilidadAcumulada\": ").append(probabilidadAcumulada).append("}");
        return sb.toString();
    }
}
