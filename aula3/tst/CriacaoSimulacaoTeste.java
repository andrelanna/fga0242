package tst;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Modalidade;
import financeiroExceptions.TaxaDeJurosInvalidaException;

public class CriacaoSimulacaoTeste {

	private Modalidade modalidade; 

	@Test
	@Category(TstFuncional.class)
	public void testBanco1Valido() throws TaxaDeJurosInvalidaException {
		modalidade = Modalidade.criarSimulacao("price", "Banco 1", 0.08f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void testBanco2Valido() throws TaxaDeJurosInvalidaException {
		modalidade = Modalidade.criarSimulacao("PRICE", "Banco 2", 0.01f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void testBanco3Valido() throws TaxaDeJurosInvalidaException {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 3", 0.06f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void testBanco1Invalido() throws TaxaDeJurosInvalidaException {
		modalidade = Modalidade.criarSimulacao("sac", "Banco 1", 0.2f);
		assertEquals(null, modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void testBanco2Invalido() throws TaxaDeJurosInvalidaException {
		modalidade = Modalidade.criarSimulacao("mix", "Banco 2", 0.7f);
		assertEquals(null, modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void testBanco3Invalido() throws TaxaDeJurosInvalidaException {
		modalidade = Modalidade.criarSimulacao("invalid", "Banco 3", 0.1f);
		assertEquals(null, modalidade);
	}
  
}