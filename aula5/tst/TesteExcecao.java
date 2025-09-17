package tst;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Triangulo;
import exceptions.NaoEhTrianguloException;

@RunWith(Parameterized.class)
public class TesteExcecao {

	//Criar os atributos do objeto de teste
	int a, 
	    b, 
	    c;
	Triangulo t;
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{4, 5, 12},
			{2, 3, 6},
			{1, 1, 3}
		};
		return Arrays.asList(parametros);
	}
	
	public TesteExcecao(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Before
	public void setup() {
		t = new Triangulo(a, b, c);
	}
	
	@Test(expected=NaoEhTrianguloException.class)
	@Category(Excecao.class)
	public void test() throws NaoEhTrianguloException {
		t.ehTriangulo();
	}

}
