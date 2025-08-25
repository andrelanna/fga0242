package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Calculator;
import app.LimiteInferiorExtrapoladoException;import app.LimiteSuperiorExtrapoladoException;

public class ExceptionTestSub {

	@Test(expected=ArithmeticException.class)
    public void testeLimiteInferiorExtrapolado() throws LimiteInferiorExtrapoladoException {
		int testResult = new Calculator((short) -32768, (short) 1).sub();
		assertEquals(0, testResult);
    }
	
	@Test(expected=ArithmeticException.class)
    public void testeLimiteSuperiorExtrapolado() throws LimiteSuperiorExtrapoladoException {
		int testResult = new Calculator((short) 1, (short) -32768).sub();
		assertEquals(0, testResult);
    }
}
