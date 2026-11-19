package tst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Financeiro.Financiamento;
import Financeiro.Modalidade;
import Financeiro.Price;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

@RunWith(Parameterized.class)
public class TstCalculoPrice {
	
	private String banco;
	private float pv;
	private int n;
	private float i;
	private float parcelaEsperada;
	private float totalJurosEsperado;
	
	@Parameters
	public static Iterable getParameters() {
		return Arrays.asList(new Object[][] {
			{"Banco 1", 10000.0f, 10, 2.0f, 1113.26f, 1132.65f},
			{"Banco 2", 10000.0f, 12, 1.8f, 934.01f, 1208.23f},
			{"Banco 3", 10000.0f, 15, 1.7f, 760.89f, 1413.43f},
			{"Banco 2", 10000.0f, 20, 1.5f, 582.45f, 1649.14f}
			
		});
	}
	
	public TstCalculoPrice(String banco, float pv, int n, float i, float parcelaEsperada, float totalJurosEsperado) {
		this.banco = banco;
		this.pv = pv;
		this.n = n;
		this.i = i;
		this.parcelaEsperada = parcelaEsperada;
		this.totalJurosEsperado = totalJurosEsperado;
	}
	
	@Category(TstFuncional.class)
	@Test
	public void CalculoPriceTeste() throws PrestacaoMaiorQueMargemException {
		Modalidade modalidade = Price.criarSimulacao("Price", banco, i/100);
		Financiamento financiamento = Financiamento.criarFinanciamento(pv, n, (pv/n));
		financiamento.adicionarSimulacao(modalidade);
		modalidade.adicionarFinanciamento(financiamento);
		float p = modalidade.calcularPrestacoes();
		float j = modalidade.calcularTotalJuros();
		assertEquals(parcelaEsperada, p, 1);
		assertEquals(totalJurosEsperado, j, 1);
	}
	
	
}
