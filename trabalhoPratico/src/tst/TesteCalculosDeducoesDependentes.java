package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteCalculosDeducoesDependentes {

	IRPF irpf; 
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void testDeducao1Dependente() {
		irpf.cadastrarDependente("Maria da Silva", "Filho");
		assertEquals(189.59f, irpf.getDeducao(), 0.0f);
	}
	
	@Test
	public void testDeducao2Dependente() {
		irpf.cadastrarDependente("Maria da Silva", "Filho");
		irpf.cadastrarDependente("Carlos da Silva", "Filho");
		assertEquals(379.18f, irpf.getDeducao(), 0.0f);
	}
	
	@Test
	public void testDeducao3Dependente() {
		irpf.cadastrarDependente("Maria da Silva", "Filho");
		irpf.cadastrarDependente("Carlos da Silva", "Filho");
		irpf.cadastrarDependente("Jose da Silva", "Filho");
		assertEquals(568.77f, irpf.getDeducao(), 0.0f);
	}

}
