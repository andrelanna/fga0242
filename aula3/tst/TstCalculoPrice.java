package tst;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import Financeiro.Modalidade;
import Financeiro.Financiamento;
import Financeiro.Price;

import financeiroExceptions.PrestacaoMaiorQueMargemException;

@RunWith(Parameterized.class)
public class TstCalculoPrice {

	private String banco;
	private int pv;
	private int n;
	private float i;
	private float parcelasEsp;
	private float jurosEsp;

	@Parameters
	public static Iterable<Object[]> getParameters() {
		return Arrays.asList(new Object[][]{
			{"banco 1", 10000, 10, (2.0f/100), 1113.26f, 1132.65f},
			{"banco 2", 10000, 12, (1.8f/100), 934.01f, 1208.23f},
			{"banco 3", 10000, 15, (1.7f/100), 760.89f, 1413.43f},
			{"banco 2", 10000, 20, (1.5f/100), 582.45f, 1649.14f}
		});
	}

	public TstCalculoPrice(String banco, int pv, int n, float i, float parcelasEsp, float jurosEsp) {
		this.banco = banco;
		this.pv = pv;
		this.n = n;
		this.i = i;
		this.parcelasEsp = parcelasEsp;
		this.jurosEsp = jurosEsp;
	}

	@Test
	@Category(TstFuncional.class)
	public void testPrice() throws PrestacaoMaiorQueMargemException {
		Modalidade price = Price.criarSimulacao("price", banco, i);
		Financiamento financiamento = Financiamento.criarFinanciamento(pv, n, 5000);

		financiamento.adicionarSimulacao(price);
		price.adicionarFinanciamento(financiamento);

		float parcelas = price.calcularPrestacoes();
		float juros = price.calcularTotalJuros();

		assertEquals(parcelasEsp, parcelas, 2);
		assertEquals(jurosEsp, juros, 2);
	}

}