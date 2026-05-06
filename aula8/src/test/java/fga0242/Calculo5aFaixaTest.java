package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.fga0242.IRPF;

public class Calculo5aFaixaTest extends CalculoFaixaBaseTest{

	@Test
	public void test1() {
		assertEquals(3145.73f, irpf.getOcupacao5aFaixa(), 0.01f);
		assertEquals(865.07f, irpf.getImposto5aFaixa(), 0.01f);
	}
	
	@Test
	public void test2() {
		irpf = new IRPF();
		irpf.cadastrarRendimento("Salario", 4864.68f);
		assertEquals(200f, irpf.getOcupacao5aFaixa(), 0.01f);
		assertEquals(55f, irpf.getImposto5aFaixa(), 0.01f);
	}
	
	@Test
	public void test3() {
		irpf = new IRPF();
		irpf.cadastrarRendimento("Salario", 10000f);
		assertEquals(5335.32f, irpf.getOcupacao5aFaixa(), 0.01f);
		assertEquals(1467.21f, irpf.getImposto5aFaixa(), 0.01f);
	}

}
