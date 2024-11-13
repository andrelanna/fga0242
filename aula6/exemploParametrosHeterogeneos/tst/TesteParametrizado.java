package exemploParametrosHeterogeneos.tst;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exemploParametrosHeterogeneos.app.Aluno;

/*
 * Runner para execução de testes parametrizados
 */
@RunWith(Parameterized.class)
public class TesteParametrizado {

	/* 
	 * atributos do teste (=objeto de teste)
	 */
	String nome; 
	int ano, 
	    semestre, 
	    sequencial; 
	String strMatEsperada;
	String[][] atributos;
	
	/*
	 * Objeto a ser testado
	 */
	private Aluno a; 
	
	/*
	 * Metodo que instancia o objeto de teste 
	 */
	public TesteParametrizado(String nome, 
			                  int ano, int semestre, int sequencial, 
			                  String strMatEsperada, 
			                  String[][] atributos) {
		this.nome = nome; 
		this.ano = ano; 
		this.semestre = semestre;
		this.sequencial = sequencial;
		this.strMatEsperada = strMatEsperada;
		this.atributos = atributos;
	}
	
	/*
	 * Método que retorna as tuplas de teste.
	 * As tuplas foram estão construídas passo a passo, para não causar confusão. 
	 */
	@Parameters
	public static Collection<Object[]> getParameters() {
		/*
		 * <email, asd@adsd.com> = atr1
		 * <formacao, adfasdfasd> = atr2
		 * <nome, [ano, semestre, sequencial], "aa/ssssssss", [atr1, atr2, ...]>   
		 */
		
		/*
		 *Aluno 1 
		 */
		String nome1 = "Andre";
		int ano1 = 12;
		int sem1 = 0; 
		int seq1 = 149826;
		String matEsp1 = "12/0149826";
		String email1[] = new String[] {"email", "andrelanna@unb;br"};
		String form1[] = new String[] {"formacao", "Ciencia da Computacao"};
		String[][] atri1 = new String[][] {email1, form1};
		
		/*
		 *Aluno 2 
		 */
		String nome2 = "Maria";
		int ano2 = 22;
		int sem2 = 1; 
		int seq2 = 131313;
		String matEsp2 = "22/1131313";
		String email2[] = new String[] {"email", "maria@unb;br"};
		String form2[] = new String[] {"formacao", "Engenharia de Software"};
		String[][] atri2 = new String[][] {email2, form2};
		
		/*
		 * Definição final das tuplas para os testes parametrizados
		 */
		Object[][] parametros = new Object[][] {
			{nome1, ano1, sem1, seq1, matEsp1, atri1},
			{nome2, ano2, sem2, seq2, matEsp2, atri2},
		};
		return Arrays.asList(parametros);
	}
	
	
	/*
	 * Metodo que instancia o objeto a ser testado (Aluno)
	 */
	@Before
	public void setup() {
		a = new Aluno(nome, ano, semestre, sequencial);
		for (String[] v : atributos) {
			String chave = v[0],
				   valor = v[1];
			a.addAtrib(chave, valor);
		}
	}
	
	
	@Test
	public void testAluno() {
		assertNotNull(a);
		assertNotNull(a.getMatricula());
	}
	
	@Test
	public void testMatricula() {
		assertTrue(strMatEsperada.equalsIgnoreCase(a.getMatricula().getTxt()));
	}
	
	@Test
	public void testAtributos() {
		/* Os atributos de um Aluno é dado pela matriz
		 * Atributos = { 
		 *    {nomeAtr1, valor1}, 
		 *    {nomeAtr2, valor2}, ...
		 * }
		 */
		for (String[] v: atributos) {
			assertTrue(v[1].equalsIgnoreCase(a.getAtrib(v[0])));
		}
	}
}
