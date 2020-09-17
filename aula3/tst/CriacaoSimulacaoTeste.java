package tst;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste {
	
	private Modalidade modalidade; 

	@Test
	@Category(TstFuncional.class)
	public void bank_one() {
		modalidade = Modalidade.criarSimulacao("Price", "bank one", 0.05f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void bank_two() {
		modalidade = Modalidade.criarSimulacao("Price", "bank two", 0.001f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void bank_three() {
		modalidade = Modalidade.criarSimulacao("Price", "bank three", 0.15f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
}