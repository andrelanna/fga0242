package tests;

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
public class TestePensaoAlimenticia {

	IRPF irpf;
	
	float pensoesAlimenticias[]; 
	float deducaoEsperada;
	
	
	public TestePensaoAlimenticia(float[] pensoesAlimenticias, float totalDeducao) {
		this.pensoesAlimenticias = pensoesAlimenticias;
		this.deducaoEsperada = totalDeducao;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] resposta = new Object[][] {
			{new float[]{}, 0f}, //sem pensoes alimenticias!
			{new float[]{500f}, 500f}, 
			{new float[]{500f, 250f}, 750f},
			{new float[]{500f, 250f, 250f}, 1000f}
		};
		
		return Arrays.asList(resposta);
	}
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	
	@Test
	public void testDeducoesPorPensaoAlimenticia() {
		for(float pa : this.pensoesAlimenticias) { 
			irpf.cadastrarDeducaoPensaoAlimenticia(pa);
		}
		assertEquals(this.deducaoEsperada, irpf.getDeducaoPensaoAlimenticia(), 0f);
	}
}

















