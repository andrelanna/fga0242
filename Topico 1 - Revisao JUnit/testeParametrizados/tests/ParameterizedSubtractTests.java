import Expections.LimiteInferiorExtrapoladoException;
import Expections.LimiteSuperiorExtrapoladoException;
import main.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParameterizedSubtractTests {
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

    private int a;
    private int b;
    private int expectedResult;

    public ParameterizedSubtractTests(int a, int b, int expectedResult){
        this.a = a;
        this.b = b;
        this.expectedResult = expectedResult;
    }

    @Test
    public void successTests() {
        assertEquals(expectedResult, Calculator.subtract(a, b));
    }

    @Test(expected = ArithmeticException.class)
    public void higherLimitFailureTests() throws LimiteSuperiorExtrapoladoException {
        assertEquals(expectedResult, Calculator.subtract(1, -32768));
    }

    @Test(expected = ArithmeticException.class)
    public void lowerLimitFailureTests() throws LimiteInferiorExtrapoladoException {
        assertEquals(expectedResult, Calculator.subtract(-32768, 1));
    }
}
