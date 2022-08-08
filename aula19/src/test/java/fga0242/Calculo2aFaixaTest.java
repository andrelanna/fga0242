package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import main.java.fga0242.IRPF;

public class Calculo2aFaixaTest extends CalculoFaixaBaseTest{


	@Test
	public void test1() {
		assertEquals(922.67f, irpf.getOcupacao2aFaixa(), 0.01f);
		assertEquals(69.21f, irpf.getImposto2aFaixa(), 0.01f);
	}
	
	@Test
	public void test2() {
		irpf = new IRPF(); 
		irpf.cadastrarRendimento("Salario", 2203.98f);
		assertEquals(300, irpf.getOcupacao2aFaixa(), 0.01f);
		assertEquals(22.50f, irpf.getImposto2aFaixa(), 0.01f);
	}

	@Test
	public void test3() {
		irpf = new IRPF	(); 
		irpf.cadastrarRendimento("Salario", 2826.65f);
		assertEquals(922.67, irpf.getOcupacao2aFaixa(), 0.01f);
		assertEquals(69.20f, irpf.getImposto2aFaixa(), 0.01f);
	}
}
