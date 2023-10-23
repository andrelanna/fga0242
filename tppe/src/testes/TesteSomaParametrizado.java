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
public class TesteSomaParametrizado {

	@Parameters
	public static Iterable getParameters() {
		Object[][] dados = new Object[][] {
            {3, 2, 5},
            {-3, -2, -5},
            {3, 0, 3},
            {-3, 0, -3},
            {0, 0, 0},
            {-32768, 0, -32768},
            {-32768, 1, -32767},
            {32767, -1, 32766},
            {32767, 0, 32767}
        };
        
        return Arrays.asList(dados);
	}

	private Calculadora calc;
	private int a;
	private int b;
	private int res;
	
	public TesteSomaParametrizado(int a, int b, int res) {
		this.a = a;
		this.b = b;
		this.res = res;
	}
	
	@Test
	public void teste() {
		calc = new Calculadora((short)a, (short)b);
		assertEquals(res, calc.soma());
	}
	
	@Test(expected=ArithmeticException.class)
    public void testeLimiteInferiorExtrapolado() throws LimiteInferiorExtrapoladoException {
		calc = new Calculadora((short) -32768, (short) -1);
		assertEquals(res, calc.soma());
		calc = new Calculadora((short) -32768, (short) -2);
		assertEquals(res, calc.soma());
    }
	
	@Test(expected=ArithmeticException.class)
    public void testeLimiteSuperiorExtrapolado() throws LimiteSuperiorExtrapoladoException {
		calc = new Calculadora((short) 32767, (short) 1);
		assertEquals(res, calc.soma());
		calc = new Calculadora((short) 32767, (short) 2);
		assertEquals(res, calc.soma());
    }

}
