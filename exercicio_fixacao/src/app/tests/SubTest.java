import app.Calculator;
import app.LimiteInferiorExtrapoladoException;
import app.LimiteSuperiorExtrapoladoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SubTest {
    private short v1;
    private short v2;
    private short result;

    @Parameterized.Parameters
    public static Iterable getParameters() {
        Object[][] data = new Object[][]{
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
                {-1, 32767, 32768},
                {32767, 0, 32767},
                {0, 32767, -32767},
                {32767, 1, 32766},
                {-1, 32767, -32768},
                {32767, 2, 32765},
                {2, 32767, -32765},
        };
        return Arrays.asList(data);
    }

    public SubTest(int v1, int v2, int result) {
        this.v1 = (short) v1;
        this.v2 = (short) v2;
        this.result = (short) result;
    }

    @Test()
    public void test() throws ArithmeticException {
        int result = new Calculator(this.v1, this.v2).sub();

        assertEquals(this.result, result);
    }
}
