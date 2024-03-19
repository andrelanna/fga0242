package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Cadastro;

@RunWith(Parameterized.class)
public class TesteCadastro {

	String nome, 
	       sobrenome; 
	boolean resEsperado;
	
	Cadastro c;
	
	public TesteCadastro(String nome, String sobreNome, boolean resEsp) {
		this.nome = nome;  
		this.sobrenome = sobreNome;
		this.resEsperado = resEsp;
	}
	
	@Before
	public void setup() {
		c = new Cadastro();
	}
	
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] param1 = new Object[][] {{"Andre", "Lanna", true}, 
			                                {"Maria", "Celia", true}, 
			                                {"Andre", "Lanna", true}};
	    return Arrays.asList(param1);
	}
		
	@Test
	public void test() {
		boolean resposta = c.cadastrarPF(nome, sobrenome);
		assertEquals(resposta, resEsperado);
		System.out.println(this);
	}


}
