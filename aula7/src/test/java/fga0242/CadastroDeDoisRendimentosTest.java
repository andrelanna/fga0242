package test.java.fga0242;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.java.fga0242.IRPF;

@RunWith(Parameterized.class)
public class CadastroDeDoisRendimentosTest {

	private IRPF irpf;
	private Object[][] rendimentos;
	private int totalRendimentos;

	/**
	 * {
	 *    {
	 *    	{
	 *    		{Salario, 9000}, 
	 *    		{Aluguel, 1000}
	 *    	}, 10000},  //tupla1 
	 *    {{{Salario, 9000}, {Dividendos, 2000}}, 11000}, 
	 *    {{{Salario, 9000}, {Aluguel, 1000}, {Dividendos, 2000}}, 12000}
	 * }
	 */
	
	public CadastroDeDoisRendimentosTest(Object[][] rendimentos, int totalRendimentos) {
		this.rendimentos = rendimentos; 
		this.totalRendimentos = totalRendimentos;
	}
	
	@Parameters
	public static List<Object[]> getParameters(){
		Object[] salario = new Object[] {"Salario", 9000};
		Object[] aluguel = new Object[] {"Aluguel", 1000};
		Object[] dividendos = new Object[] {"Dividendos", 2000};
		
		Object[][] resposta = new Object[][] {
			{new Object[][] {
				salario, 
				aluguel}, 10000}, 
			{new Object[][] {
				salario, 
				dividendos}, 11000},
			{new Object[][] {
				salario, 
				aluguel, 
				dividendos}, 12000}
		};
		
		return Arrays.asList(resposta);
	}
	
	
	@Before
	public void setup() {
		this.irpf = new IRPF();
	}
	
	@Test
	public void testeCadastrarRendimento() {
		for (Object[] o: rendimentos) {
			String nomeRendimento = (String) o[0];
			int valorRendimento = (int) o[1];
			
			irpf.cadastrarRendimento(nomeRendimento, valorRendimento);
			assertTrue(irpf.containsRendimento(nomeRendimento));
		}
		
		
		assertEquals(this.totalRendimentos, irpf.getTotalRendimentos(), 0f);
	}
	
}
