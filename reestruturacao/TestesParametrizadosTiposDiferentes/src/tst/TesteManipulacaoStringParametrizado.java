package tst;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.ManipuladorString;

@RunWith(Parameterized.class)
public class TesteManipulacaoStringParametrizado {

	private int qtde;
	private char op;
	private String fonte;
	private String resultadoEsperado;
	
	private ManipuladorString m; 
	
	@Before
	public void setup() {
		m = new ManipuladorString(fonte);
	}

	public TesteManipulacaoStringParametrizado(
			int qtde, 
			char op, 
			String fonte, 
			String resultaEsperado) {
		this.qtde = qtde; 
		this.op = op; 
		this.fonte = fonte; 
		this.resultadoEsperado = resultaEsperado;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		/* 
		 * tuplas de teste
		 * {3, 'y', "as", "asasas"}, 
		 * {2, 'x', "asdf", "df"}, 
		 * {3, 'x', "asdf", "f"}
		 */
		Object[][] tuplas = new Object[][] {
			{3, 'y', "as", "asasas"}, 
			{2, 'x', "asdf", "df"}, 
			{3, 'x', "asdf", "f"}, 
			{4, 'y', "asd", "asdasdasdasd"}
		};
		return Arrays.asList(tuplas);
	}
	
	@Test
	public void test() {
		String resultadoObtido = m.executar(qtde, op);
		assertTrue(resultadoObtido.equalsIgnoreCase(resultadoEsperado));
	}

}
