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
public class TesteSubtracaoParametrizado {

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
            {-32767, -1, -32766},
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

	private Calculadora calc;
	private int a;
	private int b;
	private int res;
	
	public TesteSubtracaoParametrizado(int a, int b, int res) {
		this.a = a;
		this.b = b;
		this.res = res;
	}
	
	@Test
	public void teste() {
		calc = new Calculadora((short)a, (short)b);
		assertEquals(res, calc.subtracao());
	}
	
	@Test(expected=ArithmeticException.class)
    public void testeLimiteInferiorExtrapolado() throws LimiteInferiorExtrapoladoException {
		calc = new Calculadora((short) -32768, (short) 1);
		assertEquals(res, calc.subtracao());
    }
	
	@Test(expected=ArithmeticException.class)
    public void testeLimiteSuperiorExtrapolado() throws LimiteSuperiorExtrapoladoException {
		calc = new Calculadora((short) 1, (short) -32768);
		assertEquals(res, calc.subtracao());
    }

}
