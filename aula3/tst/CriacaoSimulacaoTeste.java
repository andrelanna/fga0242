package tst;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste {
	
	private Modalidade modalidade; 

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBanco1Sucesso() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 1", 0.0025f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void simulacaoBanco2Sucesso() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 2", 0.005f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void simulacaoBanco3Sucesso() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 3", 0.003f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void simulacaoBanco1Falha() {
		modalidade = Modalidade.criarSimulacao("test", "Banco 1", 0.0025f);
		assertEquals(null, modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void simulacaoBanco2Falha() {
		modalidade = Modalidade.criarSimulacao("test", "Banco 2", 0.005f);
		assertEquals(null, modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void simulacaoBanco3Falha() {
		modalidade = Modalidade.criarSimulacao("test", "Banco 3", 0.003f);
		assertEquals(null, modalidade);
	}

}
