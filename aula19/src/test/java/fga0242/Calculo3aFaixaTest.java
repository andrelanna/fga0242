package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import main.java.fga0242.IRPF;

public class Calculo3aFaixaTest extends CalculoFaixaBaseTest{


	@Test
	public void test1() {
		assertEquals(924.40f, irpf.getOcupacao3aFaixa(), 0.01f);
		assertEquals(138.66f, irpf.getImposto3aFaixa(), 0.01f);
	}
	
	@Test
	public void test2() {
		irpf = new IRPF(); 
		irpf.cadastrarRendimento("Salario", 3226.65f);
		assertEquals(400f, irpf.getOcupacao3aFaixa(), 0.01f);
		assertEquals(60f, irpf.getImposto3aFaixa(), 0.01f);
	}

	@Test
	public void test3() {
		irpf = new IRPF	(); 
		irpf.cadastrarRendimento("Salario", 3751.05f);
		assertEquals(924.40, irpf.getOcupacao3aFaixa(), 0.01f);
		assertEquals(138.66f, irpf.getImposto3aFaixa(), 0.01f);
	}
}
