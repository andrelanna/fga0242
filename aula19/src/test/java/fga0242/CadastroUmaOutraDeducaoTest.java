package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class CadastroUmaOutraDeducaoTest extends BaseTest {

	@Test
	public void testCadastroFunpresp() {
		irpf.cadastrarOutraDeducao("Funpresp", 1000);
		int total = irpf.getTotalOutrasDeducoes();
		
		boolean contemDeducao = irpf.contemDeducao("Funpresp");
		assertEquals(1000, total);
		assertTrue(contemDeducao);
	}
	
	@Test
	public void testCadastroPrevidenciaPrivada() {
		irpf.cadastrarOutraDeducao("Previdencia Privada", 500);
		int total = irpf.getTotalOutrasDeducoes();
		
		boolean contemDeducao = irpf.contemDeducao("Previdencia Privada");
		assertEquals(500, total);
		assertTrue(contemDeducao);
	}

	@Test
	public void testCadastroCarneLeao() {
		irpf.cadastrarOutraDeducao("Carne Leao", 200);
		int total = irpf.getTotalOutrasDeducoes();
		
		boolean contemDeducao = irpf.contemDeducao("Carne Leao");
		assertEquals(200, total);
		assertTrue(contemDeducao);
	}
}
