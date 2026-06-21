import app.Calculator;
import app.LimiteSuperiorExtrapoladoException;
import org.junit.Test;

public class OverflowTest {
    private Calculator calc;

    @Test(expected = ArithmeticException.class)
    public void test1() throws ArithmeticException {
        calc = new Calculator((short) 32767, (short) 1);
        calc.sum();
    }

    @Test(expected = LimiteSuperiorExtrapoladoException.class)
    public void test2() throws LimiteSuperiorExtrapoladoException {
        calc = new Calculator((short) 32767, (short) 2);
        calc.sum();
    }

    @Test(expected = LimiteSuperiorExtrapoladoException.class)
    public void test3() throws LimiteSuperiorExtrapoladoException {
        calc = new Calculator((short) 1, (short) -32767);
        calc.sub();
    }
}
