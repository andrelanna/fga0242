/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class Calculadora {
    private short primeiroOperando;
    private short segundoOperando;
    
    public Calculadora(short primeiroOperando, short segundoOperando){
        this.primeiroOperando = primeiroOperando;
        this.segundoOperando = segundoOperando;
    }
    
    private void verificarLimites(int valor) throws LimiteSuperiorExceditoException, LimiteInferiorExceditoException{
        if(valor > 32767){
            throw new LimiteSuperiorExceditoException();
        }
        if(valor < -32768){
            throw new LimiteInferiorExceditoException();
        }
    }
    
    public short soma() throws LimiteSuperiorExceditoException, LimiteInferiorExceditoException{
        this.verificarLimites((int)this.primeiroOperando + this.segundoOperando);
        return (short) (this.primeiroOperando + this.segundoOperando);
    }
    
    public short subtracao() throws LimiteSuperiorExceditoException, LimiteInferiorExceditoException{
        this.verificarLimites((int)this.primeiroOperando - this.segundoOperando);
        return (short) (this.primeiroOperando - this.segundoOperando);
    }
    
    public static void main(String args[]){
        try {
            System.out.println(new Calculadora((short)32767, (short)1).soma());
        } catch (LimiteSuperiorExceditoException ex) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LimiteInferiorExceditoException ex) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

   
    
}
