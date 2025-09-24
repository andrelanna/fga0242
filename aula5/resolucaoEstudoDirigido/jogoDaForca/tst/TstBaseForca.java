package tst;

import org.junit.Before;

import app.Forca;

/**
 * Classe base de todos os testes da Forca. 
 * Nessa classe foram definidos a referência para o objeto a ser testado, 
 * e a instanciação, via metodo setup, do objeto a ser testado.
 */

public class TstBaseForca {

	/**
	 * Referencia para o objeto a ser testado
	 */
	Forca f; 
	
	/**
	 * Metodo de instanciacao do objeto a ser testado, para todos os testes
	 * que extenderem dessa classe-base.
	 */
	@Before
	public void setup() {
		f = new Forca("arara");
	}

}
