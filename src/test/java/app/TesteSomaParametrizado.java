/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
/**
 *
 * @author marcos
 */
@RunWith(Parameterized.class)
public class TesteSomaParametrizado {
    
    @Parameters
    public static Iterable getParameters(){
        Object[][] parametros = new Object[][]{
            {3, 2, 5},
            {-3, -2, -5},
            {3, 0, 3},
            {-3, 0, -3},
            {0, 0, 0},
            {-32768, 0, -32768},
            {-32768, 1, -32767},
            {32767, -1, 32766},
            {32767, 0, 32767},
        };
        return Arrays.asList(parametros);
    }
    
    private int primeiroOperando;
    private int segundoOperando;
    private int resultadoEsperado;
    
    public TesteSomaParametrizado(int primeiroOperando, int segundoOperando, int resultadoEsperado){
        this.primeiroOperando = primeiroOperando;
        this.segundoOperando = segundoOperando;
        this.resultadoEsperado = resultadoEsperado;
    }
    
    @Test
    public void testWithParameters() throws LimiteSuperiorExceditoException, LimiteInferiorExceditoException{
        short resultado = new Calculadora((short)primeiroOperando, (short)segundoOperando).soma();
        assertEquals(resultadoEsperado, resultado);
    }

    
}
