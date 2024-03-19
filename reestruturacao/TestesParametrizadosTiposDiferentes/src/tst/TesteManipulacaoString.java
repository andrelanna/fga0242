package tst;

import static org.junit.Assert.*;

import org.junit.Test;

import app.ManipuladorString;

public class TesteManipulacaoString {

	@Test
	public void test1() {
		int qtde = 3; 
		char op = 'y';
		String fonte = "as";
		String resultadoEsperado = "asasas";
		ManipuladorString m = new ManipuladorString(fonte);
		
		String resultadoObtido = m.executar(qtde, op);
		
		assertTrue(resultadoObtido.equalsIgnoreCase(resultadoEsperado));
	}
	
	@Test
	public void test2() {
		int qtde = 2; 
		char op = 'x';
		String fonte = "asdf";
		String resultadoEsperado = "df";
		ManipuladorString m = new ManipuladorString(fonte);
		
		String resultadoObtido = m.executar(qtde, op);
		
		assertTrue(resultadoObtido.equalsIgnoreCase(resultadoEsperado));
	}

	@Test
	public void test3() {
		int qtde = 3; 
		char op = 'x';
		String fonte = "asdf";
		String resultadoEsperado = "f";
		ManipuladorString m = new ManipuladorString(fonte);
		
		String resultadoObtido = m.executar(qtde, op);
		
		assertTrue(resultadoObtido.equalsIgnoreCase(resultadoEsperado));
	}
	
}








