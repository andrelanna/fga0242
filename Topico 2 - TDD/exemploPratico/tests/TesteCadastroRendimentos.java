package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import app.IRPF;

@RunWith(Parameterized.class)
public class TesteCadastroRendimentos {
	
	/**
	 * Atributos do objeto de teste
	 */
	private float salario[],
	              resultadoEsperado;
	private IRPF irpf;
	
	/**
	 * Metodo construtor alternativo do objeto de teste 
	 * @param salario salario informado
	 * @param resultadoEsperado valor de retorno esperado da unidade 
	 */
	public TesteCadastroRendimentos(Object salario[], float resultadoEsperado) {
		
		//criar o vetor salario do objeto de teste com o numero de salarios informados
		this.salario = new float[salario.length];
		//inicializo o vetor salario do objeto de teste, com os valores informados pelos parametros
		for (int i=0; i<salario.length; i++) {
			this.salario[i] = (float)salario[i];
		}
		
		this.resultadoEsperado = resultadoEsperado;
	}
	
	/**
	 * Método que retorne o conjunto de parametros de teste
	 */
	@Parameters
	public static Collection<Object[]> galoDoido() {
		Object[][] parametros = new Object[][]{
			{new Object[]{3000f, 2000f}, 5000f}, //conjunto de valores - parametros
			{new Object[]{1000f, 3000f}, 4000f}, //conjunto de valores - parametros
			{new Object[]{1000f, 1000f, 1000f}, 3000f}, //
			{new Object[]{6000f}, 6000f}, 
			{new Object[]{7000f}, 7000f}
		};
		
		return Arrays.asList(parametros);
	}
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void testCadastroSalario() {
		
		for (float s : this.salario) {
			irpf.cadastrarSalario(s);
		}
		assertEquals(resultadoEsperado, irpf.getSalario(), 0);
	}
	
}
