package main.java.fga0242;

public class IRPF {

	private String[] nomeRendimento;
	private int[] valor;
	private int valorTotalRendimentos;
	
	public IRPF() {
		nomeRendimento = new String[0];
		valor = new int[0];
	}

	public int cadastrarRendimento(String nomeRendimento, int valor) {
		
		String[] tempRendimento = new String[this.nomeRendimento.length + 1];
		int[] tempValorRendimento = new int[this.valor.length + 1];
		
		for (int i=0; i<this.nomeRendimento.length; i++) {
			tempRendimento[i] = this.nomeRendimento[i];
			tempValorRendimento[i] = this.valor[i];
		}
		tempRendimento[this.nomeRendimento.length] = nomeRendimento;
		tempValorRendimento[this.valor.length] = valor;
		
		this.nomeRendimento = tempRendimento;
		this.valor = tempValorRendimento;
		
		
		this.valorTotalRendimentos += valor; 
		return this.valorTotalRendimentos;
	}
	
	public String getNomeRendimento() {
		return this.nomeRendimento[this.nomeRendimento.length-1];
	}

	public int getTotalRendimentos() {
		return this.valorTotalRendimentos;
	}

	public boolean containsRendimento(String nomeRendimento) {
		boolean resposta = false; 
		for (String r:this.nomeRendimento) {
			if (r.equalsIgnoreCase(nomeRendimento))
				return true;
		}
		
		return resposta;
	}

}
