package com.exerciciotppe;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class TesteAdicaoParametrizado {
    @Parameters
    public static Iterable getParameters(){
        Object[][] dados = new Object[][]{
            {3,2,5},
            {-3,-2,-5},
            {3,	0,3},
            {-3,0,-3},
            {0,0,0},
            {-32768,0,-32768},
            {-32768,1,-32767},
            {32767,	-1,32766},
            {32767,	0,32767}
        };
        return Arrays.asList(dados);
    }

    private Calculadora calculadora;
    private int op1;
    private int op2;
    private int resultadoEsperado;

    public TesteAdicaoParametrizado(int op1, int op2, int resultadoEsperado){
        this.op1 = op1;
        this.op2 = op2;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Test
    public void testAdicaoParametrizado(){
        calculadora = new Calculadora((short) op1, (short)op2);
        assertEquals(resultadoEsperado, calculadora.adicao());
    }

    @Test(expected=ArithmeticException.class)
    public void testLimiteInferiorExtrapolado() throws LimiteInferiorExtrapoladoException {
		calculadora = new Calculadora((short) -32768, (short) -1);
		assertEquals(resultadoEsperado, calculadora.adicao());
		calculadora = new Calculadora((short) -32768, (short) -2);
		assertEquals(resultadoEsperado, calculadora.adicao());
    }

	@Test(expected=ArithmeticException.class)
    public void testLimiteSuperiorExtrapolado() throws LimiteSuperiorExtrapoladoException {
		calculadora = new Calculadora((short) 32767, (short) 1);
		assertEquals(resultadoEsperado, calculadora.adicao());
		calculadora = new Calculadora((short) 32767, (short) 2);
		assertEquals(resultadoEsperado, calculadora.adicao());
    }
}
