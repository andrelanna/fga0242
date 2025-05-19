package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Pessoa;

public class TstFiliacao {

	@Test
	@Category({Funcional.class})
	public void criarFiliacao() {
		Pessoa pai = Pessoa.getPessoa("Andre", "Lanna", "M");
		Pessoa mae = Pessoa.getPessoa("Maria", "Silva", "F");
		pai.casar(mae);
		
		Pessoa filho = Pessoa.getPessoa("Jose", "Silva Lanna", "M");
		boolean filiacao = pai.filiar(filho);
		
		assertTrue(filiacao); 
		assertEquals(pai, filho.getPai());
		assertEquals(mae, filho.getMae());
	}
	
	

}
