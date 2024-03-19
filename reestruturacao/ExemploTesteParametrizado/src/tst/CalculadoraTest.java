package tst;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculadora;

@RunWith(Parameterized.class)
public class CalculadoraTest {

	/**
	 * Definicao de atributos do teste
	 */
	Calculadora c;
	int op1, 
	    op2, 
	    resSoma, 
	    resSub, 
	    resMult; 
	float resDiv;
	
	public CalculadoraTest(int op1, 
						   int op2, 
						   int resSoma, 
						   int resSub, 
						   int resMult, 
						   float resDiv) {
		this.op1 = op1; 
		this.op2 = op2; 
		this.resSoma = resSoma; 
		this.resSub = resSub; 
		this.resMult = resMult; 
		this.resDiv = resDiv;
	}
	
	
	
	/**
	 * Método que retorna o conjunto de parametros
	 */
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{3, 3, 6, 0, 9, 1f},
			{3, -3, 0, 6, -9, -1f},
			{3, -4, -1, 7, -12, -0.75f}, 
			{3, -2, 1, 5, -6, -1.5f}, 
			{-3, -3, -6, 0, 9, 1f}, 
			{0, 3, 3, -3, 0, 0f}
		};
		
		return Arrays.asList(parametros);
	}
	
	
	@Before
	public void setup() {
		c = new Calculadora(op1, op2);
	}
	
	@Test
	public void testSoma() {
		assertEquals(resSoma, c.soma());
	}
	
	@Test
	public void testSubtracao() {
		assertEquals(resSub, c.subtracao());
	}
	
	@Test
	public void testMultiplicacao() {
		assertEquals(resMult, c.multiplicacao());
	}
	
	@Test
	public void testDivisao() {
		assertEquals(resDiv, c.divisao(), 0.1f);
	}

}
