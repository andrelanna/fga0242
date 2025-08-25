package tst;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import Financeiro.Financiamento;
import financeiroExceptions.PrestacaoMaiorQueMargemException;


public class TstInformacoesFinanciamento {
	@Test
	@Category(TstFuncional.class)
	public void tstFinaciamentoValido() throws PrestacaoMaiorQueMargemException {
		Financiamento financiamento = Financiamento.criarFinanciamento(10000f, 12, 2000f);
		assertEquals(true, financiamento instanceof Financiamento);
		assertEquals(12, financiamento.getN());
		assertEquals(10000f, financiamento.getPv(), 0);		
	}
	
	@Test(expected=PrestacaoMaiorQueMargemException.class)
	@Category(TstExcecao.class)
	public void tstFinanciamentoInvalido() throws PrestacaoMaiorQueMargemException {
		Financiamento financiamento = Financiamento.criarFinanciamento(10000f, 12, 600f);
	}
}
