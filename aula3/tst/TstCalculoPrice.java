package tst;

import static org.junit.Assert.*;

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
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] dados = new Object[][]{
			{"Banco 1", 10000, 10, 2.0f, 1113.26f, 1132.65f},
			{"Banco 2", 10000, 12, 1.8f, 934.01f, 1208.23f},
			{"Banco 3", 10000, 15, 1.7f, 760.89f, 1413.23f},
			{"Banco 2", 10000, 20, 1.5f, 582.45f, 1649.14f},

		};
		return Arrays.asList(dados);
	}
	
	private String Banco;
	private int pv;
	private int n;
	private float i;
	private float parcelaEsperada;
	private float totalJurosEsperado;
	
	public TstCalculoPrice(String Banco, int pv, int n, float i, float parcelaEsperada, float totalJurosEsperado) {
		this.Banco = Banco;
		this.pv = pv;
		this.n = n;
		this.i = i;
		this.parcelaEsperada = parcelaEsperada;
		this.totalJurosEsperado = totalJurosEsperado;
	}
	
	@Test
	@Category(TstFuncional.class)
	public void test() throws PrestacaoMaiorQueMargemException {
		Modalidade modalidade = Price.criarSimulacao("Price", Banco, i/100);
		Financiamento financiamento = Financiamento.criarFinanciamento(pv, n, 1000);
		modalidade.adicionarFinanciamento(financiamento);
		financiamento.adicionarSimulacao(modalidade);
		float parcela = modalidade.calcularPrestacoes();
		float totalJuros = modalidade.calcularTotalJuros();
		
		assertEquals(parcelaEsperada, parcela, 0.3);
		assertEquals(totalJurosEsperado, totalJuros, 0.3);
	}
}
