package tst;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Forca;
import exceptions.CaractereInvalidoException;

/**
 * Classe que implementa o caso de teste parametrizado, funcional, 
 * que para cada tentativa de descoberta de caractere, informa quantos
 * caracteres foram revelados e exclui a máscara desses caracteres. 
 */
@RunWith(Parameterized.class)
public class TstForca extends TstBaseForca {

	/**
	 * A referencia f para Forca e o método setup() foram removidos 
	 * pela heranca da classe TstBaseForca.
	 */
	
	/** 
	 * Atributos do teste
	 */
//	Forca f; 
	char charRevelar;
	int charRevelados;
	String stringRevelada;
	
	
	/**
	 * Construtor do objeto de teste
	 * @param charRevelar - caractere a ser revelado
	 * @param charRevelados - numero de caracteres revelados esperado
	 * @param stringRevelada - string resultante apos revelacao de caracteres
	 */
	public TstForca(char charRevelar, int charRevelados, String stringRevelada) {
		this.charRevelar = charRevelar;
		this.charRevelados = charRevelados;
		this.stringRevelada = stringRevelada;
	}
	
	/**
	 * Método que retorna o conjunto de parâmetros dos testes unitários
	 * @return
	 */
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{'a', 3, "a*a*a"},
			{'r', 2, "*r*r*"},
			{'b', 0, "*****"}
		};
		
		return Arrays.asList(parametros);
	}
	
//	@Before
//	public void setup() {
//		f = new Forca("arara");
//	}
	
	/**
	 * Método de teste, parametrizado, e categorizado como Funcional.
	 * @throws CaractereInvalidoException
	 */
	@Test
	@Category(Funcional.class)
	public void testLetraA() throws CaractereInvalidoException {
		int numRevelados= f.adivinhar(charRevelar);
		assertEquals(charRevelados, numRevelados);
		assertArrayEquals(stringRevelada.toCharArray(), f.getPalavraRevelada());
	}
	
//	@Test
//	public void testLetraR() {
//		int caracteresRevelados= f.adivinhar('r');
//		assertEquals(2, caracteresRevelados);
//		assertArrayEquals("*r*r*".toCharArray(), f.getPalavraRevelada());
//	}
//	
//	@Test
//	public void testLetraB() {
//		int caracteresRevelados= f.adivinhar('b');
//		assertEquals(0, caracteresRevelados);
//		assertArrayEquals("*****".toCharArray(), f.getPalavraRevelada());
//	}

}

