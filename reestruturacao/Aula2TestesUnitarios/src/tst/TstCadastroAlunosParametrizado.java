package tst;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import app.Aluno;
import app.Cadastro;
import exceptions.AlunoCadastradoException;
import exceptions.DadosInvalidosException;

@RunWith(Parameterized.class)
public class TstCadastroAlunosParametrizado {
	
	//Parametros do teste
	Aluno[] entrada; 
	int saidaEsperada;
	private Cadastro c; 
	
	public TstCadastroAlunosParametrizado(Aluno[] entrada, int saidaEsperada) {
		this.entrada = entrada; 
		this.saidaEsperada = saidaEsperada;
	}

	//Obter os parametros do teste
	@Parameters
	public static Collection<Object[]> getParameters() {
		//Meus alunos
		Aluno a1 = null, 
			  a2 = null, 
			  a3 = null, 
			  a4 = null, 
			  a5 = null; 
		try {
			a1 = new Aluno("Andre", 13);
			a2 = new Aluno("Miguel", 14); 
			a3 = new Aluno("Maria", 15);
			a4 = new Aluno("Carlos", 16);
			a5 = new Aluno("Daniel", 17);
		} catch (DadosInvalidosException e) {
			e.printStackTrace();
		}
		
		//dados de entrada
		Aluno[] t1 = new Aluno[]{a1};
		Aluno[] t2 = new Aluno[]{a1, a2};
		Aluno[] t3 = new Aluno[]{a1, a2, a3};
		Aluno[] t4 = new Aluno[] {a1, a2, a3, a4, a5};
		
		//Tuplas de teste
		Object parametros[][] = new Object[][] {
			{t1, 1}, 
			{t2, 2}, 
			{t3, 3}, 
			{t4, 5}
		};
		
		return Arrays.asList(parametros);
	}
	
	
	@Before
	public void setup() {
		c = new Cadastro();
	}
	
	@Test
	public void test() throws AlunoCadastradoException {
		System.out.println(this + " " + c);
		assertNotNull(c);
		
		for (Aluno a: entrada) {
			assertTrue(c.cadastrarAluno(a));
		}
		
		assertEquals(saidaEsperada, c.getNumeroAlunos());
	}

	
	
	
	
	
	
	
}
