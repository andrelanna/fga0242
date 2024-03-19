package tst;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import app.IRPF;
import app.PessoaFisica;

public class CadastroPensaoAlimenticiaTest extends BaseTest {

	@Override
	public void setup() {
		super.setup();
		irpf.cadastrarDependente("Andre", new Date(2019, 3, 9));
		
	}
	
	@Test
	public void test() {
		PessoaFisica alimentando = irpf.getDependente("Andre");
		assertNotNull(alimentando);
		assertTrue(irpf.cadastrarPensaoAlimenticia(alimentando, 1000f));
		assertEquals(irpf.getPensaoDependente("Andre"), 1000f, 0f);
		assertEquals(1000f, irpf.getTotalPensaoAlimenticia(), 0f);
	}
	
	@Test
	public void test2() {
		PessoaFisica alimentando = irpf.getDependente("Miguel");
		assertNull(alimentando);
		assertFalse(irpf.cadastrarPensaoAlimenticia(alimentando, 500));
		assertEquals(0f, irpf.getPensaoDependente("Miguel"), 0f);
		assertEquals(0f, irpf.getTotalPensaoAlimenticia(), 0f);
	}
	

}
