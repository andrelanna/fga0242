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
public class testeAdicaoParametrizadoOverflow {

	@Parameters
	public static Iterable getParameters() {
		Object[][] fatores  = new Object[][] {
			{-32768, -1, -32769},
            {-32768, -2, 32770},
            {32767, 1, 32768},
            {32767, 2, 32769},
		};
		return Arrays.asList(fatores);
	}

	private int n1, n2, resultado;

	public testeAdicaoParametrizadoOverflow (int n1, int n2, int resultado) {
		this.n1 = n1;
		this.n2 = n2;
		this.resultado = resultado;
	}

	@Test(expected=ArithmeticException.class)
	public void testeOverflow()throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException
	{
		Calculadora calculadora = new Calculadora((short) n1,(short) n2);
		int soma = calculadora.adicao();

		assertEquals(resultado, soma);
	}

}