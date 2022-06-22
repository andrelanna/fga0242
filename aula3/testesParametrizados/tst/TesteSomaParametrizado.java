package testesParametrizados.tst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import testesParametrizados.app.Calculadora;

@RunWith(Parameterized.class)
public class TesteSomaParametrizado {

	/**
	 * Atributos do objeto de teste!  
	 */
	private int op1, 
	            op2, 
	            resposta;
	private Calculadora c;
	private int respostaSubtracao;
	
	/**
	 * Metodo setup, que inicializa o objeto de teste
	 */
	@Before
	public void setup() {
		c = new Calculadora(op1, op2);
	}
	
	/**
	 * Construtor alternativo do objeto de teste, capaz de 
	 * atribuir os parametros do teste aos atributos do 
	 * objeto de teste
	 */
	public TesteSomaParametrizado(int op1, int op2, int resposta, int respostaSubtracao) {
		this.op1 = op1; 
		this.op2 = op2;
		this.resposta = resposta;
		this.respostaSubtracao = respostaSubtracao;
	}
	
	/**
	 * Método que retorna o conjunto de parâmetros do
	 * teste parametrizado. A matriz de parâmetros é composta
	 * por tuplas, em que cada linha, é uma tupla de teste.
	 * 
	 * @return
	 */
	@Parameters
	public static Iterable getParameters() {
		//Matriz de parametros, cada linha é uma tupla de parametros
		Object[][] parametros = new Object[][] {
			{3, 2, 5, 1},
			{-3, 2, -1, -5}, 
			{3, -2, 1, 5}, 
			{5, -5, 0, 10}, 
			{5, 0, 5, 5}, 
			{-5, 0, -5, -5}, 
			{-1, -3, -4, 2}
		};
		return Arrays.asList(parametros);
	}
	
	/**
	 * Teste definido em termos dos atributos do objeto de teste
	 */
	@Test
	public void testSomaInteiros() {
		assertEquals(resposta, c.soma());
		System.out.println("Objeto teste: " + this);
	}
	
	@Test
	public void testSubtracaoInteiros() {
		assertEquals(respostaSubtracao, c.subtracao());
		System.out.println("Objeto teste: " + this);
	}
}












