package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import app.IRPF;

@RunWith(Parameterized.class)
public class TestCadastroDependentes {

	private String[] dependentes; 
	private float respostaEsperada;
	
	public TestCadastroDependentes(String[] dependentes, float respostaEsperada) {
		this.dependentes = dependentes;
		this.respostaEsperada = (float)respostaEsperada;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] resposta = new Object[][] {
			{new String[] {"Ignacio Fernandez"}, 189.59f},
			{new String[] {"Ignacio Fernandez", 
					       "Hulk"}             , 379.18f},
			{new String[] {"Ignacio Fernandez", 
				           "Hulk", 
				           "Guilherme Arana"}  , 568.77f}, 
			{new String[] {}                   ,   0.00f}
		};
		
		return Arrays.asList(resposta);
	}
	
	@Test
	public void testCadastroUmDependente() {
		IRPF irpf = new IRPF();
		for (String d : this.dependentes) {
			irpf.cadastrarDependente(d);
		}
		assertEquals(this.respostaEsperada, irpf.getDeducaoDependentes(), 0);
	}
}
