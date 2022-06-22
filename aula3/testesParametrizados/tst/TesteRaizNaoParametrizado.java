package testesParametrizados.tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import testesParametrizados.app.Calculadora;

public class TesteRaizNaoParametrizado {

	private Calculadora c;

	@Before
	public void setup() {
		c = new Calculadora();
	}
	
	@Test
	public void test() {
		c.setOperando1(5);
		assertEquals(2.23, c.raizQuadrada(), 0.007);
	}
	
	@Test
	public void test2() {
		c.setOperando1(8);
		assertEquals(2.82, c.raizQuadrada(), 0.009);
	}

}
