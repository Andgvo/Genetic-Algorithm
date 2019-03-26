package com.ipn.mx.geneticos.tecnica.ruleta;

import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.utilerias.Rango;
import java.math.BigDecimal;

/**
 *
 * @author Andres
 */
public class MetodoRuleta {
    private BigDecimal numeroIndividuos;
    private Rango rango;
    private Ruleta ruleta;
    private Poblacion padres;
    private Poblacion hijos;

    public MetodoRuleta(BigDecimal numeroIndividuos, Rango rango) {
        this.numeroIndividuos = numeroIndividuos;
        this.rango = rango;
        ruleta = new Ruleta( numeroIndividuos.intValue() );
    }
    
    public void execute(){
        
    }
    
    public static void main(String[] args) {
        Rango rango = new Rango(1, 10);
        BigDecimal num = new BigDecimal(20);
        MetodoRuleta mr = new MetodoRuleta(num,rango);
        mr.execute();
    }
}
