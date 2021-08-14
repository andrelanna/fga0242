package tests;

import exceptions.LimiteInferiorExtrapoladoException;
import exceptions.LimiteSuperiorExtrapoladoException;
import models.Calculadora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTeste
{
    Calculadora calc = new Calculadora();

    @Test
    public void testSumWithSmallNumbers() throws Exception
    {
        assertEquals(calc.sum(3, 2), 5);
        assertEquals(calc.sum(-3, -2), -5);
        assertEquals(calc.sum(3, 0), 3);
        assertEquals(calc.sum(-3, 0), -3);
        assertEquals(calc.sum(0, 0), 0);
    }

    @Test
    public void testSumWithBigNumbers() throws Exception
    {
        assertEquals(calc.sum(-32768, 0), -32768);
        assertEquals(calc.sum(-32768, 1), -32767);
        assertEquals(calc.sum(32767, -1), 32766);
        assertEquals(calc.sum(32767, 0), 32767);
    }

    @Test
    public void testSumWithInferiorException()
    {
        try {
            calc.sum(-32768, -1);
        } catch (Exception e) {
            assert(e.getClass() == LimiteInferiorExtrapoladoException.class);
        }
    }

    @Test
    public void testSumWithSuperiorException()
    {
        try {
            calc.sum(32767, 1);
        } catch (Exception e) {
            assert(e.getClass() == LimiteSuperiorExtrapoladoException.class);
        }
    }

    @Test
    public void testSubWithSmallNumbers() throws Exception
    {
        assertEquals(calc.sub(3, 2), 1);
        assertEquals(calc.sub(-3, -2), -1);
        assertEquals(calc.sub(3, 0), 3);
        assertEquals(calc.sub(0, 3), -3);
        assertEquals(calc.sub(0, 0), 0);
    }

    @Test
    public void testSubWithBigNumbers() throws Exception
    {
        assertEquals(calc.sub(-32768, -1), -32767);
        assertEquals(calc.sub(-2, -32768), 32766);
        assertEquals(calc.sub(32767, 1), 32766);
        assertEquals(calc.sub(32767, 0), 32767);
    }

    @Test
    public void testSubWithInferiorException()
    {
        try {
            calc.sub(-32768, 1);
        } catch (Exception e) {
            assert(e.getClass() == LimiteInferiorExtrapoladoException.class);
        }
    }

    @Test
    public void testSubWithSuperiorException()
    {
        try {
            calc.sub(1, -32768);
        } catch (Exception e) {
            assert(e.getClass() == LimiteSuperiorExtrapoladoException.class);
        }
    }
}
