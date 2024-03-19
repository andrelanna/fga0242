package exercicio2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestExercicio2 {

	private int l1;
	private int l2;
	private int l3;
	private boolean respEsperada;
	
	Triangulo t; 

	public TestExercicio2(int l1, int l2, int l3, boolean respEsperada) {
		this.l1 = l1;
		this.l2 = l2; 
		this.l3 = l3; 
		this.respEsperada = respEsperada;
	}
	
	@Before
	public void setup() {
		t = new Triangulo(l1, l2, l3);
		System.out.println(imprimir());
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parameters = new Object[][] {
			{3, 4, 5, true}, 
			{1, 5, 7, false}, 
			{5, 7, 8, true}, 
			{6, 3, 1, false}
		};
		
		return Arrays.asList(parameters);
	}
	
	@Test
	public void test() {
		assertEquals(t.ehTriangulo(), respEsperada);
	}
	
	public String imprimir() {
		String resposta = ""; 
		resposta += this +": \n";
		resposta += "l1 -> " + l1 + "\n";
		resposta += "l2 -> " + l2 + "\n";
		resposta += "l3 -> " + l3 + "\n";
		resposta += "t -> "  + t + "\n";
		resposta += "-------------";
		
		return resposta;
	}
	

}
