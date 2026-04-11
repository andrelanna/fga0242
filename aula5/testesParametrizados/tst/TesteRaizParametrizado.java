package testesParametrizados.tst;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import testesParametrizados.app.Calculadora;

@RunWith(Parameterized.class)
public class TesteRaizParametrizado {

	private int op1;
	private float resposta, 
	              erro;
	private Calculadora c; 
	
	public TesteRaizParametrizado(int op1, float resposta, float erro) {
		this.op1 = op1; 
		this.resposta = resposta; 
		this.erro = erro;
	}
	
	
	@Before
	public void setup() {
		c = new Calculadora(op1);
	}
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] resposta = new Object[][] {
			{5, 2.23f, 0.007f}, 
			{8, 2.82f, 0.009f}
		};
		
		return Arrays.asList(resposta);
	}
	
	@Test
	public void test() {
		assertEquals(resposta, c.raizQuadrada(), erro);
		System.out.println(this);
	}

}
