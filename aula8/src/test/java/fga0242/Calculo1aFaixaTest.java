package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import main.java.fga0242.IRPF;

public class Calculo1aFaixaTest extends CalculoFaixaBaseTest{


	@Test
	public void testCalculo1aFaixa() {
		assertEquals(1903.98f, irpf.getOcupacao1aFaixa(), 0);
		assertEquals(0f, irpf.getImposto1aFaixa(), 0);
	}
	
	@Test
	public void outroTestCalculo1aFaixa() {
		irpf = new IRPF();
		irpf.cadastrarRendimento("salario", 1500);
		
		assertEquals(1500.0f, irpf.getOcupacao1aFaixa(), 0);
		assertEquals(0.0f, irpf.getImposto1aFaixa(), 0);
	}
	
	@Test
	public void maisUmTestCalculo1aFaixa() {
		irpf = new IRPF();
		irpf.cadastrarRendimento("salario", 1500);
		irpf.cadastrarRendimento("Aluguel", 300);
		
		assertEquals(1800.0f, irpf.getOcupacao1aFaixa(), 0);
		assertEquals(0.0f, irpf.getImposto1aFaixa(), 0);
	}
	

}
