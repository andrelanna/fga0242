/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author marcos
 */
public class LimiteSuperiorExceditoException extends ArithmeticException {

    public LimiteSuperiorExceditoException() {
        super("Limite superior excedido");
    }
    
}
