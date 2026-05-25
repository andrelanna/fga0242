package fga0242;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculoImpostoTest {

	CadastroDeclaracoes cadDec;
	IDeclaracao dec; 
	
	@Before
	public void setup() {
		cadDec = CadastroDeclaracoes.obterInstancia();
		dec = cadDec.criarDeclaracao("Cidadão", "000.000.000-00");
	}
	
	@Test
	public void test1aFaixa() {
		dec.cadastrarRendimento("Salário", 2428.80f); 
		dec.cadastrarRendimento("Bolsa de estudo", 2000f);
		
		assertEquals(0, dec.calcularImposto(), 0.01f); 
		assertEquals(0, dec.impostoFaixa(1), 0.01f); 
		assertEquals(0, dec.impostoFaixa(2), 0.01f); 
		assertEquals(0, dec.impostoFaixa(3), 0.01f); 
		assertEquals(0, dec.impostoFaixa(4), 0.01f); 
		assertEquals(0, dec.impostoFaixa(5), 0.01f); 
		
		
	}
	
	@Test
	public void test2aFaixa() {
		dec.cadastrarRendimento("Salário", 2528.81f); 
		dec.cadastrarRendimento("Bolsa de estudo", 2000f);
		
		assertEquals(7.5f, dec.calcularImposto(), 0.01f); 
		assertEquals(0, dec.impostoFaixa(1), 0.01f); 
		assertEquals(7.5f, dec.impostoFaixa(2), 0.01f); 
		assertEquals(0, dec.impostoFaixa(3), 0.01f); 
		assertEquals(0, dec.impostoFaixa(4), 0.01f); 
		assertEquals(0, dec.impostoFaixa(5), 0.01f);
	}
	
	@Test
	public void test3aFaixa() {
		dec.cadastrarRendimento(Constantes.SALÁRIO, 2926.66f); 
		dec.cadastrarRendimento(Constantes.BOLSA_DE_ESTUDO, 2000f);
		
		assertEquals(44.83f, dec.calcularImposto(), 0.01f); 
		assertEquals(0, dec.impostoFaixa(5), 0.01f);
		assertEquals(0, dec.impostoFaixa(4), 0.01f); 
		assertEquals(15f, dec.impostoFaixa(3), 0.01f); 
		assertEquals(29.84f, dec.impostoFaixa(2), 0.01f); 
		assertEquals(0, dec.impostoFaixa(1), 0.01f); 
	}
	
	@Test
	public void test4aFaixa() {
		dec.cadastrarRendimento("Salário", 3851.05f);
		dec.cadastrarRendimento("Bolsa de estudo", 2000f);
		
		assertEquals(190.99f, dec.calcularImposto(), 0.01f);
		assertEquals(0, dec.impostoFaixa(5), 0.01f);
		assertEquals(22.5f, dec.impostoFaixa(4), 0.01f);
		assertEquals(138.66f, dec.impostoFaixa(3), 0.01f);
		assertEquals(29.84f, dec.impostoFaixa(2), 0.01f);
		assertEquals(0, dec.impostoFaixa(1), 0.01f);
	}
	
	@Test
	public void test5aFaixa() {
		dec.cadastrarRendimento("Salário", 4764.68f);
		dec.cadastrarRendimento("Bolsa de estudo", 2000f);
		
		assertEquals(401.57f, dec.calcularImposto(), 0.01f);
		assertEquals(27.50f, dec.impostoFaixa(5), 0.01f);
		assertEquals(205.57f, dec.impostoFaixa(4), 0.01f);
		assertEquals(138.66f, dec.impostoFaixa(3), 0.01f);
		assertEquals(29.84f, dec.impostoFaixa(2), 0.01f);
		assertEquals(0, dec.impostoFaixa(1), 0.01f);
	}

}
