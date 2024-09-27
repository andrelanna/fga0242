package testes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculadora;
import excecoes.*;

@RunWith(Parameterized.class)
public class testeSubtracaoParametrizadoOverflow {

	@Parameters
	public static Iterable getParameters() {
		Object[][] dados  = new Object[][] {
			{-32768, 1, -32767},
            {1, -32768, 32769}
		};
		
		return Arrays.asList(dados);
	}
	
	private int op1;
	private int op2;
	private int resultado;
	
	public testeSubtracaoParametrizadoOverflow (int op1, int op2, int resultado) {
		this.op1 = op1;
		this.op2 = op2;
		this.resultado = resultado;
	}
	
	
	@Test(expected=ArithmeticException.class)
    public void testeLimiteExtrapolado() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		
		Calculadora calc = new Calculadora((short) op1, (short) op2);
		int diferenca = calc.subtracao();
		
		assertEquals(resultado, diferenca);
    }

}
