package test;

import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.*;

@RunWith(Parameterized.class)
public class SumTest {

    @Parameters
    public static Iterable getParameters() {
        Object[][] sumData = new Object[][]{
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
        return Arrays.asList(sumData);
    }

    private int x;
    private int y;
    private int expectedResult;

    public SumTest(int x, int y, int expectedResult) {
        this.x = x;
        this.y = y;
        this.expectedResult = expectedResult;
    }

    @Test
    public void sumTest() throws LowerThresholdException, UpperThresholdException{
        int result = new Calculator(x, y).sum();
        assertEquals(expectedResult, result);
    }
}
