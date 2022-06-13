package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Calculadora;

/**
 * TestCase é um caso de teste, uma classe composta por vários testes. Em JUnit4
 * cada método de uma classe de teste anotado com @Test é um teste a
 * ser realizado.
 * 
 * O Runner de TestCase "varre" toda a classe de teste (TestCase) 
 * buscando por métodos anotados com @Test e, para cada método, 
 * o runner instancia um objeto de teste e executa apenas aquele método. 
 * Desse modo se um testcase tem 4 testes (4 métodos), serão instanciados
 * 4 objetos de testes diferentes.
 * 
 * @author andrelanna
 *
 */

public class TesteSomaInteiro {

	/**
	 * Referência dinâmica para o objeto alvo do teste. 
	 * Lembre-se: testar referências estáticas é mais difícil pois
	 * referências estáticas quebram a independência dos testes 
	 */
	Calculadora c; 
	
	/**
	 * Metodo que vai ser executado após a instanciacao de cada 
	 * objeto de teste.
	 */
	@Before
	public void setup() {
		c = new Calculadora();
	}
	
	/**
	 * Teste 
	 */
	@Test
	public void testSoma1() {
		System.out.println(this + " tst1");
		System.out.println(c + " calculadora");
		c.setOperando1(2);
		c.setOperando2(3);
		assertEquals(5, c.soma());
	}
	
	/**
	 * Teste 
	 */
	@Test
	public void testSoma2() {
		System.out.println(this + " tst2");
		System.out.println(c + " calculadora");
		c.setOperando1(-2);
		c.setOperando2(-3);
		assertEquals(-5, c.soma());
	}
	
	/**
	 * Teste 
	 */
	@Test
	public void testSoma3() {
		System.out.println(this + " tst3");
		System.out.println(c + " calculadora");
		c.setOperando1(2);
		c.setOperando2(0);
		assertEquals(2, c.soma());
	}
	
	/**
	 * Teste 
	 */
	@Test
	public void testSoma4() {
		System.out.println(this + " tst4");
		System.out.println(c + " calculadora");
		c.setOperando1(2);
		c.setOperando2(-2);
		assertEquals(0, c.soma());
	}

}
