package testesParametrizados.tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import testesParametrizados.app.Calculadora;


public class TesteSomaNaoParametrizado {
	
	private Calculadora c;

	@Before
	public void setup() {
		c = new Calculadora();
	}
	
	@Test
	public void testeSoma1() {
		c.setOperando1(3);
		c.setOperando2(2);
		assertEquals(5, c.soma());
	}
	
	@Test
	public void testeSoma2() {
		c.setOperando1(3);
		c.setOperando2(-2);
		assertEquals(1, c.soma());
	}
	
	@Test
	public void testeSoma3() {
		c.setOperando1(-3);
		c.setOperando2(2);
		assertEquals(-1, c.soma());
	}
	
	@Test
	public void testeSoma4() {
		c.setOperando1(3);
		c.setOperando2(-3);
		assertEquals(0, c.soma());
	}
	
	@Test
	public void testeSoma5() {
		c.setOperando1(3);
		c.setOperando2(0);
		assertEquals(3, c.soma());
	}
}
