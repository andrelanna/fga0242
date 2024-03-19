package tst;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import app.IRPF;

@RunWith(Parameterized.class)
public class CadastroDeducaoPrevidenciaOficial {

	private IRPF irpf;
	private float[] deducoes;
	private float totalEsperado;

	@Before
	public void setup() {
		irpf = new IRPF(); 
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] tuplas = new Object[][] {
			{new float[] {1000}, 1000f},
			{new float[] {1000, 500}, 1500f}, 
			{new float[] {1000, 500, 300}, 1800f}
		};
		
		return Arrays.asList(tuplas);
	}
	
	public CadastroDeducaoPrevidenciaOficial(float[] d, Object v) {
		
		deducoes = d;
		totalEsperado = (float) v;
	}
	
	@Test
	public void testCadastroPrevidenciaOficial() {
		for (Float f: deducoes) {
			assertTrue(irpf.cadastrarPrevidenciaOficial(f));
		}
		assertEquals(totalEsperado, irpf.getTotalPrevidenciaOficial(), 0f);
	}
}










