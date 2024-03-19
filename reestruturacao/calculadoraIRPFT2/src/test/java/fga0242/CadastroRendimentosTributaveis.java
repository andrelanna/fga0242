package fga0242;

import static org.junit.Assert.*;

import org.junit.Test;

public class CadastroRendimentosTributaveis {

	@Test
	public void testCadastroSalario() {
		RendimentosTributaveis rendimentos = RendimentosTributaveis.getInstance();
		assertTrue(rendimentos.adicionarRendimento("Salario", 10000));
		
		assertNotNull(rendimentos); 
		assertTrue(rendimentos.getRendimento().equalsIgnoreCase("Salario"));
		assertEquals(10000, rendimentos.getValorRendimentos());
	}
	
	@Test 
	public void testCadastroAluguel() {
		RendimentosTributaveis rendimentos = RendimentosTributaveis.getInstance();
		assertTrue(rendimentos.adicionarRendimento("Aluguel", 5000));
		
		assertNotNull(rendimentos); 
		assertTrue(rendimentos.getRendimento().equalsIgnoreCase("Aluguel"));
		assertEquals(5000, rendimentos.getValorRendimentos());
	}
	
	
	@Test
	public void testCadastroSalarioAluguel() {
		RendimentosTributaveis rendimentos = RendimentosTributaveis.getInstance();
		assertTrue(rendimentos.adicionarRendimento("Salario", 10000));
		
		assertTrue(rendimentos.getRendimento().equalsIgnoreCase("Salario"));
		assertEquals(10000, rendimentos.getValorRendimentos());

		assertTrue(rendimentos.adicionarRendimento("Aluguel", 5000));
		assertTrue(rendimentos.contains("Aluguel"));
		assertEquals(5000, rendimentos.getValorRendimento("Aluguel"));
		
		assertEquals(15000, rendimentos.getTotalRendimentos());
	}
	
	@Test
	public void testCadastrSalarioHeranca() {
		RendimentosTributaveis rendimentos = RendimentosTributaveis.getInstance();
		assertTrue(rendimentos.adicionarRendimento("Salario", 10000));
		
		assertTrue(rendimentos.getRendimento().equalsIgnoreCase("Salario"));
		assertEquals(10000, rendimentos.getValorRendimentos());
		
		assertTrue(rendimentos.adicionarRendimento("Heranca", 15000));
		assertTrue(rendimentos.contains("Heranca"));
		assertEquals(15000, rendimentos.getValorRendimento("Heranca"));
		
		assertEquals(25000, rendimentos.getTotalRendimentos());
	}
	
	@Test
	public void testCadastroInexistente() {
		RendimentosTributaveis rendimentos = RendimentosTributaveis.getInstance();
		
		assertNotNull(rendimentos);
		
		assertFalse(rendimentos.contains("Salario"));
		assertEquals(0, rendimentos.getValorRendimento("Salario"));
		assertEquals(0, rendimentos.getTotalRendimentos());
	}

}













