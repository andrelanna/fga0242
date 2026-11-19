package tests;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculator;

@RunWith(Parameterized.class)
public class ParameterizedTestSub {

	@Parameters
	public static Iterable getParameters() {
		Object[][] data = new Object[][] {
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
            {-32767, -1, -32766},
            {-1, 32767, -32768},
            {32767, 0, 32767},
            {0, 32767, -32767},
            {32767, 1, 32766},
            {1, 32767, -32766},
            {32767, 2, 32765},
            {2, 32767, -32765}
        };
        
        return Arrays.asList(data);
	}
	
	private int operando1;
	private int operando2;
	private int result;
	
	public ParameterizedTestSub(int operando1, int operando2, int result) {
		this.operando1 = operando1;
		this.operando2 = operando2;
		this.result = result;
	}
	
	@Test
	public void test() {
		int testResult = new Calculator(operando1, operando2).sub();
		assertEquals(result, testResult);
	}
}
