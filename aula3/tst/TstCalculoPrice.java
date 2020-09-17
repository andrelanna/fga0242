package tst;

import java.util.Arrays;

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

	private String _banco;
	private float _pv;
	private int _n;
	private float _i;
	private float _parcelaEsperada;
	private float _totalJurosEsperado;

	@Parameters
	public static Iterable<?> getParameters() {
		return Arrays.asList(new Object[][] {
			{"Banco1", 10000f, 10, 0.020f, 1113.26f, 1132.65f},
			{"Banco2", 10000f, 12, 0.018f, 934.01f, 1208.23f},
			{"Banco3", 10000f, 15, 0.017f, 760.89f, 1413.43f},
			{"Banco2", 10000f, 20, 0.015f, 582.45f, 1649.14f}
		});
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
