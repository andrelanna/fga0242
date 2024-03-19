package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Aluno;
import app.Cadastro;
import exceptions.AlunoCadastradoException;
import exceptions.DadosInvalidosException;

public class TstCadastroAlunos {
	
	private Cadastro c;
	private Aluno a;
	private Aluno b;

	@Before
	public void setup() {
		c = new Cadastro();
	}
	
	@Test(timeout = 500)
	@Category(TesteFeliz.class)
	public void testCadastroUmAluno() throws DadosInvalidosException, AlunoCadastradoException {
		a = new Aluno("Andre", 13); 
		
		assertTrue(c.cadastrarAluno(a));
		assertEquals(1, c.getNumeroAlunos());
	}
	
	@Test(timeout = 1000)
	@Category(TesteFeliz.class)
	public void testCadastrarDoisAlunos() throws DadosInvalidosException, AlunoCadastradoException {
		a = new Aluno("Andre", 13); 
		b = new Aluno("Miguel", 14);
		
		assertTrue(c.cadastrarAluno(a));
		assertTrue(c.cadastrarAluno(b));
		assertEquals(2, c.getNumeroAlunos());
	}
	
	@Test(expected = AlunoCadastradoException.class)
	@Category(TesteExcecao.class)
	public void testCadastrarAlunoDuplicado() throws DadosInvalidosException, AlunoCadastradoException {
		a = new Aluno("Andre", 13);
		
		assertTrue(c.cadastrarAluno(a));
		assertFalse(c.cadastrarAluno(a));
		assertEquals(1, c.getNumeroAlunos());
	}

}





