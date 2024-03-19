package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Calculadora;

public class TesteSubtracaoInteiros {

	@Test
	@Category(InteirosPositivos.class)
	public void testSubtracaoInteirosPositivos() {
		System.out.println(this);
		assertEquals( 1, new Calculadora().subtracao(3, 2));
		assertEquals( 2, new Calculadora().subtracao(4, 2));
		assertEquals( 0, new Calculadora().subtracao(5, 5));
	}
	
	@Test
	@Category(InteirosNegativos.class)
	public void testSubtracaoInteirosNegativos() {
		System.out.println(this);
		assertEquals( -1, new Calculadora().subtracao(-3, -2));
		assertEquals( -2, new Calculadora().subtracao(-4, -2));
		assertEquals(  0, new Calculadora().subtracao(-5, -5));
	}
	
	@Test
	@Category(InteirosNulos.class)
	public void testSubtracaoInteirosComplementares() {
		System.out.println(this);
		assertEquals( -6, new Calculadora().subtracao(-3, 3));
		assertEquals( -8, new Calculadora().subtracao(-4, 4));
		assertEquals( -10, new Calculadora().subtracao(-5, 5));
	}
	
	@Test(timeout = 1000)
	@Category(InteirosNulos.class)
	public void testSubtracaoInteiroZero() {
		System.out.println(this);
		assertEquals( -3, new Calculadora().subtracao(-3, 0));
		assertEquals(  4, new Calculadora().subtracao(4, 0));
		assertEquals(  0, new Calculadora().subtracao(0, 0));
	}

}
