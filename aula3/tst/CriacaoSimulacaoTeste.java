package tst;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Modalidade;
import Financeiro.Price;

public class CriacaoSimulacaoTeste {
	@Test
	@Category(TstFuncional.class)
	public void testSimulacao(){
		Modalidade simulacaoBanco1 = Modalidade.criarSimulacao("Price", "Banco 1", 0.25f);
		Modalidade simulacaoBanco2 = Modalidade.criarSimulacao("Price", "Banco 2", 0.38f);
		Modalidade simulacaoBanco3 = Modalidade.criarSimulacao("Price", "Banco 3", 0.41f);
	
		Assert.assertTrue(simulacaoBanco1 instanceof Price);
		Assert.assertTrue(simulacaoBanco2 instanceof Price);
		Assert.assertTrue(simulacaoBanco3 instanceof Price);
	}
}
