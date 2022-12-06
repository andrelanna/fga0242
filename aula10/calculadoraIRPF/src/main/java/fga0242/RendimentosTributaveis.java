package fga0242;

public class RendimentosTributaveis {

	private static RendimentosTributaveis instancia;
	
	private String[] tipoRendimento;
	private int[] valor;


	private RendimentosTributaveis() {
		this.tipoRendimento = new String[0];
		this.valor = new int[0];
	}

	public static RendimentosTributaveis getInstance() {
		instancia = new RendimentosTributaveis(); 
		return instancia;
	}

	public void adicionarRendimento(String tipoRendimento, int valor) {
		String[] tempDescricao = new String[this.tipoRendimento.length + 1];
		int[] tempValor = new int[this.valor.length + 1];
		
		for (int i=0; i<this.tipoRendimento.length; i++) {
			tempDescricao[i] = this.tipoRendimento[i];
			tempValor[i] = this.valor[i];
		}
		
		tempDescricao[this.tipoRendimento.length] = tipoRendimento;
		tempValor[this.valor.length] = valor;
		
		this.tipoRendimento = tempDescricao; 
		this.valor = tempValor;
	}

	public String getTipoRendimento() {
		return tipoRendimento[0];
	}

	public int getValor() {
		return valor[0];
	}

	
	
	
	public boolean containsRendimento(String nomeRendimento) {
		boolean resposta = false; 
		
		for (String s : this.tipoRendimento) {
			if (s.equalsIgnoreCase(nomeRendimento)) {
				resposta = true; 
				break; 
			}
				
		}
		return resposta;  //Por falsificacao!!!! 
	}

	public int getValorRendimento(String nomeRendimento) {
		int posicao = 0; 
		while (posicao < this.tipoRendimento.length ) {
			if (this.tipoRendimento[posicao].equalsIgnoreCase(nomeRendimento)) {
				break; 
			}
			posicao ++; 
		}
		return this.valor[posicao];
	}

	public int getValorTotal() {
		int valorTotal = 0 ;
		for (int i: this.valor) {
			valorTotal += i;
		}
		return valorTotal;
	}

}
