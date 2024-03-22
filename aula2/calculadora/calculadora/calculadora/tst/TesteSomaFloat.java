package calculadora.tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculadora.app.Calculadora;

public class TesteSomaFloat {

	Calculadora c; 
	
	@Before
	public void setup() {
		c = new Calculadora();
	}
	
	@Test
	public void testSoma1() {
		System.out.println(this + " tst1");
		System.out.println(c + " calculadora");
		c.setOperando1(2.0f);
		c.setOperando2(3.0f);
		assertEquals(5.0f, c.somaf(), 0);
	}
	
	
	@Test
	public void testSoma2() {
		System.out.println(this + " tst2");
		System.out.println(c + " calculadora");
		c.setOperando1(-2.0f);
		c.setOperando2(-3.0f);
		assertEquals(-5.0f, c.somaf(), 0);
	}
	
	@Test
	public void testSoma3() {
		System.out.println(this + " tst3");
		System.out.println(c + " calculadora");
		c.setOperando1(2.0f);
		c.setOperando2(0.0f);
		assertEquals(2.0f, c.somaf(), 0);
	}
	
	@Test
	public void testSoma4() {
		System.out.println(this + " tst4");
		System.out.println(c + " calculadora");
		c.setOperando1(2.0f);
		c.setOperando2(-2.0f);
		assertEquals(0.0f, c.somaf(), 0);
	}

}
