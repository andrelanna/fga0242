package tst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.SimuladorIRPF;

@RunWith(Parameterized.class)
public class CadastroRendimentos {

	SimuladorIRPF simul;
	
	//Atributos do objeto de teste
	Object[][] rendimentos; 
	float valorEsperado; 
	
	@Before
	public void setup() {
		simul = new SimuladorIRPF();
	}
	
	public CadastroRendimentos(Object[][] rendimentos, float valorEsperado) {
		this.rendimentos = rendimentos;
		this.valorEsperado = valorEsperado;
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		// {{{Salario, valor}} , valorEsperado}
		// {{
		//   {Salario, valor},
		//   {Aluguel, valor}}, valorEsperado}
		// {{
		//   {Salario, valor}, 
		//   {Aluguel, valor}, 
		//   {Dividen, valor}}, valorEsperado}
		
		Object[][] respostas = new Object[][] {
			{new Object[][] {
				{"Salario", 10000f},
			}, 10000f},
			{new Object[][] {
				{"Salario", 8000f}, 
				{"Aluguel", 2000f}
			}, 10000f}, 
			{new Object[][] {
				{"Salario", 7000f}, 
				{"Aluguel", 2000f},
				{"Dividen", 1000f}
			}, 10000f}
		};
		
		return Arrays.asList(respostas);
	}
	
	
	@Test
	public void testCadastroRendimentos() {
		for (Object[] o : rendimentos) {
			simul.cadastrarRendimento((String)o[0], (float)o[1]);
		}
		assertEquals(valorEsperado, simul.getTotalRendimentos(), 0f);
	}


}










