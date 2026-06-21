package tests;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculator;

@RunWith(Parameterized.class)
public class ParameterizedTestSum {

	@Parameters
	public static Iterable getParameters() {
		Object[][] data = new Object[][] {
            {3, 2, 5},
            {-3, -2, -5},
            {3, 0, 3},
            {-3, 0, -3},
            {0, 0, 0},
            {-32768, 0, -32768},
            {-32768, 1, -32767},
            {32767, -1, 32766},
            {32767, 0, 32767}
        };
        
        return Arrays.asList(data);
	}
	
	private int operando1;
	private int operando2;
	private int result;
	
	public ParameterizedTestSum(int operando1, int operando2, int result) {
		this.operando1 = operando1;
		this.operando2 = operando2;
		this.result = result;
	}
	
	@Test
	public void test() {
		int testResult = new Calculator(operando1, operando2).sum();
		assertEquals(result, testResult);
	}
}
