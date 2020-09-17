package tst;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Financiamento;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

public class TstInformacoesFinanciamento {
	@Test
	@Category(TstFuncional.class)
	public void testFinanciamentoSucesso() throws PrestacaoMaiorQueMargemException {
		Financiamento financiamento = Financiamento.criarFinanciamento(10000f, 12, 2000f);
		
		Assert.assertTrue(financiamento instanceof Financiamento);
		Assert.assertEquals(10000f, financiamento.getPv(), 0);
		Assert.assertEquals(12, financiamento.getN());
	}
	
	@Test(expected = PrestacaoMaiorQueMargemException.class)
	@Category(TstExcecao.class)
	public void testFinanciamentoFalha() throws PrestacaoMaiorQueMargemException {
		Financiamento financiamento = Financiamento.criarFinanciamento(10000f, 12, 600f);
		
		Assert.assertTrue(financiamento instanceof Financiamento);
	}
}
