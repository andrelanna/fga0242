/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author marcos
 */
public class TesteSomaExceptions {
    
    @Test(expected = LimiteSuperiorExtrapoladoException.class)
    public void testLimiteSuperior() throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException{
        Calculadora calculadora = new Calculadora((short)32767, (short)1);
        assertEquals(0,calculadora.soma());
    }

    @Test(expected = LimiteSuperiorExtrapoladoException.class)
    public void testLimiteSuperior2() throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException{
        Calculadora calculadora = new Calculadora((short)32767, (short)2);
        assertEquals(0,calculadora.soma());
    }
    
    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void testLimiteInferior() throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException{
        Calculadora calculadora = new Calculadora((short)-32768, (short)-1);
        assertEquals(0,calculadora.soma());
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void testLimiteInferior2() throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException{
        Calculadora calculadora = new Calculadora((short)-32768, (short)-2);
        assertEquals(0,calculadora.soma());
    }
}
