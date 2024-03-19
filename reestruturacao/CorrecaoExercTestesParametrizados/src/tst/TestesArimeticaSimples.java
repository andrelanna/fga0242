package tst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculadora;

@RunWith(Parameterized.class)
public class TestesArimeticaSimples {

	/*
	 * Atributos do caso de teste
	 */
	private int op1, op2, 
	            resSoma, resSubt, resMult;
	Calculadora c; 
	
	@Before
	public void setup() {
		c = new Calculadora(op1, op2);
	}
	
	/*
	 * Construtor alternativo do objeto de testes
	 */
	public TestesArimeticaSimples(int[] p) {
		this.op1 = p[0]; 
		this.op2 = p[1];
		this.resSoma = p[2];
		this.resSubt = p[3];
		this.resMult = p[4];
	}
	
	@Parameters
	public static Collection<int[]> getParameters() {
		int[][] parametros = new int[][] {
			{3, 2, 5, 1, 6}, 
			{2, 3, 5, -1, 6}, 
			{-3, 2, -1, -5, -6},
			{-2, -3, -5, 1, 6}, 
			{0, 2, 2, -2, 0}, 
			{0, -2, -2, 2, 0}, 
			{2, 0, 2, 2, 0}, 
			{-2, 0, -2, -2, 0}, 
			{-3, -2, -5, -1, 6}
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testSoma() {
		assertEquals(resSoma, c.soma());
	}
	
	@Test
	public void testSubtracao() {
		assertEquals(resSubt, c.diferenca());
	}

	@Test
	public void testMultiplicacao() {
		assertEquals(resMult, c.mult());
	}
}
