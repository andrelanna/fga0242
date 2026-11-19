package calculadora;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exception.LimiteInferiorExtrapoladoException;
import exception.LimiteSuperiorExtrapoladoException;

@RunWith(Parameterized.class)
public class SubtracaoTest {

	
	@Parameters
	public static Iterable getSubParameters() {
		Object[][] dadosSub = new Object[][] {
			{3,	2, 1},
			{2,	3, -1},
			{-3, -2, -1},
			{-2, -3, 1},
			{3, 0, 3},
			{0,	3, -3},
			{-3, 0, -3},
			{0,	3, -3},
			{0,	0, 0},
			{-32768, 0, -32768},
			{-32768, -1, -32767},
			{-1, -32768, 32767},
			{-32768, -2, -32766},
			{-2, -32768, 32766},
			{32767,	1, 32766},
			{-1, 32767,	-32768},
			{32767,	0, 32767},
			{0,	32767, -32767},
			{32767,	1, 32766},
			{1,	32767, -32766},
			{32767,	2, 32765},
			{2,	32767, -32765},
		};
		return Arrays.asList(dadosSub);
	}
	
	private int param1;
	private int param2;
	private int resultadoEsperado;
	
	public SubtracaoTest(int param1, int param2, int resultadoEsperado) {
		this.param1 = param1;
		this.param2 = param2;
		this.resultadoEsperado = resultadoEsperado;
	}
	
	@Test
	public void subSuccessTest() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		short valorSub = new Calculadora().subtracao(param1, param2);
		assertEquals(resultadoEsperado, valorSub);
	}
	
}
