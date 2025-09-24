package tst;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.CaractereInvalidoException;

/**
 * Caso de teste simples, simulando a execução de um jogo de forca.
 */
public class TstResolucaoForca extends TstBaseForca{

	
	/**
	 * Teste de uma execução do jogo de forca. 
	 * @throws CaractereInvalidoException
	 */
	@Test
	public void test() throws CaractereInvalidoException {
		assertEquals(0, f.adivinhar('b'));
		assertArrayEquals("*****".toCharArray(), f.getPalavraRevelada());
		assertEquals(2, f.adivinhar('r'));
		assertArrayEquals("*r*r*".toCharArray(), f.getPalavraRevelada());
		assertEquals(0, f.adivinhar('d'));
		assertArrayEquals("*r*r*".toCharArray(), f.getPalavraRevelada());
		assertEquals(3, f.adivinhar('a'));
		assertArrayEquals("arara".toCharArray(), f.getPalavraRevelada());
	}

}
