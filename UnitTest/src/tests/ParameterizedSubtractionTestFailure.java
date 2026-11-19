package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculator;
import exceptions.LimitException;

@RunWith(Parameterized.class)
public class ParameterizedSubtractionTestFailure {
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] datas = new Object[][]{
			{-32768, 1, -32769},
			{1, -32768, -32769},
			{32767, -1, 32768},
			{-1, 32768, -32769},
		};
		
		return Arrays.asList(datas);
	}

	private int param1;
	private int param2;
	private int expectedResult;
	
	public ParameterizedSubtractionTestFailure(int param1, int param2, int expectedResult) {
		this.param1 = param1;
		this.param2 = param2;
		this.expectedResult = expectedResult;
	}

	@Test(expected=LimitException.class)
	public void testSubtractionFailure() throws LimitException {
		short result = new Calculator().subtraction(param1, param2);
		assertEquals(expectedResult, result);
	}
}
