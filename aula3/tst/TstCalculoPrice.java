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
import financeiroExceptions.PrestacaoMaiorQueMargemException;

@RunWith(Parameterized.class)
public class TstCalculoPrice {

	private String banco;
	private float pv;
	private int n;
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
	
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] dados = new Object[][] {
			{"Banco 1", 10000f, 10, 0.02f, 1113.26f, 1132.65f},
			{"Banco 2", 10000f, 12, 0.018f, 934.01f, 1208.23f},
			{"Banco 3", 10000f, 15, 0.017f, 760.89f, 1413.23f},
			{"Banco 2", 10000f, 20, 0.015f, 582.45f, 1649.14f}			
		};
		return Arrays.asList(dados);
	}

	@Test
	@Category(TstFuncional.class)
	public void testePrice() throws PrestacaoMaiorQueMargemException {
		Modalidade simulacao = Modalidade.criarSimulacao("Price", banco, i);
		Financiamento financiamento = Financiamento.criarFinanciamento(pv, n, 2000);
		financiamento.adicionarSimulacao(simulacao);
		simulacao.adicionarFinanciamento(financiamento);
		float prestacao = simulacao.calcularPrestacoes();
		float juros = simulacao.calcularTotalJuros();
		assertEquals(parcelaEsperada, prestacao, 2);
		assertEquals(totalJurosEsperado, juros, 2);
	}

}
