package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteCalculoImposto {

	IRPF irpf; 
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void test1aFaixa() {
		irpf.criarRendimento("Salario", true, 2259.20f);
		float impostoDevido = irpf.calcularImposto();
		assertEquals(0, impostoDevido, 0);
		assertEquals(2259.20f, irpf.getBase1aFaixa(), 0f); 
		assertEquals(0f, irpf.getImposto1aFaixa(), 0f);
	}
	
	@Test
	public void test2aFaixa() {
		irpf.criarRendimento("Salario", true, 2826.65f);
		float impostoDevido = irpf.calcularImposto();
		assertEquals(42.55f, impostoDevido, 0.01f);
		assertEquals(567.45f, irpf.getBase2aFaixa(), 0.01f);
		assertEquals(42.55f, irpf.getImposto2aFaixa(), 0.01f);
	}
	
	@Test
	public void test3aFaixa() {
		irpf.criarRendimento("Salario", true, 3751.05f);
		float impostoDevido = irpf.calcularImposto();
		assertEquals(181.21f, impostoDevido, 0.01f);
		assertEquals(924.40f, irpf.getBase3aFaixa(), 0.01f);
		assertEquals(138.66f, irpf.getImposto3aFaixa(), 0.01f);
	}
	
	@Test
	public void test4aFaixa() {
		irpf.criarRendimento("Salario", true, 4664.68f);
		float impostoDevido = irpf.calcularImposto();
		assertEquals(386.78f, impostoDevido, 0.01f);
		assertEquals(913.63f, irpf.getBase4aFaixa(), 0.01f);
		assertEquals(205.57f, irpf.getImposto4aFaixa(), 0.01f);
	}
	
	@Test
	public void test5aFaixa() {
		irpf.criarRendimento("Salario", true, 10000f);
		float impostoDevido = irpf.calcularImposto();
		assertEquals(1853.99f, impostoDevido, 0.01f);
		assertEquals(5335.32f, irpf.getBase5aFaixa(), 0.01f);
		assertEquals(1467.21f, irpf.getImposto5aFaixa(), 0.01f);
	}

}
