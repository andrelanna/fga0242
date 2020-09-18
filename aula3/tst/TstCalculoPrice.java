package tst;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Financeiro.Modalidade;
import Financeiro.Price;
import financeiroExceptions.PrestacaoMaiorQueMargemException;

@Category(TstFuncional.class)
@RunWith(Parameterized.class)
public class TstCalculoPrice {
	
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object [][] dados = new Object [][] {
			{"Banco 1", 10000.f, 10, 2.f, 1113.26f, 1132.65f},
			{"Banco 2", 10000.f, 12, 1.8f, 934.01f, 1208.23f},
			{"Banco 3", 10000.f, 15, 1.7f, 760.89f, 1413.43f},
			{"Banco 4", 10000.f, 20, 1.5f, 582.45f, 1649.14f},
		};
		
		return Arrays.asList(dados);
	}

	private String banco;
	private int n;
	private float pv;
	private float i;
	private float parcelaEsperada;
	private float totalJurosEsperado;
	
	public TstCalculoPrice(String banco, float pv, int n, float i, float parcelaEsperada, float totalJurosEsperado) {
		this.banco = banco;
		this.pv = pv;
		this.n = n;
		this.i = i;
		this.parcelaEsperada = parcelaEsperada;
		this.totalJurosEsperado = totalJurosEsperado;
		
		
	}

	@Test
	public void testParametrizado() throws PrestacaoMaiorQueMargemException {

		Modalidade simulacao = Modalidade.criarSimulacao("Price", banco, i);		
		Financeiro.Financiamento financiamento = Financeiro.Financiamento.criarFinanciamento(pv, n, pv/n);
		Price price = new Price("Price", i);
		
		financiamento.adicionarSimulacao(simulacao);
		price.adicionarFinanciamento(financiamento);

		assertEquals(parcelaEsperada, (price.calcularPrestacoes()), 2);
		assertEquals(totalJurosEsperado, price.calcularTotalJuros(), 2);
	}

}
