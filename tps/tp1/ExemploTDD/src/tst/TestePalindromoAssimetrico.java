package tst;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Palindromo;

@RunWith(Parameterized.class)
public class TestePalindromoAssimetrico {

	Palindromo p; 

	String sentenca;
	boolean respostaEsperada; 

	@Parameters
	public static Collection<Object[]> getParameters(){
		Object[][] resposta = new Object[][] {
			{"1234 321", true}, 
			{"1234 3 21", true}, 
			{"1 234321", true},
			{"1 2 3 4 3 3 21", false}, 
			{"12 3 4 321", true} 
		};
		return Arrays.asList(resposta);
	}

	public TestePalindromoAssimetrico(String str, boolean r) {
		this.sentenca = str;
		this.respostaEsperada = r;
	}
	
	
	@Test
	public void test() {
		p = new Palindromo(sentenca);
		assertEquals(p.ehPalindromo(), respostaEsperada);
	}
}
