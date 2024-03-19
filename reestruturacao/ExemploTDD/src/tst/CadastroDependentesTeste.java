package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.IRPF;

@RunWith(Parameterized.class)
public class CadastroDependentesTeste {

	private IRPF irpf;
	private Object[] dependentes;
	private int numDepsEsperado;
	private float valDedEsperada;

	@Before
	public void setup() {
		irpf = new IRPF(); 
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[] d1 = new Object[] {new String("Miguel"), 2019, 3, 9};
		Object[] d2 = new Object[] {new String("Maria"), 2018, 4, 21};
		Object[] d3 = new Object[] {new String("Carlos"), 2017, 11, 21};
		
		Object[][] tuplas = new Object[][]{
			{new Object[] {d1}, 1, 189.59f}, 
			{new Object[] {d1, d2}, 2, 379.18f},
			{new Object[] {d1, d2, d3}, 3, 568.77f}
		};
		
		return Arrays.asList(tuplas);
	}
	
	public CadastroDependentesTeste(Object[] dependentes,
			                        int numDepsEsperado, 
			                        float valDedEsperada) {
		this.dependentes = dependentes;
		this.numDepsEsperado = numDepsEsperado;
		this.valDedEsperada = valDedEsperada;
	}
	
	
	@Test
	public void testCadastroDependentes() {
		for (int i = 0; i<dependentes.length; i++) {
			Object[] d = (Object[])dependentes[i];
			String nome = (String)d[0];
			int ano = (int) d[1];
			int mes = (int) d[2];
			int dia = (int) d[3];
			assertTrue(irpf.cadastrarDependente(nome, new Date(ano, mes, dia)));
		}
		assertEquals(numDepsEsperado, irpf.getNumDependentes());
		assertEquals(valDedEsperada, irpf.getDeducaoDependentes(), 0f);
	}
	
	
}









