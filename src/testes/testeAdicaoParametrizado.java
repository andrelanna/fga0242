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
public class testeAdicaoParametrizado {

	@Parameters
	public static Iterable getParameters() {
		Object[][] dados  = new Object[][] {
			{3, 2, 5},
            {-3, -2, -5},
            {3, 0, 3},
            {-3, 0, -3},
            {0, 0, 0},
            {-32768, 0, -32768},
            {-32768, 1, -32767},
            {32767, -1, 32766},
            {32767, 0, 32767}
		};
		
		return Arrays.asList(dados);
	}
	
	private int op1;
	private int op2;
	private int resultado;
	
	public testeAdicaoParametrizado (int op1, int op2, int resultado) {
		this.op1 = op1;
		this.op2 = op2;
		this.resultado = resultado;
	}
	
	@Test
	public void test() {
		Calculadora calc = new Calculadora((short) op1,(short) op2);
		int soma = calc.soma();
		
		assertEquals(resultado, soma);
	}

}
