package fga0242;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CadastroRendimentoTributaveisTest {

	RendimentosTributaveis insTest;
	
	@Before 
	public void setup() {
		insTest = null;
	}
	
	@Test
	public void testCadastroSalario() {
		insTest = RendimentosTributaveis.getInstance();
		assertNotNull(insTest);
		
		insTest.adicionarRendimento("Salario", 10000); 
		
		assertTrue(insTest.getTipoRendimento().equalsIgnoreCase("Salario"));
		assertEquals(10000, insTest.getValor());
		
		System.out.println("insTest: " + insTest);
	}
	
	
	@Test
	public void testCadastroAlugueis() {
		insTest = RendimentosTributaveis.getInstance();
		assertNotNull(insTest);

		insTest.adicionarRendimento("Aluguel", 5000);
		
		assertTrue(insTest.getTipoRendimento().equalsIgnoreCase("Aluguel"));
		assertEquals(5000, insTest.getValor());
		
		System.out.println("insTest: " + insTest);
	}
	
	@Test
	public void testeCadastroSalarioAluguel() {
		insTest = RendimentosTributaveis.getInstance();
		assertNotNull(insTest);
		
		insTest.adicionarRendimento("Salario", 10000);
		insTest.adicionarRendimento("Aluguel", 5000);
		
		
		assertTrue(insTest.containsRendimento("Salario"));
		assertEquals(10000, insTest.getValorRendimento("Salario"));
		
		assertTrue(insTest.containsRendimento("Aluguel"));
		assertEquals(5000, insTest.getValorRendimento("Aluguel"));
		
		assertEquals(15000, insTest.getValorTotal());
		
		System.out.println("insTest: " + insTest);
	}

}
