package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.IRPF;

@RunWith(Parameterized.class)
public class TestOutrasDeducoes {

	IRPF irpf;
	
	String nomesDeducoes[];
	float valoresDeducoes[];
	float totalEsperado;
	
	
	public TestOutrasDeducoes(String[] nomesDeducoes, 
			                  float[]  valoresDeducoes,
			                  float    totalEsperado) {
		this.nomesDeducoes = nomesDeducoes;
		this.valoresDeducoes = valoresDeducoes;
		this.totalEsperado = totalEsperado;
	}
	
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] resposta = new Object[][] {
			{new String[] {"Previdencia Privada"}, new float[]{500f}, 500f}, 
			{new String[] {"Funpresp"}, new float[]{500f}, 500f},
			{new String[] {"Parcela isenta por aposentadoria"}, new float[]{800f}, 800f},
			{new String[] {"Previdencia privada", "Funpresp"}, new float[]{500f, 600f}, 1100f}, 
			{new String[] {}, new float[] {}, 0f}
		};
		
		return Arrays.asList(resposta);
	}

	
	@Before 
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void testeOutrasDeducoes() {
		//cadastrar outras deducoes
		for (int i=0; i < this.nomesDeducoes.length; i++) {
			irpf.cadastrarOutraDeducao(this.nomesDeducoes[i], this.valoresDeducoes[i]);
		}
		
		//assercoes
		assertEquals(this.totalEsperado, irpf.getOutrasDeducoes(), 0f);
		
		for (int i=0; i < this.nomesDeducoes.length; i++) {
			assertTrue(irpf.possuiDeducao(this.nomesDeducoes[i]));
		}
	}
	
}














