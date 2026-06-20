	package tst;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste {

	
	private Modalidade modalidade;
	
	@Test
	@Category(TstFuncional.class)
	public void testeSimulacaoBancoUm() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 1", 0.05f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void testeSimulacaoBancoDois() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 2", 0.002f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void testeSimulacaoBancoTres() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 3", 0.004f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

}
