package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Calculator;
import app.LimiteInferiorExtrapoladoException;
import app.LimiteSuperiorExtrapoladoException;

public class ExceptionTestSum {

	@Test(expected=ArithmeticException.class)
    public void testeLimiteInferiorExtrapolado1() throws LimiteInferiorExtrapoladoException {
		int testResult = new Calculator((short) -32768, (short) -1).sum();
		assertEquals(0, testResult);
	}
	
	@Test(expected=ArithmeticException.class)
    public void testeLimiteInferiorExtrapolado2() throws LimiteInferiorExtrapoladoException {
		int testResult = new Calculator((short) -32768, (short) -2).sum();
		assertEquals(0, testResult);
    }
	
	@Test(expected=ArithmeticException.class)
    public void testeLimiteSuperiorExtrapolado1() throws LimiteSuperiorExtrapoladoException {
		int testResult = new Calculator((short) 32767, (short) 1).sum();
		assertEquals(0, testResult);
	}
	
	@Test(expected=ArithmeticException.class)
    public void testeLimiteSuperiorExtrapolado2() throws LimiteSuperiorExtrapoladoException {
		int testResult = new Calculator((short) 32767, (short) 2).sum();
		assertEquals(0, testResult);
    }

}
