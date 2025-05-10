package tst;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste extends TestCase {
	private Modalidade modalidade; 
	
	@Test
	@Category(TstFuncional.class)
	public void testBanco1() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 1", 0.01f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void testBanco2() {
		modalidade = Modalidade.criarSimulacao("PRICE", "Banco 2", 0.02f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void testBanco3() {
		modalidade = Modalidade.criarSimulacao("price", "Banco 1", 0.03f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
}
