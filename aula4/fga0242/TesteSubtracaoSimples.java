
package fga0242;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TesteSubtracaoSimples {

	Calculadora c; 
	
	@Before
	public void setup() {
		c = new Calculadora();
	}
	
	
	@Test
	public void test1() { //3-2
		assertEquals(1, c.subtracao(3,2));
	}
	
	@Test
	public void test2() { //2-3
		assertEquals(-1, c.subtracao(2,3));
	}
	
	@Test
	public void test3() { //3-(-2)
		assertEquals(5, c.subtracao(3,-2));
	}
	
	@Test
	public void test4() { //2-(-3)
		assertEquals(5, c.subtracao(2,-3));
	}
	
	@Test
	public void test5() { //-3-(-2)
		assertEquals(-1, c.subtracao(-3,-2));
	}
	


}
