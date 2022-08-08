package test.java.fga0242;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CadastroDeDependentesTest extends BaseTest{

	@Test
	public void testCadastroUmDependente() {
		assertTrue(irpf.cadastrarDependente("Fulano de tal"));
		assertFalse(irpf.cadastrarDependente("Fulano de tal"));
		assertTrue(irpf.possuiDependente("Fulano de tal"));
		assertEquals(189.59f, irpf.getDeducaoDependentes(), 0);
	}
	
	@Test
	public void testCadastroDoisDependentes() {
		assertTrue(irpf.cadastrarDependente("Fulano de tal"));
		assertFalse(irpf.cadastrarDependente("Fulano de tal"));
		assertTrue(irpf.possuiDependente("Fulano de tal"));
		assertEquals(189.59f, irpf.getDeducaoDependentes(), 0);
		
		assertTrue(irpf.cadastrarDependente("Beltrano de tal"));
		assertFalse(irpf.cadastrarDependente("Beltrano de tal"));
		assertTrue(irpf.possuiDependente("Beltrano de tal"));
		assertEquals(379.18f, irpf.getDeducaoDependentes(), 0);
	}
	
	@Test
	public void testCadastroTresDependentes() {
		assertTrue(irpf.cadastrarDependente("Fulano de tal"));
		assertFalse(irpf.cadastrarDependente("Fulano de tal"));
		assertTrue(irpf.possuiDependente("Fulano de tal"));
		assertEquals(189.59f, irpf.getDeducaoDependentes(), 0);
		
		assertTrue(irpf.cadastrarDependente("Beltrano de tal"));
		assertFalse(irpf.cadastrarDependente("Beltrano de tal"));
		assertTrue(irpf.possuiDependente("Beltrano de tal"));
		assertEquals(379.18f, irpf.getDeducaoDependentes(), 0);
		
		assertTrue(irpf.cadastrarDependente("Maria"));
		assertFalse(irpf.cadastrarDependente("Maria"));
		assertTrue(irpf.possuiDependente("Maria"));
		assertEquals(568.77f, irpf.getDeducaoDependentes(), 0);
	}

}




