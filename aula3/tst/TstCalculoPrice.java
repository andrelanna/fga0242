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
	private float juros;
	private float parcela;
	private float totalJuros;

	public TstCalculoPrice(String banco, float pv, int n, float i, float parcelaEsperada, float totalJurosEsperado) {
		this.banco = banco;
		this.pv = pv;
		this.n = n;
		this.juros = i;
		this.parcela = parcelaEsperada;
		this.totalJuros = totalJurosEsperado;

	}

	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] casos = new Object[][] {
			{"Banco 1", 10000f, 10, 0.02f, 1113.26f, 1132.65f},
			{"Banco 2", 10000f, 12, 0.018f, 934.01f, 1208.23f},
			{"Banco 3", 10000f, 15, 0.017f, 760.89f, 1413.23f},
			{"Banco 2", 10000f, 20, 0.015f, 582.45f, 1649.14f}			
		};
		return Arrays.asList(casos);
	}

	@Test
	@Category(TstFuncional.class)
	public void tstPriceParameters() throws PrestacaoMaiorQueMargemException {
		Modalidade mod = Modalidade.criarSimulacao("Price", banco, juros);
		Financiamento fin = Financiamento.criarFinanciamento(pv, n, pv/n);
		fin.adicionarSimulacao(mod);
		mod.adicionarFinanciamento(fin);
		float prestacao = mod.calcularPrestacoes();
		float juros = mod.calcularTotalJuros();
		assertEquals(parcela, prestacao, 2);
		assertEquals(totalJuros, juros, 2);
	}

}