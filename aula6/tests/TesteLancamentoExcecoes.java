package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Triangulo;
import exception.MedidaInvalidaException;
import exception.TrianguloInvalidoException;

@RunWith(Parameterized.class)
public class TesteLancamentoExcecoes {

	int a, b, c;
	
	public TesteLancamentoExcecoes(int a, int b, int c) {
		this.a = a; 
		this.b = b; 
		this.c = c;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{7, 3, 1},
			{5, 8, 2}
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test(expected = TrianguloInvalidoException.class)
	@Category({TesteFuncional.class, TesteExcecao.class})
	public void test() throws TrianguloInvalidoException, MedidaInvalidaException {
		Triangulo t1 = new Triangulo(a, b, c);
		assertFalse(t1.ehTriangulo());
	}
	
}
