package com.exerciciotppe;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class TesteSubtracaoParametrizado {
    @Parameters
    public static Iterable getParameters(){
        Object[][] dados = new Object[][]{
            {3,2,1},
            {2,3,-1},
            {-3,-2,-1},
            {-2,-3,1},
            {3,0,3},
            {0,3,-3},
            {-3,0,-3},
            {0,3,-3},
            {0,0,0},
            {-32768,0,-32768},
            {-32768,-1,-32767},
            {-1,-32768,32767},
            {-32768,-2,-32766},
            {-2	,-32768,32766},
            {32767,1,32766},
            {-1,32767,-32768},
            {32767,0,32767},
            {0,32767,-32767},
            {32767,	1,32766},
            {1,32767,-32766},
            {32767,	2,32765},
            {2,32767,-32765}
        };
        return Arrays.asList(dados);
    }

    private Calculadora calculadora;
    private int op1;
    private int op2;
    private int resultadoEsperado;

    public TesteSubtracaoParametrizado(int op1, int op2, int resultadoEsperado){
        this.op1 = op1;
        this.op2 = op2;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Test
    public void testSubtracaoParametrizado(){
        calculadora = new Calculadora((short) op1, (short)op2);
        assertEquals(resultadoEsperado, calculadora.subtracao());
    }

    @Test(expected=ArithmeticException.class)
    public void testLimiteInferiorExtrapolado() throws LimiteInferiorExtrapoladoException {
		calculadora = new Calculadora((short) -32768, (short) 1);
		assertEquals(resultadoEsperado, calculadora.subtracao());

    }

	@Test(expected=ArithmeticException.class)
    public void testLimiteSuperiorExtrapolado() throws LimiteSuperiorExtrapoladoException {
		calculadora = new Calculadora((short) 1, (short) -32768);
		assertEquals(resultadoEsperado, calculadora.subtracao());
    }
    
}
