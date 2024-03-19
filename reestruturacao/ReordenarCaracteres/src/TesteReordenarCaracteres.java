import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TesteReordenarCaracteres {

	private Ordenacao ordenacao;
	
	/**
	 * Atributos do objeto de teste
	 */
	String string; 
	int numCaracteresIguais; 
	
	
	/**
	 * Metodo que retorna parametros
	 */
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{"casa", 0}, 
			{"ovo", 1}, 
			{"banana", 0}
		};
		
		return Arrays.asList(parametros);
	}
	
	/**
	 * Construtor do objeto de teste
	 * @param string
	 * @param numCaracteresIguais
	 */
	public TesteReordenarCaracteres(String string, int numCaracteresIguais) {
		this.string = string;
		this.numCaracteresIguais = numCaracteresIguais;
	}

	@Test
	public void test() {
		ordenacao = new Ordenacao(string);
		assertEquals(numCaracteresIguais, ordenacao.ordenar());
	}
	
//	@Test
//	public void test() {
//		ordenacao = new Ordenacao("casa");
//		assertEquals(0, ordenacao.ordenar());
//	}
//	
//	@Test
//	public void test2() {
//		ordenacao = new Ordenacao("ovo");
//		assertEquals(1, ordenacao.ordenar());
//	}
//	
//	@Test
//	public void test3() {
//		ordenacao = new Ordenacao("banana");
//		assertEquals(0, ordenacao.ordenar());
//	}

}
