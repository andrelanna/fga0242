package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Calculadora;

public class TesteMultiplicacao {
	private Calculadora c;

	@Before
	public void setup() {
		c = new Calculadora(); 
	}
	
	@Test
	public void test11() {
		c.setOp1(3);
		c.setOp2(3);
		assertEquals(9, c.multiplicacao());
		System.out.println("test11: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test12() {
		c.setOp1(-3);
		c.setOp2(-3);
		assertEquals(9, c.multiplicacao());
		System.out.println("test12: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test13() {
		c.setOp1(3);
		c.setOp2(0);
		assertEquals(0, c.multiplicacao());
		System.out.println("test13: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test14() {
		c.setOp1(-3);
		c.setOp2(2);
		assertEquals(-6, c.multiplicacao());
		System.out.println("test14: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test15() {
		c.setOp1(3);
		c.setOp2(-2);
		assertEquals(-6, c.multiplicacao());
		System.out.println("test15: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}

}
