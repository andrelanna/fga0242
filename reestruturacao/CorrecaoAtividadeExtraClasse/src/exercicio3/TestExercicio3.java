package exercicio3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestExercicio3 {

	String texto, 
	       comando, 
	       argumento;
	List<String> respEsperada;
	
	EditorTexto et; 
	
	public TestExercicio3(String texto, String comando, String argumento, List<String> respEsperada) {
		this.texto = texto; 
		this.comando = comando;
		this.argumento = argumento;
		this.respEsperada = respEsperada;
	}
	
	@Before
	public void setup() {
		et = new EditorTexto(texto, comando, argumento);
	}
	
	@Parameters
	public static Collection<Object[]> getParameters(){
		//TUPLA1
		LinkedList<String> r = new LinkedList<String>();
		r.add("Andre");
		Object[] tupla1 = new Object[] {
		     "Andre Lanna", "5l", "0", r
		};
		
		//TUPLA1
		LinkedList<String> r2 = new LinkedList<String>();
		r2.add("Andre");
		r2.add("Lanna");
		Object[] tupla2 = new Object[] {
				"Andre Lanna", "split", " ", r2
		};
		
		//TUPLA4
		LinkedList<String> r4 = new LinkedList<String>();
		r4.add("A");
		r4.add("dre La");
		r4.add("");
		r4.add("a");
		Object[] tupla4 = new Object[] {
				"Andre Lanna", "split", "n", r4
		};
		
		
		Object[][] resposta = new Object[][] {
			tupla1, 
			tupla2, 
			tupla4
		};
		
		return Arrays.asList(resposta);
	}
	
	@Test
	public void test() {
		List<String> resposta = et.computar(); 
		for (int i=0; i<resposta.size(); i++) {
			String elemento = resposta.get(i);
			assertTrue(elemento.equalsIgnoreCase(respEsperada.get(i)));
		}
	}

}
