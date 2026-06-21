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
public class SomaTest {

	
	@Parameters
	public static Iterable getSomaParameters() {
		Object[][] dadosSoma = new Object[][] {
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
		return Arrays.asList(dadosSoma);
	}
	
	private int param1;
	private int param2;
	private int resultadoEsperado;
	
	public SomaTest(int param1, int param2, int resultadoEsperado) {
		this.param1 = param1;
		this.param2 = param2;
		this.resultadoEsperado = resultadoEsperado;
	}
	
	@Test
	public void somaSuccessTest() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		short valorSoma = new Calculadora().soma(param1, param2);
		assertEquals(resultadoEsperado, valorSoma);
	}
	
}
