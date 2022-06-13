package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Calculadora;

public class TesteSomaInteiro {

	Calculadora c; 
	
	@Before
	public void setup() {
		c = new Calculadora();
	}
	
	@Test
	public void testSoma1() {
		System.out.println(this + " tst1");
		System.out.println(c + " calculadora");
		c.setOperando1(2);
		c.setOperando2(3);
		assertEquals(5, c.soma());
	}
	
	
	@Test
	public void testSoma2() {
		System.out.println(this + " tst2");
		System.out.println(c + " calculadora");
		c.setOperando1(-2);
		c.setOperando2(-3);
		assertEquals(-5, c.soma());
	}
	
	@Test
	public void testSoma3() {
		System.out.println(this + " tst3");
		System.out.println(c + " calculadora");
		c.setOperando1(2);
		c.setOperando2(0);
		assertEquals(2, c.soma());
	}
	
	@Test
	public void testSoma4() {
		System.out.println(this + " tst4");
		System.out.println(c + " calculadora");
		c.setOperando1(2);
		c.setOperando2(-2);
		assertEquals(0, c.soma());
	}

}
