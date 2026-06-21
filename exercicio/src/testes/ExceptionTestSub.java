package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import calculadora.Calculadora;
import calculadora.LimiteSuperior;
import calculadora.LimiteInferior;

public class ExceptionTestSub {

	@Test(expected = ArithmeticException.class)
    public void testeLimiteSuperior() throws LimiteSuperior {
		int testResult = new Calculadora((short) 1, (short) -32768).sub();
		assertEquals(0, testResult);
    }
	@Test(expected = ArithmeticException.class)
    public void testeLimiteInferior() throws LimiteInferior {
		int testResult = new Calculadora((short) -32768, (short) 1).sub();
		assertEquals(0, testResult);
    }

}
