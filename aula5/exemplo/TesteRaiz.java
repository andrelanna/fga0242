package exemplo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TesteRaiz {

	Calculadora c; 
	
	@Before
	public void setup() {
		c = new Calculadora();
	}
	
	@Test
	@Category(TesteFuncional.class)
	public void testRaizQuadrada() throws InterruptedException {
		assertEquals(2, c.raiz(4, 2));
	}
	
	@Test
	@Category(TesteFuncional.class)
	public void testRaizCubic() throws InterruptedException {
		assertEquals(2, c.raiz(8, 3));
	}
	
	@Test(expected = RaizDeNegativoException.class)
	@Category(TesteDeExcecao.class)
	public void testRaizQuadradaBaseNegativa() throws InterruptedException {
		c.raiz(-4, 2);
	}
	
	@Test(timeout = 2100)
	public void testeRaizQuadradaLenta() throws InterruptedException {
		assertEquals(2, c.raiz(4, 2));
	}

}
