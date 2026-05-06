package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.fga0242.IRPF;

public class CalculoTotalImposto extends CalculoFaixaBaseTest{

	@Test
	public void test1() {
		assertEquals(7810.41f, irpf.getTotalFaixaBaseDeCalculo(), 0.01f);
		assertEquals(1278.50f, irpf.getTotalImposto(), 0.01f);
	}
	
	@Test
	public void test2() {
		irpf = new IRPF();
		irpf.cadastrarRendimento("Salario", 4864.68f);
		assertEquals(4864.68f, irpf.getTotalFaixaBaseDeCalculo(), 0.01f);
		assertEquals(468.42f, irpf.getTotalImposto(), 0.01f);
	}
	
	@Test
	public void test3() {
		irpf = new IRPF();
		irpf.cadastrarRendimento("Salario", 10000f);
		assertEquals(10000f, irpf.getTotalFaixaBaseDeCalculo(), 0.01f);
		assertEquals(1880.64f, irpf.getTotalImposto(), 0.01f);
	}

}
