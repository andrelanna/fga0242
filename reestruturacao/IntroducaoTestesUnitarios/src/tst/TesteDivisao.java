package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Calculadora;
import exception.DivisaoPorZeroException;

public class TesteDivisao {

	private Calculadora c;

	@Before
	public void setup() {
		c = new Calculadora(); 
	}
	
	@Test
	public void test16() throws DivisaoPorZeroException {
		c.setOp1(3);
		c.setOp2(3);
		assertEquals(1, c.divisao());
		System.out.println("test16: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test17() throws DivisaoPorZeroException {
		c.setOp1(-3);
		c.setOp2(-3);
		assertEquals(1, c.divisao());
		System.out.println("test17: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test(expected = DivisaoPorZeroException.class)
	public void test18() throws DivisaoPorZeroException {
		c.setOp1(3);
		c.setOp2(0);
		assertEquals(0, c.divisao());
		System.out.println("test18: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test19() throws DivisaoPorZeroException {
		c.setOp1(-3);
		c.setOp2(2);
		assertEquals(-1, c.divisao());
		System.out.println("test19: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}
	
	@Test
	public void test20() throws DivisaoPorZeroException {
		c.setOp1(3);
		c.setOp2(-2);
		assertEquals(-1, c.divisao());
		System.out.println("test20: " + this + "\n" + "Calculadora: " + c + "\n---\n");
	}


}
