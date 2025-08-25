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
public class ParameterizedSubtractionTestSuccess {
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] datas = new Object[][]{
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
			{32767, 0, 32767},
			{0, 32767, -32767},
			{32767, 1, 32766},
			{1, 32767, -32766},
			{32767, 2, 32765},
			{2, 32767, -32765},
		};
		
		return Arrays.asList(datas);
	}

	private int param1;
	private int param2;
	private int expectedResult;
	
	public ParameterizedSubtractionTestSuccess(int param1, int param2, int expectedResult) {
		this.param1 = param1;
		this.param2 = param2;
		this.expectedResult = expectedResult;
	}

	@Test
	public void testSubtractionSuccess() {
		short result = new Calculator().subtraction(param1, param2);
		assertEquals(expectedResult, result);
	}
}
