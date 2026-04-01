package tst;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import Financeiro.Modalidade;
 
public class CriacaoSimulacaoTeste {

	private Modalidade simulacao;
	
	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoUmPrice() {
		simulacao = Modalidade.criarSimulacao("Price", "Banco 1", 0.051f);
		assertEquals(true, simulacao instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoDoisPrice() {
		simulacao = Modalidade.criarSimulacao("Price", "Banco 2", 0.052f);
		assertEquals(true, simulacao instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoTresPrice() {
		simulacao = Modalidade.criarSimulacao("Price", "Banco 3", 0.053f);
		assertEquals(true, simulacao instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoUmOutraModalidade() {
		simulacao = Modalidade.criarSimulacao("SAC", "Banco 1", 0.051f);
		assertEquals(null, simulacao);
	}

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoDoisOutraModalidade() {
		simulacao = Modalidade.criarSimulacao("SAC", "Banco 2", 0.052f);
		assertEquals(null, simulacao);
	}

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoTresOutraModalidade() {
		simulacao = Modalidade.criarSimulacao("SAC", "Banco 3", 0.053f);
		assertEquals(null, simulacao);
	}

}
