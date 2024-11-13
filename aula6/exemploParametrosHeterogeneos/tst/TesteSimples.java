package exemploParametrosHeterogeneos.tst;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import exemploParametrosHeterogeneos.app.Aluno;

public class TesteSimples {

	/*
	 * Nome: Andre Lanna
	 * Matricula: 12/0149826
	 * Email: andrelanna@unb.br
	 * Formacao: Ciencia da Computacao
	 */
	
	Aluno a, b; 
	
	@Before
	public void setup() {
		a = new Aluno("Andre Lanna", 12, 0, 149826);
		a.addAtrib("email", "andrelanna@unb.br");
		a.addAtrib("formacao", "Ciencia da Computacao");
		b = new Aluno("Maria", 22, 1, 131313);
		b.addAtrib("email", "maria@unb.br");
		b.addAtrib("formacao", "Engenharia de Software");
	}
	
	@Test
	public void test() {
		assertNotNull(a);
		assertNotNull(a.getMatricula());
	}
	
	@Test
	public void testMatricula() {
		assertTrue("12/0149826".equalsIgnoreCase(a.getMatricula().getTxt()));
	}
	
	@Test
	public void testAtributos() {
		assertTrue("andrelanna@unb.br".equalsIgnoreCase(a.getAtrib("email")));
		assertTrue("Ciencia da Computacao".equalsIgnoreCase(a.getAtrib("formacao")));
	}
	
	@Test
	public void test2() {
		assertNotNull(b);
		assertNotNull(b.getMatricula());
	}
	
	@Test
	public void testMatricula2() {
		assertTrue("22/1131313".equalsIgnoreCase(b.getMatricula().getTxt()));
	}
	
	@Test
	public void testAtributos2() {
		assertTrue("maria@unb.br".equalsIgnoreCase(b.getAtrib("email")));
		assertTrue("Engenharia de Software".equalsIgnoreCase(b.getAtrib("formacao")));
	}

}
