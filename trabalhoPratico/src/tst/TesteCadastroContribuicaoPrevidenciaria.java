package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteCadastroContribuicaoPrevidenciaria {

	IRPF irpf; 
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void cadastrarUmaContribuicaoPrevidenciaria() {
		irpf.cadastrarContribuicaoPrevidenciaria(1000);
		assertEquals(1, irpf.getNumContribuicoesPrevidenciarias());
		assertEquals(1000f, irpf.getTotalContribuicoesPrevidenciarias(), 0f);
		assertEquals(1000f, irpf.getDeducao(), 0f);
	}
	
	
	@Test
	public void cadastrarDuasContribuicoesPrevidenciarias() {
		irpf.cadastrarContribuicaoPrevidenciaria(1000);
		irpf.cadastrarContribuicaoPrevidenciaria(500);
		assertEquals(2, irpf.getNumContribuicoesPrevidenciarias());
		assertEquals(1500f, irpf.getTotalContribuicoesPrevidenciarias(), 0f);
		assertEquals(1500f, irpf.getDeducao(), 0f);
	}
	
	@Test
	public void cadastrarTresContribuicoesPrevidenciarias() {
		irpf.cadastrarContribuicaoPrevidenciaria(1000);
		irpf.cadastrarContribuicaoPrevidenciaria(500);
		irpf.cadastrarContribuicaoPrevidenciaria(200);
		assertEquals(3, irpf.getNumContribuicoesPrevidenciarias());
		assertEquals(1700f, irpf.getTotalContribuicoesPrevidenciarias(), 0f);
		assertEquals(1700f, irpf.getDeducao(), 0f);
	}
	
	
}
