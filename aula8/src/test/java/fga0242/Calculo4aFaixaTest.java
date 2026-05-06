package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.fga0242.IRPF;

public class Calculo4aFaixaTest extends CalculoFaixaBaseTest{

	@Test
	public void test1() {
		assertEquals(913.63f, irpf.getOcupacao4aFaixa(), 0.01f);
		assertEquals(205.56f, irpf.getImposto4aFaixa(), 0.01f);
	}
	
	@Test
	public void test2() {
		irpf = new IRPF();
		irpf.cadastrarRendimento("Salario", 3951.05f);
		assertEquals(200f, irpf.getOcupacao4aFaixa(), 0.01f);
		assertEquals(45f, irpf.getImposto4aFaixa(), 0.01f);
	}
	
	@Test
	public void test3() {
		irpf = new IRPF();
		irpf.cadastrarRendimento("Salario", 4664.68f);
		assertEquals(913.63f, irpf.getOcupacao4aFaixa(), 0.01f);
		assertEquals(205.56f, irpf.getImposto4aFaixa(), 0.01f);
	}

}
