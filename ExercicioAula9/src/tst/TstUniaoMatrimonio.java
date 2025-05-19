package tst;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Pessoa;

public class TstUniaoMatrimonio {

	@Category({Funcional.class})
	@Test
	public void associacaoMatrimonial() {
		Pessoa p1 = Pessoa.getPessoa("Andre", "Lanna", "M");
		Pessoa p2 = Pessoa.getPessoa("Maria", "Silva", "M");
		assertTrue(p1.casar(p2));
		assertEquals(p2, p1.getConjuge());
		assertEquals(p1, p2.getConjuge());
	}
	
	@Category({Funcional.class})
	@Test
	public void naoAssociacaoMatrimonial() {
		Pessoa p1 = Pessoa.getPessoa("Andre", "Lanna", "M");
		Pessoa p2 = Pessoa.getPessoa("Maria", "Silva", "M");
		p1.casar(p2);
		Pessoa p3 = Pessoa.getPessoa("Jose", "Martins", "M");
		assertFalse(p3.casar(p2));
	}

}
