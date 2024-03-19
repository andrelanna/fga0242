package dependenciaTestes;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TstDependenciaTest {

	@BeforeClass
	public static void setup() {
		Calculadora.a = 3; 
		Calculadora.b = -3; 
		Calculadora.c = 0;
	}
	
	@Test
	public void test1() {
		assertTrue(Calculadora.m1() == 0);
	}
	
	@Test
	public void test2() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(Calculadora.m2() <= 0);
	}
	
	@Test
	public void test3() {
		assertTrue(Calculadora.m3() > 0);
	}

}
