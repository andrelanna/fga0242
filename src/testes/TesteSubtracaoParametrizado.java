import calculadora.Calculadora;
package testes;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.LimiteInferiorExtrapoladoException;
import exceptions.LimiteSuperiorExtrapoladoException;

@RunWith(Parameterized.class)
public class TesteSubtracaoParametrizado {

	@Parameters
	public static Iterable getParameters() {
		Object[][] fatores  = new Object[][] {
			{3, 2, 1},
            {2, 3, -1},
            {-3, -2, -1},
            {-2, -3, 1},
            {3, 0, 3},
            {0, 3, -3},
            {-3, 0, -3},
            {0, 3, -3},
            {0, 0, 0},
            {-32768, 0, -32768},
            {-32768, -1, -32767},
            {-1, -32768, 32767},
            {-32768, -2, -32766},
            {-2, -32768, 32766},
            {-32767, -1, -32766},
            {-1, 32767, -32768},
            {32767, 0, 32767},
            {0, 32767, -32767},
            {32767, 1, 32766},
            {1, 32767, -32766},
            {32767, 2, 32765},
            {2, 32767, -32765}
		};
		return Arrays.asList(fatores);
	}

	private int n1, n2, resultado;

	public TesteSubtracaoParametrizado (int n1, int n2, int resultado) {
		this.n1 = n1;
		this.n2 = n2;
		this.resultado = resultado;
	}

	@Test
	public void teste() {
		Calculadora calculadora = new Calculadora((short) n1,(short) n2);
		int sub = calculadora.subtracao();

		assertEquals(resultado, sub);
	}

}