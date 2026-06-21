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
public class TesteSubtracaoParametrizado {
    
    @Parameters
    public static Iterable getParameters(){
        Object[][] parametros = new Object[][]{
            {3, 2, 1},
            {2, 3, -1},
            {-3, -2, -1},
            {-2, -3, 1},
            {3, 0, 3},
            {0, 3, -3},
            {-3, 0, -3},
            {0, 3, -3},
            {0, 0, 0},
            {-32768, 0, -32768},
            {-32768, -1, -32767},
            {-1, -32768, 32767},
            {-32768, -2, -32766},
            {-2, -32768, 32766},
            {-32767, -1, -32766},
            {-1, 32767, -32768},
            {32767, 0, 32767},
            {0, 32767, -32767},
            {32767, 1, 32766},
            {1, 32767, -32766},
            {32767, 2, 32765},
            {2, 32767, -32765}
        };
        return Arrays.asList(parametros);
    }
    
    private int primeiroOperando;
    private int segundoOperando;
    private int resultadoEsperado;
    
    public TesteSubtracaoParametrizado(int primeiroOperando, int segundoOperando, int resultadoEsperado){
        this.primeiroOperando = primeiroOperando;
        this.segundoOperando = segundoOperando;
        this.resultadoEsperado = resultadoEsperado;
    }
    
    @Test
    public void testWithParameters() throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException{
        short resultado = new Calculadora((short)primeiroOperando, (short)segundoOperando).subtracao();
        assertEquals(resultadoEsperado, resultado);
    }

    
}
