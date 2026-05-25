package fga0242;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CadastroRendimentosTest {

	CadastroDeclaracoes cadDec;
	IDeclaracao dec;
	
	@Before
	public void setup() {
		cadDec = CadastroDeclaracoes.obterInstancia();
		dec = cadDec.criarDeclaracao("Cidadao 0", "000.000.000-00");
	}
	
	@Test
	public void testCadastroUmRendimentoTributavel() {
		boolean cadastrou = dec.cadastrarRendimento("Salário", 10000f); 
		assertTrue(cadastrou);
		assertEquals(10000f, dec.totalRendimentos(), 0.01f);
		assertEquals(10000f, dec.totalRendimentosTributaveis(), 0.01f);
		assertEquals(    0f, dec.totalRendimentosIsentos(), 0.01f);
	}
	
	@Test
	public void testCadastroUmRendimentoNaoTributavel() {
		boolean cadastrou = dec.cadastrarRendimento("Bolsa de Estudo", 5000f); 
		assertTrue(cadastrou);
		assertEquals(5000f, dec.totalRendimentos(), 0.01f);
		assertEquals(   0f, dec.totalRendimentosTributaveis(), 0.01f);
		assertEquals(5000f, dec.totalRendimentosIsentos(), 0.01f);
	}
	
	@Test 
	public void testCadastroDiferentesRendimentos() {
		assertTrue(dec.cadastrarRendimento("Salário", 10000f));
		assertTrue(dec.cadastrarRendimento("Bolsa de Estudo", 5000f));
		assertTrue(dec.cadastrarRendimento("Aluguel", 3500f));
		assertTrue(dec.cadastrarRendimento("Rendimento isento", 1500f)); 
		
		assertEquals(20000f, dec.totalRendimentos(), 0.01f);
		assertEquals(13500f, dec.totalRendimentosTributaveis(), 0.01f);
		assertEquals( 6500f, dec.totalRendimentosIsentos(), 0.01f);
	}
	
	@Test
	public void testPesquisarRendimentos() {
		assertTrue(dec.cadastrarRendimento("Salário", 10000f));
		assertTrue(dec.cadastrarRendimento("Bolsa de estudo", 3000f));
		assertTrue(dec.cadastrarRendimento("Bolsa de estudo", 1000f));
		
		assertNotNull(dec.pesquisarRendimento("Salário"));
		assertEquals(1, dec.pesquisarRendimento("Salário").size());
		
		assertNotNull(dec.pesquisarRendimento("Bolsa de estudo"));
		assertEquals(2, dec.pesquisarRendimento("Bolsa de estudo").size());
		
		assertNotNull(dec.pesquisarRendimento("Aluguel"));
		assertEquals(0, dec.pesquisarRendimento("Aluguel").size());
	}

}
