package tst;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Price;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

public class CriacaoSimulacaoTeste {
	
    @Category(TstFuncional.class)
	@Test
	public void testCriarSimulacao() throws PrestacaoMaiorQueMargemException {
		Price modalidade1 = (Price) Price.criarSimulacao("Price", "Banco 1", 2.0f);
		Price modalidade2 = (Price) Price.criarSimulacao("Price", "Banco 2", 1.8f);
		Price modalidade3 = (Price) Price.criarSimulacao("Price", "Banco 3", 1.7f);
		assertNotNull(modalidade1);
		assertNotNull(modalidade2);
		assertNotNull(modalidade3);
	}


}
