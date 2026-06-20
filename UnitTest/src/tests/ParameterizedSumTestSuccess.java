package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculator;

@RunWith(Parameterized.class)
public class ParameterizedSumTestSuccess {

	@Parameters
	public static Iterable getParameters() {
		Object[][] datas = new Object[][]{
			{3, 2, 5},
			{-3, -2, -5},
			{3, 0, 3},
			{-3, 0, -3},
			{0, 0, 0},
			{-32768, 0, -32768},
			{-32768, 1, -32767},
			{32767, -1, 32766},
			{32767, 0, 32767},
		};
		
		return Arrays.asList(datas);
	}

	private int param1;
	private int param2;
	private int expectedResult;
	
	public ParameterizedSumTestSuccess(int param1, int param2, int expectedResult) {
		this.param1 = param1;
		this.param2 = param2;
		this.expectedResult = expectedResult;
	}

	@Test
	public void testSumSuccess() {
		short result = new Calculator().sum(param1, param2);
		assertEquals(expectedResult, result);
	}

}
