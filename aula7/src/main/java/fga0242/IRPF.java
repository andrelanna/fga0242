package main.java.fga0242;

public class IRPF {

	private String[] nomeRendimento;
	private int valor;
	
	public IRPF() {
		nomeRendimento = new String[0];
	}

	public int cadastrarRendimento(String nomeRendimento, int valor) {
		
		String[] tempRendimento = new String[this.nomeRendimento.length + 1];
		for (int i=0; i<this.nomeRendimento.length; i++) {
			tempRendimento[i] = this.nomeRendimento[i];
		}
		tempRendimento[this.nomeRendimento.length] = nomeRendimento;
		this.nomeRendimento = tempRendimento;
		
		
		this.valor += valor; 
		return this.valor;
	}
	
	public String getNomeRendimento() {
		return this.nomeRendimento[this.nomeRendimento.length-1];
	}

	public int getTotalRendimentos() {
		return this.valor;
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
