
package fga0242;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TesteSubtracaoParametrizado {

	//Atributos do objeto de teste: cada teste terá seu valor associado
	private int op1;
	private int op2;
	private int rstEspSub;
	private int rstEspSoma; 

	private Calculadora c;
	
	@Before
	public void setup() {
		c = new Calculadora();
	}
	
	//1a. coisa a ser feita: metodo que retorna conjunto de parametros
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{3, 2, 1, 5},
			{2, 3, -1, 5}, 
			{3, -2, 5, 1}, 
			{2, -3, 5, -1}, 
			{-3, -2, -1, -5},
			{-2, -3, 1, -5}, 
			{0, 3, -3, 3}
		};
		return Arrays.asList(parametros);
	}

	//2o passo: criar o construtor alternativo do objeto de teste
	public TesteSubtracaoParametrizado(int op1, int op2, int rstEspSub, int rstEspSoma) {
		this.op1 = op1; 
		this.op2 = op2;
		this.rstEspSub = rstEspSub;
		this.rstEspSoma = rstEspSoma;
	}
	
	
	//3o passo: escrever o teste!
	@Test
	public void testSubtracao() {
		assertEquals(rstEspSub, c.subtracao(op1, op2));
	}
	
	
	@Test
	public void testSoma() {
		assertEquals(rstEspSoma, c.soma(op1, op2));
	}

	
	
	
	
	
	
	
	
}
