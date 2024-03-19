package fga0242;

public class CadastrarRendimento {

	//Referencia para o objeto de Origem
	RendimentosTributaveis origem;
	
	//Um atributo para cada parametro do metodo de origem
	private String nomeRendimento; 
	private int valorRendimento; 
	
	//Um atributo para cada variavel temporaria do método
	String[] tempNomeRendimento; 
	int[] tempValorRendimento;
	
	public CadastrarRendimento(RendimentosTributaveis o, 
			                   String nomeRendimento, 
			                   int valorRendimento) {
		origem = o;
		this.nomeRendimento = nomeRendimento; 
		this.valorRendimento = valorRendimento;
	}
	
	public boolean computar() {
		adicionarRendimento();
		
		origem.nomeRendimento = tempNomeRendimento;
		origem.valorRendimento = tempValorRendimento;
		
		if (origem.nomeRendimento[origem.getNumeroRendimentos()-1] == nomeRendimento &&
			origem.valorRendimento[origem.getNumeroRendimentos()-1] == valorRendimento) 
			return true; 
		else
			return false;
	}

	private void adicionarRendimento() {
		tempNomeRendimento = new String[origem.getNumeroRendimentos() + 1];
		tempValorRendimento = new int[origem.getNumeroRendimentos() + 1];
		
		for (int i=0; i<origem.getNumeroRendimentos(); i++ ) {
			tempNomeRendimento[i] = origem.nomeRendimento[i];
			tempValorRendimento[i] = origem.valorRendimento[i];
		}
		
		tempNomeRendimento[origem.getNumeroRendimentos()] = nomeRendimento;
		tempValorRendimento[origem.getNumeroRendimentos()] = valorRendimento;
	}
}













