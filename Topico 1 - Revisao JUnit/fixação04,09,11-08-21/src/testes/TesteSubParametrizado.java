package testes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculadora;
import app.LimiteInferiorExtrapoladoException;
import app.LimiteSuperiorExtrapoladoException;


@RunWith(Parameterized.class)
public class TesteSubParametrizado {

    @Parameters
    public static Iterable getParameters() {
        Object[][] dados = new Object[][] {
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
            {32766, -1, 32767},
            {-1, 32767, -32768},
            {32767, 0, 32767},
            {0, 32767, -32767},
            {32767, 1, 32766},
            {1, 32767, -32766},
            {32767, 2, 32765},
            {2, 32767, -32765}
        };

        return Arrays.asList(dados);
    }
    private int op1;
    private int op2;
    private int resultadoEsperado;

    public TesteSubParametrizado(int op1, int op2, int resultadoEsperado) {
        this.op1 = op1;
        this.op2 = op2;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Test
    public void test() {
        int resultado = new Calculadora(op1, op2).sub();
        assertEquals(resultadoEsperado, resultado);
    }

    @Test(expected=ArithmeticException.class)
    public void testeLimiteInferior() throws LimiteInferiorExtrapoladoException {
        Calculadora calculadora = new Calculadora(-32768, 1);
        assertEquals(-32769, calculadora.sub());
    }

    @Test(expected=ArithmeticException.class)
    public void testeLimiteSuperior() throws LimiteSuperiorExtrapoladoException {
        Calculadora calculadora = new Calculadora(1, -32768);
        assertEquals(32769, calculadora.sub());
    }
}
