package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Calculadora;

public class TesteSubtracao {

	private Calculadora c;

	@Before
	public void setup() {
		c = new Calculadora(); 
	}
	
	@Test
	public void test6() {
		c.setOp1(3);
		c.setOp2(3);
		assertEquals(0, c.subtracao());
		System.out.println("test6: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test7() {
		c.setOp1(-3);
		c.setOp2(-3);
		assertEquals(0, c.subtracao());
		System.out.println("test7: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test8() {
		c.setOp1(3);
		c.setOp2(0);
		assertEquals(3, c.subtracao());
		System.out.println("test8: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test9() {
		c.setOp1(-3);
		c.setOp2(2);
		assertEquals(-5, c.subtracao());
		System.out.println("test9: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test10() {
		c.setOp1(3);
		c.setOp2(-2);
		assertEquals(5, c.subtracao());
		System.out.println("test10: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}

}
