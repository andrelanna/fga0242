package tst;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Forca;
import exceptions.CaractereInvalidoException;

/**
 * Classe que implementa o caso de teste de exceção da Forca, 
 * para caractere Invalido. 
 */
public class TstCaractereNuloOuInvalido extends TstBaseForca{

	/**
	 *O codigo comentado abaixo é desnecessario, já que essa classe
	 *herda da classe base de teste (TstBaseForca) 
	 */
//	private Forca f;

//	@Before
//	public void setup() {
//		f = new Forca("arara");
//	}
	
	/**
	 * Caso de teste de excecao para caractere invalido. 
	 */
	@Test(expected=CaractereInvalidoException.class)
	@Category({Excecao.class, Funcional.class})
	public void testCaractereInvalido() throws CaractereInvalidoException {
		f.adivinhar('\0');
	}
	

}
