package fga0242;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BaseDeCalculoTest {

	CadastroDeclaracoes cadDec;
	IDeclaracao dec; 
	
	@Before
	public void setup() {
		cadDec = CadastroDeclaracoes.obterInstancia();
		dec = cadDec.criarDeclaracao("Cidadao 0", "000.000.000-00"); 
	}
	
	@Test
	public void baseDeCalculo1() {
		dec.cadastrarRendimento("Salário", 10189.59f);
		dec.cadastrarDependente("Dependente 1", "000.000.000-00");
		
		assertEquals(10000f, dec.baseDeCalculo(), 0.01f);
	}
	
	@Test
	public void baseDeCalculo2() {
		dec.cadastrarRendimento("Salário", 10189.59f);
		dec.cadastrarDependente("Dependente 1", "000.000.000-00"); 
		dec.cadastrarRendimento("Bolsa de estudo", 3000f); 
		dec.cadastrarDeducao("Plano de saude", 1000f); 
		
		assertEquals(9000f, dec.baseDeCalculo(), 0.01f);
	}
	
}
