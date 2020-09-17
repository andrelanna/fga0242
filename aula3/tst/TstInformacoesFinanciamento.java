package tst;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Financiamento;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

public class TstInformacoesFinanciamento {
	
	private Financiamento financiamento;

	@Test
	@Category(TstFuncional.class)
	public void testeIformacoesFinanciamento() throws PrestacaoMaiorQueMargemException {
		financiamento = Financiamento.criarFinanciamento(10000f, 12, 2000f);
		assertEquals(true, financiamento instanceof Financiamento);
		assertEquals(10000f, financiamento.getPv(), 0.0f);
		assertEquals(12, financiamento.getN());
	}
	
	@Test(expected=PrestacaoMaiorQueMargemException.class)
	@Category(TstExcecao.class)
	public void testePrestacaoMaiorQueMargem() throws PrestacaoMaiorQueMargemException {
		financiamento = Financiamento.criarFinanciamento(10000f, 12, 600f);
		assertEquals(true, financiamento instanceof Financiamento);
		assertEquals(10000f, financiamento.getPv(), 0.0f);
		assertEquals(12, financiamento.getN());
	}

}
