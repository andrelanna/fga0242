package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class CadastroMaisDeUmaOutraDeducaoTest extends BaseTest{


	@Test
	public void testCadastroFunprespPrevPrivada() {
		irpf.cadastrarOutraDeducao("Funpresp", 1000);
		irpf.cadastrarOutraDeducao("Previdencia Privada", 500);
		
		boolean contemFunpresp = irpf.contemDeducao("Funpresp");
		boolean contemPPrivada = irpf.contemDeducao("Previdencia Privada");
		int totalOutrasDeducoes = irpf.getTotalOutrasDeducoes();
		
		assertTrue(contemFunpresp);
		assertTrue(contemPPrivada);
		assertEquals(1500, totalOutrasDeducoes);
	}
	
	@Test
	public void testCadastroFunprespCarneLeao() {
		irpf.cadastrarOutraDeducao("Funpresp", 1000);
		irpf.cadastrarOutraDeducao("Carne Leao", 200);
		
		boolean contemFunpresp = irpf.contemDeducao("Funpresp");
		boolean contemPPrivada = irpf.contemDeducao("Carne Leao");
		int totalOutrasDeducoes = irpf.getTotalOutrasDeducoes();
		
		assertTrue(contemFunpresp);
		assertTrue(contemPPrivada);
		assertEquals(1200, totalOutrasDeducoes);
	}
	
	@Test
	public void testCadastroFunprespPrevPrivadaCarneLeao() {
		irpf.cadastrarOutraDeducao("Funpresp", 1000);
		irpf.cadastrarOutraDeducao("Previdencia Privada", 500);
		irpf.cadastrarOutraDeducao("Carne Leao", 200);
		
		boolean contemFunpresp = irpf.contemDeducao("Funpresp");
		boolean contemPPrivada = irpf.contemDeducao("Previdencia Privada");
		boolean contemCLeao = irpf.contemDeducao("Carne Leao");
		int totalOutrasDeducoes = irpf.getTotalOutrasDeducoes();
		
		assertTrue(contemFunpresp);
		assertTrue(contemPPrivada);
		assertTrue(contemCLeao);
		assertEquals(1700, totalOutrasDeducoes);
	}

}
