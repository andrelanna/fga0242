package tst;

import static org.junit.Assert.assertEquals;

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
public class AreaPerimetro {

	//Parametros (ou atributos) do objeto de teste
	private int a, 
	            b, 
	            c, 
	            areaEsperada, 
	            perimetroEsperado; 
	private boolean ehTriangulo;
	
	private Triangulo t;

	
	@Before
	public void setup() {
		t = new Triangulo(a, b, c);
	}
	
	@Parameters
	public static Collection<Object[]> getParameters(){
		Object[][] parametros = new Object[][] {
			{3, 4, 5, 6, 12, true},
			{2, 3, 4, 3, 9, true},
			{5, 6, 7, 15, 18, true}
		};
		return Arrays.asList(parametros);
	}
	
	//Construtor alternativo para instanciar o objeto de teste
	public AreaPerimetro(int a, int b, int c, int areaEsperada, int perimetroEsperado, boolean ehTriangulo) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.areaEsperada = areaEsperada;
		this.perimetroEsperado = perimetroEsperado;
		this.ehTriangulo = ehTriangulo;
	}
	
	@Test
	@Category(Funcional.class)
	public void testArea() {
		assertEquals(areaEsperada, t.calcularArea());
	}

	
	@Test
	@Category(Funcional.class)
	public void testPerimetro() {
		assertEquals(perimetroEsperado, t.calcularPerimetro());
	}

	@Test
	@Category(Funcional.class)
	public void testEhTriangulo() throws NaoEhTrianguloException {
		assertEquals(ehTriangulo, t.ehTriangulo());
	}
	
}






