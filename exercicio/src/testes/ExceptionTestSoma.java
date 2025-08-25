package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import calculadora.Calculadora;
import calculadora.LimiteInferior;
import calculadora.LimiteSuperior;

public class ExceptionTestSoma {

	@Test(expected = ArithmeticException.class)
    public void testeLimiteInferiorExtrapolado1() throws LimiteInferior {
		int testeResultado = new Calculadora((short) -32768, (short) -1).sum();
		assertEquals(0, testeResultado);
	}
	
	@Test(expected = ArithmeticException.class)
    public void testeLimiteInferiorExtrapolado2() throws LimiteInferior {
		int testeResultado = new Calculadora((short) -32768, (short) -2).sum();
		assertEquals(0, testeResultado);
    }
	
	@Test(expected = ArithmeticException.class)
    public void testeLimiteSuperiorExtrapolado1() throws LimiteSuperior {
		int testeResultado = new Calculadora((short) 32767, (short) 1).sum();
		assertEquals(0, testeResultado);
	}
	
	@Test(expected = ArithmeticException.class)
    public void testeLimiteSuperiorExtrapolado2() throws LimiteSuperior{
		int testeResultado = new Calculadora((short) 32767, (short) 2).sum();
		assertEquals(0, testeResultado);
    }

}
