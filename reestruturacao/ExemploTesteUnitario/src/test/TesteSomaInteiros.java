package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculadora;

@RunWith(Parameterized.class)
public class TesteSomaInteiros {
	
	int operando1, operando2, resultadoEsperado;
	private boolean adicionou;
	
	public TesteSomaInteiros(int re, int op1, int op2, boolean ad) {
		operando1 = op1; 
		operando2 = op2; 
		resultadoEsperado = re; 
		adicionou = ad; 
	}
	
	@Test
	public void testSomaInteiros() {
		System.out.println(this);
		assertEquals(resultadoEsperado, new Calculadora().soma(operando1, operando2));
	}
	
	@Test
	public void testSeAdicionou() {
		Calculadora c = new Calculadora();
		c.adicionou(true);
		assertEquals(adicionou, c.getAdicionou());
	}

	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{5, 3, 2, true},
			{6, 4, 2, true},
			{10, 5, 5, true},
			{-5, -3, -2, true},
			{-6, -4, -2, true},
			{-10, -5, -5, true},
			{0, -3, 3, true},
			{0, -4, 4, true},
			{0, -5, 5, true},
			{-3, -3, 0, true},
			{-4, -4, 0, true},
			{0,  0, 0, true}
		};
		return Arrays.asList(parametros);
	}

}


