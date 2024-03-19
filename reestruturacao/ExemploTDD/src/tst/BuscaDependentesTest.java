package tst;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class BuscaDependentesTest {

	
	private IRPF irpf;


	@Before
	public void setup() {
		irpf = new IRPF();
		irpf.cadastrarDependente("Andre", new Date(2019, 3, 9));
	}
	
	@Test
	public void testDependenteEncontrado() {
		assertNotNull(irpf.getDependente("Andre"));
	}
	
	
	@Test
	public void testDependenteNaoEncontrado() {
		assertNull(irpf.getDependente("Maria"));
	}

}
