package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteCadastroOutrasDeducoes {

	IRPF irpf; 
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	
	@Test
	public void cadastroUmaDeducao() {
		irpf.cadastrarDeducaoIntegral("Funpresp", 1000f);
		assertNotNull(irpf.getOutrasDeducoes("Funpresp")); 
		assertEquals(1000f, irpf.getDeducao("Funpresp"), 0f);
		assertEquals(1000f, irpf.getTotalOutrasDeducoes(), 0f);
	}
	
	@Test
	public void cadastroDuasDeducoes() {
		irpf.cadastrarDeducaoIntegral("Funpresp", 1000f);
		irpf.cadastrarDeducaoIntegral("Carne-leao", 500f);
		assertNotNull(irpf.getOutrasDeducoes("Funpresp")); 
		assertEquals(1000f, irpf.getDeducao("Funpresp"), 0f);
		assertEquals(500f, irpf.getDeducao("Carne-leao"), 0f);
		assertEquals(1500f, irpf.getTotalOutrasDeducoes(), 0f);
	}
	
	@Test
	public void cadastroTresDeducoes() {
		irpf.cadastrarDeducaoIntegral("Funpresp", 1000f);
		irpf.cadastrarDeducaoIntegral("Carne-leao", 500f);
		irpf.cadastrarDeducaoIntegral("PGBL", 500f);
		assertNotNull(irpf.getOutrasDeducoes("Funpresp")); 
		assertEquals(1000f, irpf.getDeducao("Funpresp"), 0f);
		assertEquals(500f, irpf.getDeducao("Carne-leao"), 0f);
		assertEquals(500f, irpf.getDeducao("PGBL"), 0f);
		assertEquals(2000f, irpf.getTotalOutrasDeducoes(), 0f);
	}
	
	@Test
	public void deducaoInexistente() {
		String nomeDeducao = "Funpresp";
		float valorDeducao = 1000f;
		irpf.cadastrarDeducaoIntegral(nomeDeducao, valorDeducao);
		
		
		assertNull(irpf.getOutrasDeducoes("Carne-leao"));
		assertEquals(0f, irpf.getDeducao("Carne-leao"), 0f);
	}
}
