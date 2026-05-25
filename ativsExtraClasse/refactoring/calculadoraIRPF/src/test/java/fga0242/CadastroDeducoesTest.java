package fga0242;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CadastroDeducoesTest {

	CadastroDeclaracoes cadDec;
	IDeclaracao dec; 
	
	
	@Before
	public void setup() {
		cadDec = CadastroDeclaracoes.obterInstancia();
		dec = cadDec.criarDeclaracao("Cidadao 1", "000.000.000-00");
	}
	
	@Test
	public void testCadastroUmaDeducao() {
		boolean resposta = dec.cadastrarDeducao("Pensão alimentícia", 1000f);
		assertTrue(resposta);
		assertEquals(1000f, dec.totalDeducoes(), 0.01f); 
	}
	
	@Test
	public void testCadastroVariasDeducoes() {
		assertTrue(dec.cadastrarDeducao("Pensao Alimenticia", 1000f));
		assertTrue(dec.cadastrarDeducao("Plano de saúde", 500f));
		assertEquals(1500f, dec.totalDeducoes(), 0.01f);
	}
	
	@Test
	public void testCadastroDeducoesEDependentes() {
		assertTrue(dec.cadastrarDependente("Dependente 1", "111.111.111-11"));
		assertTrue(dec.cadastrarDeducao("Plano de saúde", 500f));
		assertTrue(dec.cadastrarDeducao("Pensao Alimentícia", 500f));
		assertEquals(1189.59f, dec.totalDeducoes(), 0.01f);
	}

}
