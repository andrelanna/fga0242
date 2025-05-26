package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteBaseDeCalculo {

	private IRPF irpf;
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}

	@Test
	public void testApenasUmRendimento() {
		irpf.criarRendimento("Salario", true, 10000);
		assertEquals(10000f, irpf.calcularBaseIRPF(), 0);
	}
	
	@Test
	public void testeRendimentoEContribuicaoPrevidenciaria() {
		irpf.criarRendimento("Salario", true, 10000);
		irpf.cadastrarContribuicaoPrevidenciaria(1000);
		irpf.cadastrarContribuicaoPrevidenciaria(500);
		assertEquals(8500f, irpf.calcularBaseIRPF(), 0);
	}
	
	@Test
	public void testeRendimentoEDependente() {
		irpf.criarRendimento("Salario", true, 10000);
		irpf.cadastrarDependente("Andre", "Filho");
		assertEquals(9810.41f, irpf.calcularBaseIRPF(), 0);
	}
	
	@Test
	public void testeRendimentoEPensaoAlimenticia() {
		irpf.criarRendimento("Salario", true, 10000);
		irpf.cadastrarDependente("Andre", "Filho");
		irpf.cadastrarPensaoAlimenticia("Andre", 1000);
		assertEquals(8810.41f, irpf.calcularBaseIRPF(), 0);
	}
	
	@Test
	public void testRendimentoEOutrasDeducoes() {
		irpf.criarRendimento("Salario", true, 10000);
		irpf.cadastrarDeducaoIntegral("Funpresp", 1000);
		irpf.cadastrarDeducaoIntegral("Previdencia Privada", 600);
		assertEquals(8400f, irpf.calcularBaseIRPF(), 0);
	}
	
	@Test
	public void testCompleto() {
		irpf.criarRendimento("Salario", true, 10000);
		irpf.cadastrarContribuicaoPrevidenciaria(1000);
		irpf.cadastrarDependente("Andre", "filho");
		irpf.cadastrarPensaoAlimenticia("Andre", 500);
		irpf.cadastrarDeducaoIntegral("Funpresp", 600);
		assertEquals(7710.41f, irpf.calcularBaseIRPF(), 0);
	}

}
