package app;

import app.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SumTest {

    private short p1, p2, expectedResult;



    @Parameterized.Parameters
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

    public SumTest(int p1, int p2, int expectedResult) {
        this.p1 = (short) p1;
        this.p2 = (short) p2;
        this.expectedResult = (short) expectedResult;
    }

    @Test
    public void test() throws ArithmeticException {
        int result = new Calculator(p1, p2).sum();
        assertEquals(expectedResult, result);
    }

}
