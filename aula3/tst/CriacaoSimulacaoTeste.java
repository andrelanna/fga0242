package tst;

import org.junit.experimental.categories.Category;
import org.junit.Test;
import static org.junit.Assert.*;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste {
	
	private Modalidade modalidade; 

	@Test
	@Category(TstFuncional.class)
	public void testBankOne() {
		modalidade = Modalidade.criarSimulacao("Price", "bank one", 0.05f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void testBankTwo() {
		modalidade = Modalidade.criarSimulacao("Price", "bank two", 0.001f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void testBankThree() {
		modalidade = Modalidade.criarSimulacao("Price", "bank three", 0.15f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
}