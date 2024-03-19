package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Cadastro;
import app.MatriculaInvalidaException;
import app.NomeEmBrancoException;

public class CadastrarAlunoFeliz {

	private Cadastro c;

	@Before
	public void setup() {
		c = new Cadastro();
	}
	
	
	@Test
	@Category(Funcional.class)
	public void testCadastrarAluno() throws NomeEmBrancoException, MatriculaInvalidaException {
		assertTrue(c.cadastrarAluno("Andre", 13));
		assertEquals(1, this.c.numeroAlunos());
		System.out.println(this.c + ": " + this.c.numeroAlunos());
	}
	
	@Test(timeout = 1010)
	@Category(Funcional.class)
	public void testCadastrarOutroAluno() throws NomeEmBrancoException, MatriculaInvalidaException {
		assertTrue(c.cadastrarAluno("Miguel", 14));
		assertEquals(1, this.c.numeroAlunos());
		System.out.println(this.c + ": " + this.c.numeroAlunos());
	}

}








