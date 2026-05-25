package fga0242;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import exceptions.CampoEmBrancoOuNuloException;

public class CadastroDependentesTest {

	private CadastroDeclaracoes cadDec;
	private IDeclaracao dec; 
	
	@Before
	public void setup() {
		cadDec = CadastroDeclaracoes.obterInstancia();
		dec = cadDec.criarDeclaracao("Cidadao 0", "000.000.000-00");
	}
	
	@Test
	public void testCadastrarUmDependente() {
		boolean resposta = dec.cadastrarDependente("Dependente 1", "111.111.111-11");
		assertTrue(resposta);
		assertEquals(1, dec.numDependentes()); 
		assertEquals(189.59f, dec.totalDeducoesDependentes(), 0.01f);
	}
	
	@Test(expected = CampoEmBrancoOuNuloException.class)
	public void testCadastrarDependenteNomeBranco() {
		boolean resposta = dec.cadastrarDependente("", "000.000.000-00");
	}
	
	
	@Test(expected = CampoEmBrancoOuNuloException.class)
	public void testCadastrarDependenteCPFBranco() {
		boolean resposta = dec.cadastrarDependente("Cidadao 0", " "); 
	}
	
	@Test
	public void testPesquisarDependenteCPF() {
		dec.cadastrarDependente("Dependente 1", "111.111.111-11");
		Dependente dep = dec.pesquisarDependenteCPF("111.111.111-11");
		assertNotNull(dep);
		
		dep = dec.pesquisarDependenteCPF("555.555.555-55");
		assertNull(dep);
	}
	
	@Test
	public void testCadastrarDependenteDuplicado() {
		boolean resposta = dec.cadastrarDependente("Dependente 1", "111.111.111-11");
		assertTrue(resposta);
		resposta = dec.cadastrarDependente("Dependente 1", "111.111.111-11");
		assertFalse(resposta);
	}

}
