package app;

public class MetodoObjeto {
	
	String nome; 
	float valor; 
	boolean ehTributavel;
	CadastroRendimento origem;
	
	private Rendimento r;
	private Rendimento[] temp;
	
	public MetodoObjeto(String nome, 
			            float valor, 
			            boolean ehTributavel, 
			            CadastroRendimento origem) {
		this.nome = nome;
		this.valor = valor; 
		this.ehTributavel = ehTributavel; 
		this.origem = origem;
	}
	
	public boolean computar() {
		m1();
		
		//2o. copiar todos elementos do vetor antigo para o novo
		for (int i=0; i<origem.numRendimentos(); i++) {
			temp[i] = origem.rendimentos[i];
		}
		
		//3o. alocar novo rendimento na ultima posicao
		temp[temp.length - 1] = r; 
		
		//4o. atualizar referencia
		origem.rendimentos = temp; 
		
		if (origem.rendimentos[origem.numRendimentos() -1] == r)
			return true;
		else 
			return false;
	}

	private void m1() {
		r = new Rendimento(nome, valor, ehTributavel);

		//alocar Rendimento dentro do vetor de rendimentos
		//1o. criar novo vetor temporario de rendimentos
		temp = new Rendimento[origem.numRendimentos() + 1];
	}
}
