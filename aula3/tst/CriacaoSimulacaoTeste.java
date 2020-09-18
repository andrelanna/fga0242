package tst;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import Financeiro.Modalidade;


public class CriacaoSimulacaoTeste {
	
	@Test
	@Category(TstFuncional.class)
	public void tstSimulacaoBanco1(){
		Modalidade simulacaoBanco = Modalidade.criarSimulacao("Price", "Banco 1", 0.01f);
		assertEquals(true, simulacaoBanco instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void tstSimulacaoBanco2(){
		Modalidade simulacaoBanco = Modalidade.criarSimulacao("Price", "Banco 2", 0.11f);
		assertEquals(true, simulacaoBanco instanceof Modalidade);
	}
	
	@Test
	@Category(TstFuncional.class)
	public void tstSimulacaoBanco3(){
		Modalidade simulacaoBanco = Modalidade.criarSimulacao("Price", "Banco 3", 0.1998f);
		assertEquals(true, simulacaoBanco instanceof Modalidade);
	}

}
