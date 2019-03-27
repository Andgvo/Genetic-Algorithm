package com.ipn.mx.geneticos.tecnica.ruleta;

import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.Rango;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Ruleta
 * @author andres
 */
public class Ruleta {
    private BigDecimal numeroIndividuos;                                  //tamaño de la población
    private BigDecimal f;                           //Promedio de aptitud
    private Poblacion<IndividuoRuleta> poblacion;   //poblacion
    private BigDecimal t;                           //Sumatoria promedio de aptitud
    private BigDecimal r;                           //Numero aleatoria entre 0 y t

    public Ruleta(BigDecimal numeroIndividuos, Rango rango) {
        this.poblacion = new Poblacion(IndividuoRuleta.class, numeroIndividuos, rango );
        this.numeroIndividuos = numeroIndividuos;
        t = new BigDecimal(BigInteger.ZERO);
        f = 
            poblacion.getSumatoriaAptitud().
                divide(numeroIndividuos, 2, RoundingMode.HALF_UP);
        setValoresEsperados();
        BigDecimal aux = new BigDecimal( new Random().nextInt(t.intValue()*10) );
        r = aux.divide( new BigDecimal(10) , 2, RoundingMode.HALF_UP );
    }
    
    /**
     * Obtener padres de Poblacion 
     */
    public void getPadres(){
        // r -> [0, t] se multiplica y divide para obtener 2 decimales.  
        BigDecimal aux = new BigDecimal( new Random().nextInt(t.intValue()*10) );
        r = aux.divide( new BigDecimal(10) , 2, RoundingMode.HALF_UP );
    }
    
    /**
     * Metodo para evaluar la funcion de aptitud
     * @param x valor de 'x' en la funcion f(x)
     * @return 
     */
    public static final BigDecimal funcion( BigDecimal x ){
        BigDecimal resultado = new BigDecimal
            ( x.intValue() * x.intValue() + 0.5); //f(x
        return resultado;
    }
    
    private void setValoresEsperados(){
        poblacion.stream().map((cromosoma) -> (IndividuoRuleta) cromosoma).forEachOrdered((individuo) -> {
            individuo.setValorEsperado( individuo.getAptitud().divide(f, 2, RoundingMode.HALF_UP) );
            t = t.add(individuo.getValorEsperado());
        });
    }
    
    public void getTabla() {
        poblacion.forEach((o) -> System.out.println(o));
        System.out.println("N: "+poblacion.getN());
        System.out.println("sum: "+poblacion.getSumatoriaAptitud());
        System.out.println("f: "+f);
        System.out.println("T: "+t);
        char epsilon = 8712;
        System.out.println("r "+epsilon+" [ 0.0 : "+ r +" ]");
    }

    public BigDecimal getNumeroIndividuos() {
        return numeroIndividuos;
    }

    public void setNumeroIndividuos(BigDecimal numeroIndividuos) {
        this.numeroIndividuos = numeroIndividuos;
    }

    public BigDecimal getF() {
        return f;
    }

    public void setF(BigDecimal f) {
        this.f = f;
    }

    public Poblacion<IndividuoRuleta> getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Poblacion<IndividuoRuleta> poblacion) {
        this.poblacion = poblacion;
    }

    public BigDecimal getT() {
        return t;
    }

    public void setT(BigDecimal t) {
        this.t = t;
    }

    public BigDecimal getR() {
        return r;
    }

    public void setR(BigDecimal r) {
        this.r = r;
    }
      
}