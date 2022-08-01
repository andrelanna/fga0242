package test.java.fga0242;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.java.fga0242.IRPF;


/**
 * Triangulacao de testes através de testes parametrizados 
 * @author andrelanna
 *
 */
@RunWith(Parameterized.class)
public class CadastroDeRendimentosTest {

	IRPF irpf;
	private String nomeRendimento;
	private int valorRendimento;
	
	/**
	 * Retorna o conjunto de parâmetros do teste
	 * @return parametros do teste como um array
	 */
	@Parameters
	public static List<Object[]> getParameters() {
		Object[][] parameters = new Object[][] {
			{"Salario", 9000},
			{"Aluguel", 1000},
			{"Dividendos", 2000}
		};
		
		return Arrays.asList(parameters);
	}
	
	public CadastroDeRendimentosTest(String nomeRendimento, int valorRendimento) {
		this.nomeRendimento = nomeRendimento;
		this.valorRendimento = valorRendimento;
	}
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	
	@Test
	public void testCadastroDeUmRendimento() {
		float totalRendimentos = irpf.cadastrarRendimento(nomeRendimento, valorRendimento);
		assertEquals(valorRendimento, totalRendimentos, 0f);
		assertTrue(irpf.getNomeRendimento().equalsIgnoreCase(nomeRendimento));
		assertEquals(valorRendimento, irpf.getTotalRendimentos(), 0f);
	}
}
