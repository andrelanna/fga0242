package testes;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculadora.Calculadora;

@RunWith(Parameterized.class)
public class ParametrizedTestSoma {

	@Parameters
	public static Iterable getParameters() {
		Object[][] data = new Object[][] {
            {3, 2, 5},
            {-3, -2, -5},
            {3, 0, 3},
            {-3, 0, -3},
            {0, 0, 0},
            {-32768, 0, -32768},
            {-32768, 1, -32767},
            {32767, -1, 32766},
            {32767, 0, 32767}
        };
        
        return Arrays.asList(data);
	}
	
	private int num1;
	private int num2;
	private int resultado;
	
	public ParameterizedTestSoma(int num1, int num2, int resultado) {
		this.num1 = num1;
		this.num2 = num2;
		this.resultado = resultado;
	}
	
	@Test
	public void test() {
		int testeResultado = new Calculadora(num1, num2).sum();
		assertEquals(resultado, testeResultado);
	}
}
