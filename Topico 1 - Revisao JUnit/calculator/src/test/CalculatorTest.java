package test;

import static org.junit.Assert.*;
import app.Calculator;
import app.exception.*;
import org.junit.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    private static final int LOWER_LIMIT = -32768;
    private static final int HIGHER_LIMIT = 32767;

    //addition tests
    @Test
    public void addPositiveIntegers() throws ArithmeticException {
        assertEquals(17, calculator.addition((short) 10, (short) 7));
    }

    @Test
    public void addNegativeIntegers() throws ArithmeticException {
        assertEquals(-42, calculator.addition((short) -30, (short) -12));
    }

    @Test
    public void addPositiveAndNegativeIntegers() throws ArithmeticException {
        assertEquals(4, calculator.addition((short) 7, (short) -3));
    }

    @Test
    public void addZeroWithIntegers() throws ArithmeticException {
        assertEquals(7, calculator.addition((short) 0, (short) 7));
    }

    @Test
    public void addTwoZeros() throws ArithmeticException {
        assertEquals(0, calculator.addition((short) 0, (short) 0));
    }

    @Test
    public void addNegativeLimitWithZero() throws ArithmeticException {
        assertEquals(-32768, calculator.addition((short) -32768, (short) 0));
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void extrapolateLowerLimitWithMinusOne() throws ArithmeticException {
        calculator.addition((short) LOWER_LIMIT, (short) -1);
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void extrapolateLowerLimit() throws ArithmeticException {
        calculator.addition((short) LOWER_LIMIT, (short) -112);
    }

    @Test(expected = LimiteSuperiorExtrapoladoException.class)
    public void extrapolateHigherLimit() throws ArithmeticException {
        calculator.addition((short) HIGHER_LIMIT, (short) 112);
    }

    //subtraction tests
    @Test
    public void subPositiveIntegers() throws ArithmeticException {
        assertEquals(3, calculator.subtraction((short) 10, (short) 7));
    }

    @Test
    public void subNegativeIntegers() throws ArithmeticException {
        assertEquals(-18, calculator.subtraction((short) -30, (short) -12));
    }

    @Test
    public void subPositiveAndNegativeIntegers() throws ArithmeticException {
        assertEquals(10, calculator.subtraction((short) 7, (short) -3));
    }

    @Test
    public void subZeroWithIntegers() throws ArithmeticException {
        assertEquals(-7, calculator.subtraction((short) 0, (short) 7));
    }

    @Test
    public void subTwoZeros() throws ArithmeticException {
        assertEquals(0, calculator.subtraction((short) 0, (short) 0));
    }

    @Test
    public void subNegativeLimitWithZero() throws ArithmeticException {
        assertEquals(-32768, calculator.subtraction((short) -32768, (short) 0));
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void subExtrapolateLowerLimitWithOne() throws ArithmeticException {
        calculator.subtraction((short) LOWER_LIMIT, (short) 1);
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void subExtrapolateLowerLimit() throws ArithmeticException {
        calculator.subtraction((short) LOWER_LIMIT, (short) 112);
    }

    @Test(expected = LimiteSuperiorExtrapoladoException.class)
    public void subExtrapolateHigherLimit() throws ArithmeticException {
        calculator.subtraction((short) HIGHER_LIMIT, (short) -112);
    }
}
