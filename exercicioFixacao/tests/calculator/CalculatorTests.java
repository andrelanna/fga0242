package calculator;


import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTests{
		
	@Test
	public void testSum1()throws Exception{	
		short result = Calculator.sum((short)3, (short)2);
		assertEquals(result,  5);
	}
	@Test
	public void testSum2()throws Exception{
		short result = Calculator.sum((short)-3, (short)-2);
		assertEquals(result,  -5);
	}
	@Test
	public void testSum3()throws Exception{
		short result = Calculator.sum((short)3, (short)0);
		assertEquals(result,  3);
	}
	@Test
	public void testSum4()throws Exception{
		short result = Calculator.sum((short)-3, (short)0);
		assertEquals(result,  -3);
	}
	@Test
	public void testSum5()throws Exception{
		short result = Calculator.sum((short)0, (short)0);
		assertEquals(result,  0);
	}
	@Test
	public void testSum6()throws Exception{
		short result = Calculator.sum((short)-32768, (short)0);
		assertEquals(result,  -32768);
	}
	@Test
	public void testSum7() throws Exception{
		short result = Calculator.sum((short)-32768, (short)1);
		assertEquals(result,  -32767);
	}
	@Test(expected = LimiteInferiorExtrapoladoException.class)
	public void testSum8() throws Exception{
		Calculator.sum((short)-32768, (short)-1);
	}
	@Test(expected = LimiteInferiorExtrapoladoException.class)
	public void testSum9() throws Exception{
		Calculator.sum((short)-32768, (short)-2);
	}
	@Test
	public void testSum10() throws Exception{
		short result = Calculator.sum((short)32767, (short)-1);
		assertEquals(result,  32766);
	}
	@Test
	public void testSum11() throws Exception{
		short result = Calculator.sum((short)32767, (short)0);
		assertEquals(result,  32767);
	}
	@Test(expected = LimiteSuperiorExtrapoladoException.class)
	public void testSum12() throws Exception{
		Calculator.sum((short)32767, (short)1);
	}
	@Test(expected = LimiteSuperiorExtrapoladoException.class)
	public void testSum13() throws Exception{
		Calculator.sum((short)32767, (short)2);
	}
	
	@Test
	public void testSubtract1() throws Exception{
		short result = Calculator.subtract((short)3, (short)2);
		assertEquals(result,  1);
	}
	@Test
	public void testSubtract2() throws Exception{
		short result = Calculator.subtract((short)2, (short)3);
		assertEquals(result,  -1);
	}
	@Test
	public void testSubtract3() throws Exception{
		short result = Calculator.subtract((short)-3, (short)-2);
		assertEquals(result,  -1);
	}
	@Test
	public void testSubtract4() throws Exception{
		short result = Calculator.subtract((short)-2, (short)-3);
		assertEquals(result,  1);
	}
	@Test
	public void testSubtract5() throws Exception{
		short result = Calculator.subtract((short)3, (short)0);
		assertEquals(result,  3);
	}
	@Test
	public void testSubtract6() throws Exception{
		short result = Calculator.subtract((short)0, (short)3);
		assertEquals(result,  -3);
	}
	@Test
	public void testSubtract7() throws Exception{
		short result = Calculator.subtract((short)-3, (short)0);
		assertEquals(result,  -3);
	}
	@Test
	public void testSubtract8() throws Exception{
		short result = Calculator.subtract((short)0, (short)3);
		assertEquals(result,  -3);
	}
	@Test
	public void testSubtract9() throws Exception{
		short result = Calculator.subtract((short)0, (short)0);
		assertEquals(result,  0);
	}
	@Test(expected = LimiteInferiorExtrapoladoException.class)
	public void testSubtract10() throws Exception{
		Calculator.subtract((short)-32768, (short)1);
	}
	@Test(expected = LimiteSuperiorExtrapoladoException.class)
	public void testSubtract11() throws Exception{
		Calculator.subtract((short)1, (short)-32768);
	}
	@Test
	public void testSubtract12() throws Exception{
		short result = Calculator.subtract((short)-32768, (short)-1);
		assertEquals(result,  -32767);
	}
	@Test
	public void testSubtract13() throws Exception{
		short result = Calculator.subtract((short)-1, (short)-32768);
		assertEquals(result,  32767);
	}
	@Test
	public void testSubtract14() throws Exception{
		short result = Calculator.subtract((short)-32768, (short)-2);
		assertEquals(result,  -32766);
	}
	@Test
	public void testSubtract15() throws Exception{
		short result = Calculator.subtract((short)-2, (short)-32768);
		assertEquals(result,  32766);
	}
	/* This test will fail, the real result is 32768 (Exception) */
	@Test
	public void testSubtract16() throws Exception{
		short result = Calculator.subtract((short)32767, (short)-1);
		assertEquals(result,  32766);
	}
	/* This test will fail, the real result is -32768 */
	@Test
	public void testSubtract17() throws Exception{
		short result = Calculator.subtract((short)-1, (short)32767);
		assertEquals(result,  32768);
	}
	@Test
	public void testSubtract18() throws Exception{
		short result = Calculator.subtract((short)-32768, (short)-1);
		assertEquals(result,  -32767);
	}
	@Test
	public void testSubtract19() throws Exception{
		short result = Calculator.subtract((short)32767, (short)0);
		assertEquals(result,  32767);
	}
	@Test
	public void testSubtract21() throws Exception{
		short result = Calculator.subtract((short)32767, (short)1);
		assertEquals(result,  32766);
	}
	/* This test will fail, the real result is -32766 */
	@Test
	public void testSubtract22() throws Exception{
		short result = Calculator.subtract((short)1, (short)32767);
		assertEquals(result,  -32768);
	}
	@Test
	public void testSubtract23() throws Exception{
		short result = Calculator.subtract((short)32767, (short)2);
		assertEquals(result,  32765);
	}
	@Test
	public void testSubtract24() throws Exception{
		short result = Calculator.subtract((short)2, (short)32767);
		assertEquals(result,  -32765);
	}
}