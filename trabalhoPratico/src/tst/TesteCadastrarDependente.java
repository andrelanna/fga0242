package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteCadastrarDependente {

	IRPF irpf;
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void testCadastro1Dependente() {
		irpf.cadastrarDependente("Miguel", "Filho");
		assertEquals(1, irpf.getNumDependentes());
		assertTrue(irpf.getParentesco("Miguel").equalsIgnoreCase("filho"));
	}
	
	
	@Test
	public void testCadastro2Dependente() {
		irpf.cadastrarDependente("Miguel", "Filho");
		irpf.cadastrarDependente("Maria", "Filho");
		assertEquals(2, irpf.getNumDependentes());
	}
	
	@Test
	public void testCadastro3Dependente() {
		irpf.cadastrarDependente("Miguel", "Filho");
		irpf.cadastrarDependente("Maria", "Filho");
		irpf.cadastrarDependente("Carlos", "Filho");
		assertEquals(3, irpf.getNumDependentes());
	}
	
	@Test
	public void obterUmDependente() {
		irpf.cadastrarDependente("Jose da Silva", "filho");
		String dependente = irpf.getDependente("Jose");
		assertNotNull(dependente);
		assertTrue(irpf.getParentesco(dependente).equalsIgnoreCase("filho"));
	}
	
	@Test
	public void obterDoisDependentes() {
		irpf.cadastrarDependente("Jose da Silva", "filho");
		irpf.cadastrarDependente("Laura da Silva", "filho");
		String dependente = irpf.getDependente("Jose");
		assertNotNull(dependente);
		assertTrue(irpf.getParentesco(dependente).equalsIgnoreCase("filho"));
		dependente = irpf.getDependente("Laura");
		assertTrue(irpf.getParentesco(dependente).equalsIgnoreCase("filho"));
	}
	
	@Test
	public void dependenteInexistente() {
		String dependente = irpf.getDependente("Jose");
		String parentesco = irpf.getParentesco(dependente);
		
		assertNull(dependente);
		assertNull(parentesco);
	}

}
