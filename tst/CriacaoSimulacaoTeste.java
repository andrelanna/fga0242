package tst;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import Financeiro.Modalidade;
import Financeiro.Price;

public class CriacaoSimulacaoTeste {
	@Test
	@Category(TstFuncional.class)
	public void testSimulacaoSucesso(){
		Modalidade banco = Modalidade.criarSimulacao("Price", "Banco 1", 0.1f);
		Assert.assertTrue(banco instanceof Price);
	}

	@Test
	@Category(TstFuncional.class)
	public void testSimulacaoSucesso(){
		Modalidade banco = Modalidade.criarSimulacao("Price", "Banco 2", 0.2f);
		Assert.assertTrue(banco instanceof Price);
	}

    @Test
	@Category(TstFuncional.class)
	public void testSimulacaoSucesso(){
		Modalidade banco = Modalidade.criarSimulacao("Price", "Banco 3", 0.3f);
		Assert.assertTrue(banco instanceof Price);
	}
}