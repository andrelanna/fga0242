package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.IRPF;

@RunWith(Parameterized.class)
public class TstCadastroRendimentos {

	private IRPF irpf;
	private Object[] rendimentos;
	private float rendTribEsperado;
	private float totalRendEsperado;

	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	/**
	 * Método que retorna o conjunto de parametros (tuplas de teste
	 * @return tuplas de teste
	 */
	@Parameters
	public static List<Object[]> getParameters() {
		Object[] salario = new Object[] {"Salario", 10000f, true},
				 aluguel = new Object[] {"Aluguel", 3000f, true},
				 bolsa   = new Object[] {"Bolsa pesquisa", 2000f, false};
		
		Object[][] tuplas = new Object[][] {
			{new Object[]{salario}, 10000f, 10000f}, 
			{new Object[]{salario, aluguel}, 13000f, 13000f}, 
			{new Object[]{salario, aluguel, bolsa}, 13000f, 15000f}
		};
		return Arrays.asList(tuplas);
	}
	
	public TstCadastroRendimentos(Object[] rendimentos, 
								  float rendTribEsperado, 
								  float totalRendEsperado) {
		this.rendimentos = rendimentos;
		this.rendTribEsperado = rendTribEsperado;
		this.totalRendEsperado = totalRendEsperado;
	}
	
	@Test
	public void testCadastroRendimentos() {
		testarCadastroRendimentos();
		assertEquals(rendTribEsperado, irpf.getTotalRendimentosTributaveis(), 0f);
	}

	private void testarCadastroRendimentos() {
		for (Object r: rendimentos) {
			Object[] x = (Object[])r;
			String nome = (String) x[0];
			float valor = (float) x[1];
			boolean ehTributavel = (boolean) x[2];
			assertTrue(irpf.cadastrarRendimento(nome, valor, ehTributavel));
		}
	}
	
	@Test
	public void TestTotalRendimentos() {
		testarCadastroRendimentos();
		assertEquals(totalRendEsperado, irpf.getTotalRendimentos(), 0f);
	}
	
	
	
	
//	@Test
//	public void testCadastroUmRendimentoTributavel() {
//		boolean cadastrou = irpf.cadastrarRendimento("Salario", 10000f, true);
//		assertTrue(cadastrou);
//		assertEquals(10000f, irpf.getTotalRendimentosTributaveis(), 0f);
//	}
//	
//	@Test 
//	public void testCadastroDoisRendimentosTributaveis() {
//		assertTrue(irpf.cadastrarRendimento("Salario", 10000f, true));
//		assertTrue(irpf.cadastrarRendimento("Aluguel", 3000f, true));
//		assertEquals(13000f, irpf.getTotalRendimentosTributaveis(), 0f);
//	}
//
//	@Test
//	public void TestCadastroVariosRendimentos() {
//		assertTrue(irpf.cadastrarRendimento("Salario", 10000f, true));
//		assertTrue(irpf.cadastrarRendimento("Aluguel", 3000f, true));
//		assertTrue(irpf.cadastrarRendimento("Bolsa pesquisa", 2000f, false));
//		assertEquals(13000f, irpf.getTotalRendimentosTributaveis(), 0f);
//	}
	
	
}







