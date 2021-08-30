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
public class TestDeducaoPrevidenciaOficial {

	float contribuicao, 
	      respostaEsperada; 
	
	
	public TestDeducaoPrevidenciaOficial(float contribuicao, float respostaEsperada) {
		this.contribuicao = contribuicao; 
		this.respostaEsperada = respostaEsperada;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{600f, 600f}, 
			{500f, 500f}, 
			{300f, 300f}
		}; 
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testCadastroPO() {
		IRPF irpf = new IRPF(); 
		irpf.cadastrarPrevidenciaOficial(contribuicao);
		assertEquals(respostaEsperada, irpf.getPrevidenciaOficial(), 0f);
	}
}
