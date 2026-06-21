package tst;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Financiamento;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

public class TstInformacoesFinanciamento {

	@Category(TstFuncional.class)
	@Test
	public void testCriarFinanciamento() throws PrestacaoMaiorQueMargemException {
		float pv = 10000;
		int n = 12;
		float margem = 2000;

		Financiamento financiamento = Financiamento.criarFinanciamento(pv, n, margem);

		assertEquals(financiamento.getN(), n);
		assertEquals(financiamento.getPv(), pv, 2);
	}

	@Category(TstExcecao.class)
	@Test(expected=PrestacaoMaiorQueMargemException.class)
	public void testCriarFinanciamentoExcecao() throws PrestacaoMaiorQueMargemException {
		float pv = 10000;
		int n = 12;
		float margem = 600;
		Financiamento financiamento = Financiamento.criarFinanciamento(pv, n, margem);
		assertEquals(financiamento.getN(), n);
		assertEquals(financiamento.getPv(), pv, 2);		

	}


}