import app.Calculator;
import app.LimiteInferiorExtrapoladoException;
import org.junit.Test;

public class UnderflowTest {
    private Calculator calc;

    @Test(expected = ArithmeticException.class)
    public void test1() throws ArithmeticException {
        calc = new Calculator((short) -32768, (short) -1);
        calc.sum();
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void test2() throws LimiteInferiorExtrapoladoException {
        calc = new Calculator((short) -32768, (short) -2);
        calc.sum();
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void test3() throws LimiteInferiorExtrapoladoException {
        calc = new Calculator((short) -32768, (short) 1);
        calc.sub();
    }
}
