package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import main.java.fga0242.ValorInvalidoException;

public class BaseDeCalculoTest extends BaseTest{


	@Test
	public void test() throws ValorInvalidoException {
		irpf.cadastrarRendimento("Salario", 10000);
		
		irpf.cadastrarPrevidenciaOficial(1000);
		irpf.cadastrarDependente("Fulano");
		irpf.cadastrarPensaoAlimenticia(500);
		irpf.cadastrarOutraDeducao("Previdencia privada", 500);
		
		assertEquals(2189.59f, irpf.getTotalDeducoes(), 0.01);
		
		assertEquals(7810.41f, irpf.getBaseDeCalculo(), 0.01);
	}

}
