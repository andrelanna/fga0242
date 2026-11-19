package calculadora.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import exceptions.LimiteInferiorExtrapoladoException;
import exceptions.LimiteSuperiorExtrapoladoException;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Assert;

public class sumTest {
	
	@Parameters
    public static Iterable getParameters() {
        Object[][] data = new Object[][]{
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
        return Arrays.asList(data);
    }


	private int op1;
	private int op2;
	private int expectedResult;
	
	public void TestSumParametrized(int op1, int op2, int expectedResult) {
		this.op1 = op1;
		this.op2 = op2;
		this.expectedResult = expectedResult;
	}

	
    @Test
    public void test() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
        int result = calculadora.calculadora.add(op1,  op2);

        assertEquals(result, expectedResult);
    }
	

}
