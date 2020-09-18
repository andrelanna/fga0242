package tst;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Financiamento;
import financeiroExceptions.NumeroDeParcelasInvalidasException;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

public class TstInformacoesFinanciamento {

	private Financiamento financiamento;
	
	@Test
	@Category(TstFuncional.class)
	public void testFinanciamentoValido() throws PrestacaoMaiorQueMargemException, NumeroDeParcelasInvalidasException {
		financiamento = Financiamento.criarFinanciamento(10000, 12, 2000);
		assertEquals(true, financiamento instanceof Financiamento);
	}
	
	@Test(expected=Exception.class)
	@Category(TstExcecao.class)
	public void testFinanciamentoInvalido() throws PrestacaoMaiorQueMargemException, NumeroDeParcelasInvalidasException {
		financiamento = Financiamento.criarFinanciamento(10000, 12, 600);			
	}

}
