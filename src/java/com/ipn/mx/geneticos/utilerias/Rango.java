
package com.ipn.mx.geneticos.utilerias;

/**
 *
 * @author Andres
 */
public class Rango {
    private int valorMinimo;
    private int valorMaximo;

    public Rango(int valorMinimo, int valorMaximo) {
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
    }

    public int getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(int valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }
    
}
