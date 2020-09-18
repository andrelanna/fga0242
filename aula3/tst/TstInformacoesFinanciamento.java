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
	public void test1() throws PrestacaoMaiorQueMargemException {
		financiamento = Financiamento.criarFinanciamento(10000, 12, 2000);
		assertNotEquals(null, financiamento);
	}
	
	@Test(expected=PrestacaoMaiorQueMargemException.class)
	@Category(TstExcecao.class)
	public void test2() throws PrestacaoMaiorQueMargemException {
		financiamento = Financiamento.criarFinanciamento(10000, 12, 600);
		assertNotEquals(null, financiamento);
	}
}
