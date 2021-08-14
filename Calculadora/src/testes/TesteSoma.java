package testes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculadora;

@RunWith(Parameterized.class)
public class TesteSoma {

	private int a;
	private int b;
	private int resultadoEsperado;
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] dados = new Object[][] {
			{3, 2, 5},
			{-3, -2, -5},
			{3, 0, 3},
			{-3, 0, -3},
			{0, 0, 0},
			{-32768, 0, -32768},
			{-32768, 1, -32767},
			{32767, -1, 32766},
			{32767, 0, 32767},
			{32768, -1, -111},
			{32768, -2, -111}
			
		};
		
		return Arrays.asList(dados);
	}
	
	public TesteSoma(int a, int b, int resultadoEsperado) {
		this.a = a;
		this.b = b;
		this.resultadoEsperado = resultadoEsperado;
	}
	
	@Test(expected = ArithmeticException.class)
	public void test() throws ArithmeticException {
		Calculadora calc = new Calculadora((short) this.a, (short) this.b);
		assertEquals(this.resultadoEsperado, calc.soma());
	}

}




