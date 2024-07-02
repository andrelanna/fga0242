package tst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Palindromo;
import app.PalindromoSimetrico;

@RunWith(Parameterized.class)
public class TestePalindromoSimetrico {

	private Palindromo p;
	private String str;
	private boolean respostaEsperada;

	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] parametros = new Object[][] {
			{"ovo", true},
			{"Andre", false},
			{"arara", true},
			{"amor a roma", true},
			{"Luiz", false},
			{"1234 321", true}, 
			{"1234 3 21", true}, 
			{"1 234321", true},
			{"1 2 3 4 3 3 21", false}, 
			{"12 3 4 321", true}, 
			{"Socorram me subi no onibus em Marrocos", true}
		};
		
		return Arrays.asList(parametros);
	}
	
	public TestePalindromoSimetrico (String str, boolean r) {
		this.str = str;
		this.respostaEsperada = r;
	}
	
	
	@Test
	public void test() {
		p = new Palindromo(str); 
		assertEquals(respostaEsperada, p.ehPalindromo());
	}
	
}
