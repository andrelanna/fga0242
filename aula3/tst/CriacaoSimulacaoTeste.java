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
		Modalidade simulacaoBanco1 = Modalidade.criarSimulacao("Price", "Banco 1", 0.42f);
		Modalidade simulacaoBanco2 = Modalidade.criarSimulacao("Price", "Banco 2", 0.43f);
		Modalidade simulacaoBanco3 = Modalidade.criarSimulacao("Price", "Banco 3", 0.44f);

		Assert.assertTrue(simulacaoBanco1 instanceof Price);
		Assert.assertTrue(simulacaoBanco2 instanceof Price);
		Assert.assertTrue(simulacaoBanco3 instanceof Price);
	}
	
}