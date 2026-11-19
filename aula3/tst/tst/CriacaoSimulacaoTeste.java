package tst;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste {

	private Modalidade modalidade;

	@Category(TstFuncional.class)
	@Test
	public void simlacaoBanco1Success(){
		modalidade = Modalidade.criarSimulacao("Price", "banco 1", 0.02f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Category(TstFuncional.class)
	@Test
	public void simlacaoBanco1Fail(){
		modalidade = Modalidade.criarSimulacao("carlos", "banco 1", 0.2f);
		assertEquals(false, modalidade instanceof Modalidade);
	}
	
	@Category(TstFuncional.class)
	@Test
	public void simulacaoBanco2Success() {
		modalidade = Modalidade.criarSimulacao("Price", "banco 2",0.25f);
		assertEquals(true, modalidade instanceof Modalidade);
	}
	
	@Category(TstFuncional.class)
	@Test
	public void simlacaoBanco2Fail(){
		modalidade = Modalidade.criarSimulacao("carlos", "banco 2", 0.2f);
		assertEquals(false, modalidade instanceof Modalidade);
	}
	
	@Category(TstFuncional.class)
	@Test
	public void simulacaoBanco3Success() {
		modalidade = Modalidade.criarSimulacao("Price", "banco 3",0.25f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

	@Category(TstFuncional.class)
	@Test
	public void simlacaoBanco3Fail(){
		modalidade = Modalidade.criarSimulacao("carlos", "banco 3", 0.2f);
		assertEquals(false, modalidade instanceof Modalidade);
	}

}