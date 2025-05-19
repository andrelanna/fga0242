package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Pessoa;

public class CadastroPessoa {

	@Test
	@Category({Funcional.class})
	public void testInstanciacaoUmaPessoa() {
		Pessoa p = Pessoa.getPessoa("Andre", "Lanna", "M");
		assertNotNull(p);
		assertEquals(1, Pessoa.numPessoas());
		Pessoa p2 = Pessoa.getPessoa("Andre", "Lanna", "M");
		assertNotNull(p2);
		assertEquals(1, Pessoa.numPessoas());
	}
	
	@Test
	@Category({Funcional.class})
	public void pesquisarPessoa() {
		Pessoa.getPessoa("Andre", "Lanna", "M");
		Pessoa p = Pessoa.pesquisarPessoa("Andre", "Lanna");
		assertNotNull(p);
	}
	
	@Test
	@Category({Funcional.class})
	public void removerPessoa() {
		Pessoa.getPessoa("Andre", "Lanna", "M");
		assertEquals(1, Pessoa.numPessoas());
		assertTrue(Pessoa.removerPessoa("Andre", "Lanna"));
		assertEquals(0, Pessoa.numPessoas());
		assertFalse(Pessoa.removerPessoa("Andre", "Lanna"));
	}
	
	@Test
	@Category({Funcional.class})
	public void obterRaizes() {
		Pessoa pai = Pessoa.getPessoa("Andre", "Lanna", "M");
		Pessoa mae = Pessoa.getPessoa("Maria", "Silva", "F");
		Pessoa filho = Pessoa.getPessoa("Jose", "Martins", "M");
		
		pai.casar(mae);
		mae.filiar(filho);

		Pessoa[] raizes = Pessoa.getRaizes();
		assertEquals (2, raizes.length);
	}
}
