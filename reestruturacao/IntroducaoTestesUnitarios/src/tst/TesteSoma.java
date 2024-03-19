package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Calculadora;

public class TesteSoma {

	private Calculadora c;

	@Before
	public void setup() {
		c = new Calculadora(); 
	}
	
	@Test
	public void test1() {
		c.setOp1(3);
		c.setOp2(3);
		assertEquals(6, c.soma());
		System.out.println("test1: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test2() {
		c.setOp1(-3);
		c.setOp2(-3);
		assertEquals(-6, c.soma());
		System.out.println("test2: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test3() {
		c.setOp1(3);
		c.setOp2(0);
		assertEquals(3, c.soma());
		System.out.println("test3: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test4() {
		c.setOp1(-3);
		c.setOp2(2);
		assertEquals(-1, c.soma());
		System.out.println("test4: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test5() {
		c.setOp1(3);
		c.setOp2(-2);
		assertEquals(1, c.soma());
		System.out.println("test5: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
}
