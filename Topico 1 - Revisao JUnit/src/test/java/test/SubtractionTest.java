package test;

import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.*;

@RunWith(Parameterized.class)
public class SubtractionTest {

    @Parameters
    public static Iterable getParameters() {
        Object[][] subtractionData = new Object[][]{
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
                {32767, 1, 32766},
                {-1, 32767, -32768},
                {32767, 0, 32767},
                {0, 32767, -32767},
                {32767, 1, 32766},
                {1, 32767, -32766},
                {32767, 2, 32765},
                {2, 32767, -32765},
        };
        return Arrays.asList(subtractionData);
    }

    private int x;
    private int y;
    private int expectedResult;

    public SubtractionTest(int x, int y, int expectedResult) {
        this.x = x;
        this.y = y;
        this.expectedResult = expectedResult;
    }

    @Test
    public void subtractionTest() throws LowerThresholdException, UpperThresholdException {
        int result = new Calculator(x, y).subtraction();
        assertEquals(expectedResult, result);
    }
}
