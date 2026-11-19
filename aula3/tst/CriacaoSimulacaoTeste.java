package tst;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste {

	private Modalidade modalidade; 

	@Test
	@Category(TstFuncional.class)
	public void test1Sucesso() {
		modalidade = Modalidade.criarSimulacao("price", "Banco 1", 0.2f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void test2Sucesso() {
		modalidade = Modalidade.criarSimulacao("price", "Banco 2", 0.1f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void test3Sucesso() {
		modalidade = Modalidade.criarSimulacao("price", "Banco 3", 0.05f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void test1Falha() {
		modalidade = Modalidade.criarSimulacao("notprice", "Banco 1", 0.2f);
		assertEquals(null, modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void test2Falha() {
		modalidade = Modalidade.criarSimulacao("maybeprice", "Banco 2", 0.1f);
		assertEquals(null, modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void test3Falha() {
		modalidade = Modalidade.criarSimulacao("yesprice", "Banco 3", 0.05f);
		assertEquals(null, modalidade);
	}

}
