package teste;
import static org.junit.Assert.*;

import org.junit.Test;

import app.Calculadora;
import exeptions.LimiteInferiorExtrapoladoException;
import exeptions.LimiteSuperiorExtrapoladoException;

public class TesteSoma {
	private Calculadora calc = new Calculadora();

	@Test
	public void somaDoisInteirosPositivos() throws Exception {	
		assertEquals(5, calc.adicao((short)3, (short)2));
	}

	@Test
	public void somaDoisInteirosNegativos() throws Exception {
		assertEquals(-5, calc.adicao((short)-3, (short)-2));
	}

	@Test
	public void somaInteiroPositivoComZero() throws Exception {
		assertEquals(3, calc.adicao((short)3, (short)0));
	}
	
	@Test
	public void somaInteiroNegativoComZero() throws Exception {
		assertEquals(-3, calc.adicao((short)-3, (short)0));
	}

	@Test
	public void somaZeros() throws Exception {
		assertEquals(0, calc.adicao((short)0, (short)0));
	}

	@Test
	public void somaLimiteNegativoComZero() throws Exception {
		assertEquals(-32768, calc.adicao((short)-32768, (short)0));
	}

	@Test
	public void somaLimiteNegativoComUm() throws Exception {
		assertEquals(-32767, calc.adicao((short)-32768, (short)1));
	}

	@Test(expected = LimiteInferiorExtrapoladoException.class)
	public void somaLimiteNegativoComUmNegativo() throws Exception {
		calc.adicao((short)-32768, (short)-1);
	}

	@Test(expected = LimiteInferiorExtrapoladoException.class)
	public void somaLimiteNegativoComDoisNegativo() throws Exception {
		calc.adicao((short)-32768, (short)-2);
	}
	
	@Test
	public void somaLimitePositivoComUmNegativo()  throws Exception {
		assertEquals(32766, calc.adicao((short)32767, (short)-1));
	}

	@Test
	public void somaLimitePositivoComZero() throws Exception{
		assertEquals(32767, calc.adicao((short)32767, (short)0));
	}

	@Test(expected = LimiteSuperiorExtrapoladoException.class)
	public void somaLimitePositivoComUmPositivo() throws Exception {
		calc.adicao((short)32767, (short)1);
	}

	@Test(expected = LimiteSuperiorExtrapoladoException.class)
	public void somaLimitePositivoComDoisPositivo() throws Exception {
		calc.adicao((short)32767, (short)2);
	}
}
