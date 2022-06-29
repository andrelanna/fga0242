package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.fga0242.IRPF;

public class CadastroDeDoisRendimentosTest {

	private IRPF irpf;

	@Before
	public void setup() {
		this.irpf = new IRPF();
	}
	
	@Test
	public void testCadastroSalarioAluguel() {
		irpf.cadastrarRendimento("Salario", 9000);
		irpf.cadastrarRendimento("Aluguel", 1000);
		
		assertEquals(10000, irpf.getTotalRendimentos());
		assertTrue(irpf.containsRendimento("Salario"));
		assertTrue(irpf.containsRendimento("Aluguel"));
	}
	
	@Test
	public void testCadastroSalarioInvestimento() {
		irpf.cadastrarRendimento("Salario", 9000);
		irpf.cadastrarRendimento("Dividendos", 2000);
		
		assertEquals(11000, irpf.getTotalRendimentos());
		assertTrue(irpf.containsRendimento("Salario"));
		assertTrue(irpf.containsRendimento("Dividendos"));
	}
	
	@Test
	public void testCadastroSalarioAluguelInvestimento() {
		irpf.cadastrarRendimento("Salario", 9000);
		irpf.cadastrarRendimento("Aluguel", 1000);
		irpf.cadastrarRendimento("Dividendos", 2000);
		
		assertEquals(12000, irpf.getTotalRendimentos());
		assertTrue(irpf.containsRendimento("Salario"));
		assertTrue(irpf.containsRendimento("Aluguel"));
		assertTrue(irpf.containsRendimento("Dividendos"));
	}
	

}
