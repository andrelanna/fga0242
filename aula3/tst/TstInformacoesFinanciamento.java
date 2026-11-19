package tst;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.experimental.categories.Category;
import org.junit.Test;

import Financeiro.Financiamento;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

import org.junit.Test;

public class TstInformacoesFinanciamento {

	private Financiamento financiamento;
	
	@Test
	@Category(TstFuncional.class)
	public void testFinanciamentoInstanceSuccess() throws PrestacaoMaiorQueMargemException {
		financiamento = Financiamento.criarFinanciamento(10000, 12, 2000);			
		assertEquals(true, financiamento instanceof Financiamento);
	}
	
	@Test(expected=Exception.class)
	@Category(TstExcecao.class)
	public void testFinanciamentoException() throws PrestacaoMaiorQueMargemException {
		financiamento = Financiamento.criarFinanciamento(10000, 12, 600);			
	}
}
