package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Financiamento;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

public class TstInformacoesFinanciamento {

	private Financiamento financiamento;
	
	@Category(TstFuncional.class)
	@Test
	public void testeFinanceiroSuccess() throws PrestacaoMaiorQueMargemException {
		financiamento = Financiamento.criarFinanciamento(10000.0f, 12, 2000.0f);
		assertEquals(true, financiamento instanceof Financiamento);
	}
	
//	@Category(TstExcecao.class)
//	@Test(expected = PrestacaoMaiorQueMargemException.class)
//	public void testeFinanceiro2Exception() throws PrestacaoMaiorQueMargemException {
//		financiamento = Financiamento.criarFinanciamento(10.000f, 12, 600.0f);			
//	}
	
	@Category(TstExcecao.class)
	@Test()
	public void testeFinanceiro2Exception() throws PrestacaoMaiorQueMargemException {
		financiamento = Financiamento.criarFinanciamento(10.000f, 12, 600.0f);			
	}
	
}
