
package com.ipn.mx.geneticos.modelo.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author andres
 */
public class CromosomaExtended extends Cromosoma{
    protected List<Byte> cadenaGray;
    protected BigDecimal valorGray;
    
    public CromosomaExtended(BigDecimal valorDecimal) {
        super(valorDecimal);
        valorGray = new BigDecimal(parseGray());
        cadenaGray = parseByte( valorGray.intValue() );
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
