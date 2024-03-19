package tst;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Aluno;
import exceptions.DadosInvalidosException;

public class TesteCriacaoAluno {

	private Aluno a;

	@Test
	@Category(TesteFeliz.class)
	public void testInstanciacaoAluno() {
		try {
			a = new Aluno("Andre", 13);
		} catch (DadosInvalidosException e) {
			e.printStackTrace();
		}
		assertNotNull(a);
		assertNotNull(a.getNome());
		assertTrue(a.getNome().equalsIgnoreCase("Andre"));
		assertEquals(13, a.getMatricula());
	}
	
	@Test(expected = DadosInvalidosException.class)
	@Category(TesteExcecao.class)
	public void testInstanciacaoAlunoVazio() throws DadosInvalidosException {
		a = new Aluno(null, 13);
	}
	
	
	@Test(expected = DadosInvalidosException.class)
	@Category(TesteExcecao.class)
	public void testInstanciacaoAlunoVazio2() throws DadosInvalidosException {
		a = new Aluno("Andre", 0); 
	}

}











