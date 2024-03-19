package tst;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Cadastro;

public class TesteCriacaoCadastro {

	private Cadastro c;

	@Test
	@Category(TesteFeliz.class)
	public void testInstanciacaoCadastro() {
		c = new Cadastro();
		assertNotNull(c); 
		assertTrue(c.existemAlunos());
		assertEquals(0, c.getNumeroAlunos());
	}

}
