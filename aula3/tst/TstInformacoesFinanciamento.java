package tst;

import org.junit.experimental.categories.Category;
import static org.junit.Assert.*;
import org.junit.Test;

import Financeiro.Financiamento;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

public class TstInformacoesFinanciamento {
	
	private Financiamento financiamento;

	@Test
	@Category(TstFuncional.class)
	public void testFinanciamento() throws PrestacaoMaiorQueMargemException {
		financiamento = Financiamento.criarFinanciamento(10000, 12, 2000);
		assertEquals(true, financiamento instanceof Financiamento);
	}
	
	@Category(TstExcecao.class)
	@Test(expected = Exception.class)
	public void testFinanciamentoException() throws PrestacaoMaiorQueMargemException {
		financiamento = Financiamento.criarFinanciamento(10000, 12, 600);
	}

}
