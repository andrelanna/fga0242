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
public class testeAdicaoParametrizado {

	@Parameters
	public static Iterable getParameters() {
		Object[][] fatores  = new Object[][] {{3, 2, 5},
            {-3, -2, -5},
            {3, 0, 3},
            {-3, 0, -3},
            {0, 0, 0},
            {-32768, 0, -32768},
            {-32768, 1, -32767},
            {32767, -1, 32766},
            {32767, 0, 32767}
		};
		return Arrays.asList(fatores);
	}

	private int n1, n2, resultado;

	public testeAdicaoParametrizado (int n1, int n2, int resultado) {
		this.n1 = n1;
		this.n2 = n2;
		this.resultado = resultado;
	}

	@Test
	public void teste() {
		Calculadora calculadora = new Calculadora((short) n1,(short) n2);
		int soma = calculadora.adicao();

		assertEquals(resultado, soma);
	}

}