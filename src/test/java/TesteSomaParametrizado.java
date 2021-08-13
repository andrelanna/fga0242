import com.example.calculadora.Calculadora;

import static org.junit.Assert.*;

import com.example.calculadora.LimiteInferiorExtrapoladoException;
import com.example.calculadora.LimiteSuperiorExtrapoladoException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TesteSomaParametrizado {
    private final short resultadoEsperado;
    private final short value1;
    private final short value2;

    @Parameters
    public static Iterable getParameters() {
        Object[][] dados = new Object[][]{
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

        return Arrays.asList(dados);
    }

    public TesteSomaParametrizado(int value1, int value2, int resultadoEsperado) {
        this.value1 = (short) value1;
        this.value2 = (short) value2;
        this.resultadoEsperado = (short) resultadoEsperado;
    }

    @Test
    public void test() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
        short result = new Calculadora(value1, value2).Soma();
        assertEquals(resultadoEsperado, result);
    }
}
