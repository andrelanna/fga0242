package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Cadastro;
import app.MatriculaInvalidaException;
import app.NomeEmBrancoException;

public class CadastrarAlunoInvalido {

	private Cadastro c;

	@Before
	public void setup() {
		this.c = new Cadastro(); 
	}
	
	@Test(expected = NomeEmBrancoException.class)
	@Category({Excecao.class, Funcional.class})
	public void testCadastrarAlunoSemNome() throws NomeEmBrancoException, MatriculaInvalidaException {
		assertFalse(c.cadastrarAluno("", 13));
	}
	
	@Test(expected = MatriculaInvalidaException.class)
	@Category(Excecao.class)
	public void testCadastrarAlunoMatriculaInvalida() throws NomeEmBrancoException, MatriculaInvalidaException {
		assertFalse(c.cadastrarAluno("Andre", 0));
	}
	

}








