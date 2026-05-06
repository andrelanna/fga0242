package test.java.fga0242;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.java.fga0242.ValorInvalidoException;

@RunWith(Parameterized.class)
public class CadastroPensaoAlimenticiaTest extends BaseTest{

	int[] pagamentosPA; 
	int totalPA;
	
	public CadastroPensaoAlimenticiaTest(int[] pagamentosPA, int totalPA) {
		this.pagamentosPA = pagamentosPA;
		this.totalPA = totalPA;
	}
	
	@Parameters
	public static Collection <Object[]> getParameters() {
		Object[][] resposta = new Object[][] { 
			{new int[] {1000}, 1000}, 
			{new int[] {1000, 500}, 1500}, 
			{new int[] {1000, 500, 500}, 2000}, 
		};
		
		return Arrays.asList(resposta);
	}
	
	@Test
	public void testCadastroPensoesAlimenticias() throws ValorInvalidoException {
		for (int p : pagamentosPA) {
			irpf.cadastrarPensaoAlimenticia(p);
		}
		
		assertEquals(totalPA, irpf.getTotalPensaoAlimenticia());
	}
	


}
