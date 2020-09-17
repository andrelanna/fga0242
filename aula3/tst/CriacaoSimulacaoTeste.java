package tst;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import Financeiro.Modalidade;
 
public class CriacaoSimulacaoTeste {

	private Modalidade modalidade;
	
	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoUmPrice() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 1", 0.051f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoDoisPrice() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 2", 0.052f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoTresPrice() {
		modalidade = Modalidade.criarSimulacao("Price", "Banco 3", 0.053f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoUmOutraModalidade() {
		modalidade = Modalidade.criarSimulacao("SAC", "Banco 1", 0.051f);
		assertEquals(null, modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoDoisOutraModalidade() {
		modalidade = Modalidade.criarSimulacao("SAC", "Banco 2", 0.052f);
		assertEquals(null, modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void simulacaoBancoTresOutraModalidade() {
		modalidade = Modalidade.criarSimulacao("SAC", "Banco 3", 0.053f);
		assertEquals(null, modalidade);
	}

}
