package teste;
import static org.junit.Assert.*;

import org.junit.Test;

import app.Calculadora;
import exeptions.LimiteInferiorExtrapoladoException;
import exeptions.LimiteSuperiorExtrapoladoException;

public class TesteSubtracao {
	private Calculadora calc = new Calculadora();
	
	@Test
	public void subtracaoDoisInteirosPositivos() throws Exception{
		assertEquals(1, calc.subtracao((short)3, (short)2));
	}

	@Test
	public void subtracaoDoisInteirosPositivosI() throws Exception{
		assertEquals(-1, calc.subtracao((short)2, (short)3));
	}

	@Test
	public void subtracaoDoisInteirosNegativos() throws Exception{
		assertEquals(-1, calc.subtracao((short)-3, (short)-2));
	}

	@Test
	public void subtracaoDoisInteirosNegativosI() throws Exception{
		assertEquals(1, calc.subtracao((short)-2, (short)-3));
	}

	@Test
	public void subtracaoInteiroPositivoComZero() throws Exception{
		assertEquals(3, calc.subtracao((short)3, (short)0));
	}

	@Test
	public void subtracaoInteiroPositivoComZeroI() throws Exception{
		assertEquals(-3, calc.subtracao((short)0, (short)3));
	}

	@Test
	public void subtracaoInteiroNegativoComZero() throws Exception{
		assertEquals(-3, calc.subtracao((short)-3, (short)0));
	}

	@Test
	public void subtracaoInteiroNegativoComZeroI() throws Exception{
		assertEquals(-3, calc.subtracao((short)0, (short)3));
	}

	@Test
	public void subtracaoDoisZeros() throws Exception{
		assertEquals(0, calc.subtracao((short)0, (short)0));
	}

	@Test
	public void subtracaoLimiteInferiorComZero() throws Exception{
		assertEquals(-32768, calc.subtracao((short)-32768, (short)0));
		
	}

	@Test(expected = LimiteInferiorExtrapoladoException.class)
	public void subtracaoLimiteInferiorComNumeroPositivoI() throws Exception{
		calc.subtracao((short)-32768, (short)1);
	}

	@Test(expected = LimiteSuperiorExtrapoladoException.class)
	public void subtracaoLimiteInferiorComNumeroPositivo() throws Exception{
		calc.subtracao((short)1, (short)-32768);
	}

	@Test
	public void subtracaoLimiteInferiorComNumeroNegativoA() throws Exception{
		assertEquals(-32767, calc.subtracao((short)-32768, (short)-1));
	}

	@Test
	public void subtracaoLimiteInferiorComNumeroNegativoI() throws Exception{
		assertEquals(32767, calc.subtracao((short)-1, (short)-32768));
	}

	@Test
	public void subtracaoLimiteInferiorComNumeroNegativoIA() throws Exception{
		assertEquals(-32766, calc.subtracao((short)-32768, (short)-2));
	}
	 
	@Test
	public void subtracaoLimiteInferiorComNumeroNegativo() throws Exception{
		assertEquals(32766, calc.subtracao((short)-2, (short)-32768));
	}

	@Test(expected = LimiteSuperiorExtrapoladoException.class)
	public void subtracaoLimiteSuperiorComNumeroNegativoA() throws Exception{
		calc.subtracao((short)32767, (short)-1);
		System.out.println(calc.subtracao((short)32767, (short)-1));
	}

	@Test
	public void subtracaoLimiteSuperiorComNumeroNegativoI() throws Exception{
		assertEquals(-32768, calc.subtracao((short)-1, (short)32767));
	}

	@Test
	public void subtracaoLimiteSuperiorComZero() throws Exception{
		assertEquals(32767, calc.subtracao((short)32767, (short)0));
	}

	@Test
	public void subtracaoLimiteSuperiorComPositivo() throws Exception{
		assertEquals(32766, calc.subtracao((short)32767, (short)1));
	}

	@Test
	public void subtracaoLimiteSuperiorComPositivoI() throws Exception{
		assertEquals(-32766, calc.subtracao((short)1, (short)32767));
	}

	@Test
	public void subtracaoLimiteSuperiorComPositivoA() throws Exception{
		assertEquals(32765, calc.subtracao((short)32767, (short)2));
	}

	@Test
	public void subtracaoLimiteSuperiorComPositivoIA() throws Exception{
		assertEquals(-32765, calc.subtracao((short)2, (short)32767));
	}
}
