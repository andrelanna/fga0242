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
    
    private void verificarLimites(int valor) throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException{
        if(valor > 32767){
            throw new LimiteSuperiorExtrapoladoException();
        }
        if(valor < -32768){
            throw new LimiteInferiorExtrapoladoException();
        }
    }
    
    public short soma() throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException{
        this.verificarLimites((int)this.primeiroOperando + this.segundoOperando);
        return (short) (this.primeiroOperando + this.segundoOperando);
    }
    
    public short subtracao() throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException{
        this.verificarLimites((int)this.primeiroOperando - this.segundoOperando);
        return (short) (this.primeiroOperando - this.segundoOperando);
    }
    
}
