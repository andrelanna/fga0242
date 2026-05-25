package fga0242;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import exceptions.CampoEmBrancoOuNuloException;

public class CriacaoIRPFTest {

	FcdCadastroDeclaracoes cadDec;
	private IDeclaracao dec;
	private IDeclaracao dec1; 
	
	public CriacaoIRPFTest() {
	}

	@Before 
	public void setup() {
		cadDec = FcdCadastroDeclaracoes.obterInstancia();
		dec = cadDec.criarDeclaracao("Cidadao 0", "000.000.000-00");
		dec1 = cadDec.criarDeclaracao("Cidadao 1", "111.111.111-11");
	}
	
	@Test
	public void testCriacaoDeclaracao() {
		assertNotNull(dec); 
		assertEquals(2, cadDec.numDeclaracoes());
	}
	
	@Test
	public void testCriacaoDeclaracaoDuplicada() {
		IDeclaracao dec3 = cadDec.criarDeclaracao("Cidadao 1", "111.111.111-11");
		
		assertNotNull(dec3);
		assertEquals(2, cadDec.numDeclaracoes());
	}
	
	@Test
	public void testBuscaDeclaracao() {
		IDeclaracao dec1 = cadDec.pesquisarDeclaracaoCPF("000.000.000-00");
		assertNotNull(dec1);
	}
	
	
	@Test(expected = CampoEmBrancoOuNuloException.class)
	public void testCriacaoDeclaracaoNomeEmBranco() {
		IDeclaracao dec = cadDec.criarDeclaracao("", "000.000.000-00");
		assertEquals(2, cadDec.numDeclaracoes());
	}
	
	@Test(expected = CampoEmBrancoOuNuloException.class) 
	public void testCriacaoDeclaracaoCPFEmBranco() {
		IDeclaracao dec = cadDec.criarDeclaracao("Cidadao 1", "");
		assertEquals(2, cadDec.numDeclaracoes());
	}

}
