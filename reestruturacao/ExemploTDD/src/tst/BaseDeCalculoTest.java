package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class BaseDeCalculoTest {

	private IRPF irpf;

	@Before 
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void test1() {
		irpf.cadastrarRendimento("Salario", 10000, true);
		irpf.cadastrarRendimento("Aluguel", 2000, true);
		irpf.cadastrarRendimento("Bolsa", 1500, false);
		
		irpf.cadastrarPrevidenciaOficial(1000);
		
		assertEquals(12500f, irpf.baseCalculo(), 0f);
	}
	
	

}
