package Test;

import Domain.Calculadora;
import Exceptions.LimiteInferiorExtrapoladoException;
import Exceptions.LimiteSuperiorExtrapoladoException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.Test;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    Calculadora calculadora = new Calculadora();

    private final int limiteInferior = -32768;
    private final int limiteSuperior = 32767;

    @Test
    public void adicao() throws ArithmeticException {
        assertEquals(-32768, calculadora.adicao((short) 0, (short)-32768));
        assertEquals(-32767, calculadora.adicao((short)1,(short)-32768));
        assertEquals(32767, calculadora.adicao((short)-1,(short)32768));
        assertEquals(32767, calculadora.adicao((short)0,(short)32767));
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void adicaoLimiteInferior() throws ArithmeticException {
        calculadora.adicao((short)limiteInferior, (short)-1);
    }

    @Test(expected = LimiteSuperiorExtrapoladoException.class)
    public void adicaoLimiteSuperior() throws ArithmeticException {
        calculadora.adicao((short)limiteSuperior, (short)1);
    }

    @Test
    public void subtracao() {
        assertEquals(-32768, calculadora.subtracao((short)-1,(short)32767));
        assertEquals(32767, calculadora.subtracao((short)-1,(short)-32768));
        assertEquals(32766, calculadora.subtracao((short)-1,(short)-32767));
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void subtracaoLimiteInferior() throws ArithmeticException {
        calculadora.subtracao((short)limiteInferior, (short)1);
    }

    @Test(expected = LimiteSuperiorExtrapoladoException.class)
    public void subtracaoLimiteSuperior() throws ArithmeticException {
        calculadora.subtracao((short)-1, (short)limiteInferior);
    }
}