
package tst;

import org.junit.experimental.categories.Category;
import org.junit.Test;
import static org.junit.Assert.*;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste {
	
	private Modalidade modalidade; 

	@Test
	@Category(TstFuncional.class)
	public void testeBanco1() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 1", 0.05f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void testeBanco2() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 2", 0.15f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void testeBanco3() {
		modalidade = Modalidade.criarSimulacao("Price", "bank three", 0.0023f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
}