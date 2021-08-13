import app.Calculator;
import app.LimiteInferiorExtrapoladoException;
import app.LimiteSuperiorExtrapoladoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SumTest {
    private short v1;
    private short v2;
    private short result;

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

    public SumTest(int v1, int v2, int result) {
        this.v1 = (short) v1;
        this.v2 = (short) v2;
        this.result = (short) result;
    }

    @Test()
    public void test() throws ArithmeticException {
        try {
            int result = new Calculator(this.v1, this.v2).sum();

            assertEquals(this.result, result);
        } catch (LimiteInferiorExtrapoladoException exception) {
            if (result < Calculator.SHORT_MIN) assert(true);
            else fail();
        } catch (LimiteSuperiorExtrapoladoException exception) {
            if (result > Calculator.SHORT_MAX) assert(true);
            else fail();
        }
    }
}
