package tst;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import Financeiro.Modalidade;

public class CriacaoSimulacaoTeste {
	private Modalidade modalidade; 

	@Test
	@Category(TstFuncional.class)
	public void testeSimulacaoBanco1() {
		modalidade = Modalidade.criarSimulacao("PRICE", "Banco 1", 0.05f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void testeSimulacaoBanco2() {		
		modalidade = Modalidade.criarSimulacao("PRICE", "Banco 2", 0.0023f);
		assertEquals(true, modalidade instanceof Modalidade);
	}

	@Test
	@Category(TstFuncional.class)
	public void testeSimulacaoBanco3() {
		modalidade = Modalidade.criarSimulacao("Sistema Inglês de Amortização", "Banco 3", 0.001f);
		assertEquals(null, modalidade);
	}

} 