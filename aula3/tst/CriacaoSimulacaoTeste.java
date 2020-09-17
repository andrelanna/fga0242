package tst;

import static org.junit.Assert.*;

import org.junit.Test;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste {

	private Modalidade modalidade;
	
	@Test
	public void testSimulaBanco1() {
		modalidade = Modalidade.criarSimulacao("Price", "banco 1", 0.075f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	public void testSimulaBanco2() {
		modalidade = Modalidade.criarSimulacao("Price", "banco 2", 0.075f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	public void testSimulaBanco3() {
		modalidade = Modalidade.criarSimulacao("Price", "banco 3", 0.075f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

}
