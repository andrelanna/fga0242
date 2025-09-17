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
	public void primeiroFinanciamento() throws PrestacaoMaiorQueMargemException {
			financiamento = Financiamento.criarFinanciamento(10000, 12, 2000);			
			assertEquals(true, financiamento instanceof Financiamento);
	}
	
	@Test(expected=Exception.class)
	@Category(TstExcecao.class)
	public void segundoFinanciamento() throws PrestacaoMaiorQueMargemException {
			financiamento = Financiamento.criarFinanciamento(10000, 12, 600);			
	}

}