package test;

import static org.junit.Assert.assertEquals;

import app.*;

import org.junit.Test;

public class ExceptionTest {

    @Test(expected = ArithmeticException.class)
    public void sumLowerThresholdTest() throws LowerThresholdException {
        Calculator calc = new Calculator(-32768, -1);
        assertEquals(-32769, calc.sum());
    }

    @Test(expected = ArithmeticException.class)
    public void sumLowerThresholdTest2() throws LowerThresholdException {
        Calculator calc = new Calculator(-32768, -2);
        assertEquals(-32770, calc.sum());
    }

    @Test(expected = ArithmeticException.class)
    public void sumUpperThresholdTest() throws UpperThresholdException {
        Calculator calc = new Calculator(32767, 1);
        assertEquals(32768, calc.sum());
    }

    @Test(expected = ArithmeticException.class)
    public void sumUpperThresholdTest2() throws UpperThresholdException {
        Calculator calc = new Calculator(32767, 2);
        assertEquals(32769, calc.sum());
    }

    @Test(expected = ArithmeticException.class)
    public void subtractionLowerThresholdTest() throws LowerThresholdException {
        Calculator calc = new Calculator(-32768, 1);
        assertEquals(-32769, calc.subtraction());
    }

    @Test(expected = ArithmeticException.class)
    public void subtractionUpperThresholdTest() throws UpperThresholdException {
        Calculator calc = new Calculator(1, -32768);
        assertEquals(32769, calc.subtraction());
    }
}