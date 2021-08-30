package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteTotalDeducoes extends TesteDeducaoGenerico{

	/**
	 * {
	 *   {previdOficial, {"depend1", "depend2"}, {pens1, pens2, pens3}, {nomeDedud1, nomeDedud2}, {valDedud1, valorDedud2}, totalEsperado},
	 *   {}, 
	 *   {}
	 * }
	 */
	
	@Test
	public void test1() {
		irpf.cadastrarPrevidenciaOficial(500f);
		irpf.cadastrarOutraDeducao("Funpresp", 600f);
		irpf.cadastrarDependente("Ignacio Fernandez");
		
		assertEquals(1289.59f, irpf.getTotalDeducoes(), 0);
	}

	@Test
	public void test2() {
		irpf.cadastrarPrevidenciaOficial(500f);
		irpf.cadastrarOutraDeducao("Funpresp", 600f);
		irpf.cadastrarDeducaoPensaoAlimenticia(300f);
		irpf.cadastrarDependente("Ignacio Fernandez");
		
		assertEquals(1589.59f, irpf.getTotalDeducoes(), 0);
	}
	
}
