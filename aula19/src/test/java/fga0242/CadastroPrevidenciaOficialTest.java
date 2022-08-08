package test.java.fga0242;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import main.java.fga0242.ValorInvalidoException;

@RunWith(Parameterized.class)
public class CadastroPrevidenciaOficialTest extends BaseTest{

	int contribuicoes[]; 
	int valorTotalContribuicoes;
	
	public CadastroPrevidenciaOficialTest(int contribuicoes[], int valorTotal) {
		this.contribuicoes = contribuicoes;
		this.valorTotalContribuicoes = valorTotal;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] resposta = new Object[][] {
			{new int[]{600}, 600}, 
			{new int[]{600, 400}, 1000}, 
			{new int[]{600, 400, 200}, 1200}
		};
		
		return Arrays.asList(resposta);
	}
	
	@Test
	public void testCadastroPrevidenciaOficial() throws ValorInvalidoException{
		for (int valor : contribuicoes) {
			irpf.cadastrarPrevidenciaOficial(valor);
		}
		assertEquals(valorTotalContribuicoes, irpf.getTotalContribuicoes());
	}
	
	

}










