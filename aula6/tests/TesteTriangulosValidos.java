package tests;

import static org.junit.Assert.assertTrue;

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
public class TesteTriangulosValidos {

	/**
	 * Atributos do objeto de teste
	 */
	int a, b, c;
	
	/**
	 * Método que retorna o conjunto de parâmetros do teste
	 * @return
	 */
	@Parameters
	public static Collection<Object[]> getParameters() {
		//Definir o conjunto de parametros
		Object[][] parametros = new Object[][] {
			{3, 4, 5}, //tupla de testes
			{3, 6, 4}, //tupla de testes
			{5, 7, 9}  //tupla de testes
		};
		
		return Arrays.asList(parametros);
	}
	
	/**
	 * Construtor alternativo do objeto de testes
	 * @param a lado a
	 * @param b lado b
	 * @param c lado c
	 */
	public TesteTriangulosValidos(int a, int b, int c) {
		this.a = a; 
		this.b = b; 
		this.c = c;
	}
	

	@Test
	@Category(TesteFuncional.class)
	public void test() throws TrianguloInvalidoException, MedidaInvalidaException{
		Triangulo t1 = new Triangulo(a, b, c);
		assertTrue(t1.ehTriangulo());
	}
}






