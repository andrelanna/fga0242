package exemplo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TesteDivisao {

	Calculadora c;
	@Before
	public void setup() {
		c = new Calculadora();
	}
	
	@Test
	@Category(TesteFuncional.class)
	public void testSimplesDivisaoInteiros() throws DivisaoPorZeroException, InterruptedException {
		assertEquals(2, c.divisao(5,2));
	}
	
	@Test
	@Category(TesteFuncional.class)
	public void testSimplesDivisaoInteiros2() throws DivisaoPorZeroException, InterruptedException {
		assertEquals(-2, c.divisao(5,-2));
	}
	
	@Test(expected = ArithmeticException.class)
	@Category(TesteDeExcecao.class)
	public void testSimplesDivisaoPorZero() throws DivisaoPorZeroException, InterruptedException {
		c.divisao(5, 0);
	}
	
	@Test(timeout = 1500)
	public void testDivisaoLenta() throws DivisaoPorZeroException, InterruptedException {
		assertEquals(2, c.divisao(4, 2));
	}

}
