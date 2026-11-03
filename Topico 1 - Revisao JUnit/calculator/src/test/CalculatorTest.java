package test;
import app.CalculatorMain;
import app.exception.LimiteInferiorExtrapoladoException;
import app.exception.LimiteSuperiorExtrapoladoException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    CalculatorMain calc = new CalculatorMain();

    @Test
    public void testSumTwoIntegers() throws Exception{
        Assert.assertEquals(5,calc.sum((short)3,(short)2));
        Assert.assertEquals(-5,calc.sum((short)-3,(short)-2));
        Assert.assertEquals(3,calc.sum((short)3,(short)0));
        Assert.assertEquals(-3,calc.sum((short)-3,(short)0));
        Assert.assertEquals(0,calc.sum((short)0,(short)0));
        Assert.assertEquals(-32768,calc.sum((short)-32768,(short)0));
        Assert.assertEquals(-32767,calc.sum((short)-32768,(short)1));
        Assert.assertEquals(32766,calc.sum((short)32767,(short)-1));
        Assert.assertEquals(32767,calc.sum((short)32767,(short)0));
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void testSumExceptionLowerLimit () throws Exception{
       calc.sum((short)-32768,(short)-1);
        calc.sum((short)-32768,(short)-2);
    }

    @Test(expected = LimiteSuperiorExtrapoladoException.class)
    public void testSumExceptionUpperLimit () throws Exception{
        calc.sum((short)32767,(short)1);
        calc.sum((short)32767,(short)2);
    }

    @Test
    public void testSubtractionTwoIntegers() throws Exception{
        Assert.assertEquals(-32768,calc.subtraction((short) -1	,(short)-32767));
        Assert.assertEquals(-1,calc.subtraction((short) -32768	,(short)32767));
        Assert.assertEquals(-32768,calc.subtraction((short) 	-2	,(short)-32766));
        Assert.assertEquals(-2,calc.subtraction((short) -32768	,(short)32766));
        Assert.assertEquals(32767,calc.subtraction((short) 	-1	,(short)32766));
        Assert.assertEquals(-1,calc.subtraction((short) 32767	,(short)32768));
        Assert.assertEquals(32767,calc.subtraction((short)  	0	,(short)32767));
        Assert.assertEquals(0,calc.subtraction((short) 32767	,(short)-32767));
        Assert.assertEquals(32767,calc.subtraction((short) 	1	,(short)32766));
        Assert.assertEquals(1,calc.subtraction((short) 	32767	,(short)-32768));
        Assert.assertEquals(32767,calc.subtraction((short) 	2	,(short)32765));
        Assert.assertEquals(2,calc.subtraction((short)32767	,(short)-32765));
    }

    @Test(expected = LimiteInferiorExtrapoladoException.class)
    public void testSubtractionExceptionLowerLimit () throws Exception{
        calc.subtraction((short)-32768,(short)1);
    }

    @Test(expected = LimiteSuperiorExtrapoladoException.class)
    public void testSubtractionExceptionUpperLimit () throws Exception{
        calc.subtraction((short)1,(short)-32768);
    }

}
