package tst;

import java.util.Arrays;
import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Financeiro.Financiamento;
import Financeiro.Modalidade;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

@RunWith(Parameterized.class)
public class TstCalculoPrice {

	private float _pv;
	private int _n;
	private float _i;
	private String _banco;
	
	private float _parcelaEsperada;
	private float _totalJurosEsperado;

	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] simulacoes = new Object[][] {
			{"Banco 1", 10000, 10, 2.0f, 1113.26f, 1132.65f},
			{"Banco 2", 10000, 12, 1.8f, 934.01f, 1208.23f},
			{"Banco 3", 10000, 15, 1.7f, 760.89f, 1413.23f},
			{"Banco 2", 10000, 20, 1.5f, 582.45f, 1649.14f},
		};
		
		return Arrays.asList(simulacoes);
	}


	public TstCalculoPrice(String banco, float pv, int n, float i, float parcelaEsperada, float totalJurosEsperado) {
		this._banco = banco;
		this._pv = pv;
		this._n = n;
		this._i = i;
		this._parcelaEsperada = parcelaEsperada;
		this._totalJurosEsperado = totalJurosEsperado;
	}

	@Test
	@Category(TstFuncional.class)
	public void testSimulacaoFinanciamentoBanco() throws PrestacaoMaiorQueMargemException{
		Modalidade simulacaoBanco = Modalidade.criarSimulacao("Price", _banco, _i);		
		Financiamento financiamento = Financiamento.criarFinanciamento(_pv, _n, _pv/_n);

		financiamento.adicionarSimulacao(simulacaoBanco);
		simulacaoBanco.adicionarFinanciamento(financiamento);

		float prestacoes = simulacaoBanco.calcularPrestacoes();
		float juros = simulacaoBanco.calcularTotalJuros();

		Assert.assertEquals(_parcelaEsperada, prestacoes, 2);
		Assert.assertEquals(_totalJurosEsperado, juros, 2);
	}
	
}
