package exemplo.tst;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import exemplo.app.SimuladorIRPF;

@RunWith(Parameterized.class)
public class DeducaoPrevidenciaOficial {

	private SimuladorIRPF simulador;

	@Before
	public void setup() {
		simulador = new SimuladorIRPF();
	}
	
	//Atributos dos objeto de teste
	Object[][] contribuicoes;
	float valorEsperado;
	
	//Construtor do objeto de teste
	public DeducaoPrevidenciaOficial(Object[][] contribuicoes, float valorEsperado) {
		this.contribuicoes = contribuicoes;
		this.valorEsperado = valorEsperado;
	}
	
	//Caso de teste
	@Test
	public void cadastroContribuicoes() {
		for (Object[] contribuicao : contribuicoes) {
			simulador.cadastrarPrevidenciaOficial((String)contribuicao[0], (float)contribuicao[1]);
		}
		
		assertEquals(valorEsperado, simulador.getTotalDeducaoPrevidenciaOficial(), 0f);
	}
	
	
	@Parameters
	public static Collection<Object[]> getParameters(){
		//Exemplo simples
		//{{Descricao, valor}, valorEsperado}
		//{{
		//  {Cont1, valor1}, 
		//  {Cont2, valor2},
		//  {Cont3, valor3},
		//    } , valorEsperado}
		
		Object[][] resposta = new Object[][] {
			{new Object[][]{
					{"Contribuicao Compulsoria", 1000f}
			}, 1000f},  //caso 1
			
			{new Object[][] { 
				{"Contribuicao Compulsoria", 800f}
			}, 800f},  //caso 2
			
			{new Object[][] { 
				{"Contribuicao Compulsoria", 1000f}, 
				{"Carne INSS", 800f}
			}, 1800f},  //caso 3
			
			{new Object[][] {
				{"Contribuicao Compulsoria", 1000f}, 
				{"Carne Inss 1", 800f},
				{"Carne Inss 2", 200f}
			}, 2000f}   //caso4
		};
		
		return Arrays.asList(resposta);
	}

}











