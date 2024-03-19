package fga0242;

public class RendimentosTributaveis {

	String[] nomeRendimento;
	int[] valorRendimento;

	private RendimentosTributaveis() {
		nomeRendimento = new String[0];
		valorRendimento = new int[0];
	}
	
	public static RendimentosTributaveis getInstance() {
		RendimentosTributaveis rendimentos = new RendimentosTributaveis();
		return rendimentos;
	}


	public boolean adicionarRendimento(String nomeRendimento, int valorRendimento) {
		return new CadastrarRendimento(this, nomeRendimento, valorRendimento).computar(); 
	}


	public String getRendimento() {
		if (nomeRendimento[0].equalsIgnoreCase("Salario")) { 
			return "Salario";
		} else {
			return "Aluguel";
		}
	}


	public int getValorRendimentos() {
		return valorRendimento[0];
	}


	public int getTotalRendimentos() {
		int totalRendimentos = 0; 
		for (int i: this.valorRendimento) {
			totalRendimentos += i;
		}
		return totalRendimentos;
	}

	public boolean contains(String nomeRendimento) {
		for (String s: this.nomeRendimento) {
			if (s.equalsIgnoreCase(nomeRendimento)) {
				return true; 
			}
		}
		return false;
	}

	public int getValorRendimento(String nomeRendimento) {
		for (int i=0; i<this.nomeRendimento.length; i++) {
			if (this.nomeRendimento[i].equalsIgnoreCase(nomeRendimento))
				return this.valorRendimento[i];
		}
		return 0;
	}

	int getNumeroRendimentos() {
		return nomeRendimento.length;
	}

}












