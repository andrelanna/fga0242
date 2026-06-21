package tst;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste {
	
	private Modalidade modalidade;

	@Test
	@Category(TstFuncional.class)
	public void testBanco1() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 1", 1.0f);
		assertNotEquals(null, modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void testBanco2() {
		modalidade = Modalidade.criarSimulacao("Not Price", "Banco 2", 1.0f);
		assertEquals(null, modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void testBanco3() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 3", 1.0f);
		assertNotEquals(null, modalidade);
	}
}
