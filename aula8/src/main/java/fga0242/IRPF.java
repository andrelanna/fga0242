package main.java.fga0242;

public class IRPF {

	private String[] nomeRendimento;
	private float[] valor;
	private float valorTotalRendimentos;
	private int previdenciaOficial;
	private String[] dependentes;
	private int pensaoAlimenticia;
	private String outraDeducao[];
	private int valorOutraDeducao[];
	
	public IRPF() {
		nomeRendimento = new String[0];
		valor = new float[0];
		dependentes = new String[0];
		pensaoAlimenticia = 0;
		outraDeducao = new String[0];
		valorOutraDeducao = new int[0];
	}

	public float cadastrarRendimento(String nomeRendimento, float valor) {
		
		String[] tempRendimento = new String[this.nomeRendimento.length + 1];
		float[] tempValorRendimento = new float[this.valor.length + 1];
		
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

	public float getTotalRendimentos() {
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

	public int  cadastrarPrevidenciaOficial(int previdenciaOficial) throws ValorInvalidoException {
		if (previdenciaOficial <= 0) {
			throw new ValorInvalidoException(previdenciaOficial); 
		}
		this.previdenciaOficial += previdenciaOficial; 
		return this.previdenciaOficial;
	}

	public boolean cadastrarDependente(String dependente) {
		//Criar um vetor com uma posicao adicional
		String tempDependentes[] = new String[dependentes.length + 1];
		
		//Copiar vetor
		for (int i=0; i<dependentes.length; i++) {
			tempDependentes[i] = dependentes[i];
		}
		
		//Adicionar dependente
		for (String d : dependentes) {
			if (d.equalsIgnoreCase(dependente)) {
				return false;
			}
		}
		
		tempDependentes[dependentes.length] = dependente;
		
		//atualizar referencia
		dependentes = tempDependentes;
		return true;
	}

	public boolean possuiDependente(String dependente) {
		for (String d: dependentes) {
			if (d.equalsIgnoreCase(dependente)) {
				return true;
			}
		}
		return false;
	}

	public float getDeducaoDependentes() {
		int numeroDependentes = dependentes.length;
		return numeroDependentes * 189.59f;
	}

	public int  getTotalContribuicoes() {
		return previdenciaOficial;
	}

	public int cadastrarPensaoAlimenticia(int pensao) throws ValorInvalidoException {
		if (pensao <= 0) 
			throw new ValorInvalidoException(pensao);
		this.pensaoAlimenticia += pensao;
		return this.pensaoAlimenticia;
	}

	public int  getTotalPensaoAlimenticia() {
		return this.pensaoAlimenticia;
	}

	public void cadastrarOutraDeducao(String nome, int valor) {
		//Adicionar uma posicao nova nos vetores de nome e valor
		String[] tempOutraDeducao = new String[outraDeducao.length + 1];
		int[] tempValorOutraDeducao = new int[valorOutraDeducao.length + 1];
		
		//copiar um vetor para o outro;
		for (int i=0; i<outraDeducao.length; i++) {
			tempOutraDeducao[i] = outraDeducao[i];
			tempValorOutraDeducao[i] = valorOutraDeducao[i];
		}
		//adicionar cadastro nos vetores temporarios
		tempOutraDeducao[outraDeducao.length] = nome;
		tempValorOutraDeducao[valorOutraDeducao.length] = valor;
		
		//atualizar as referencias
		outraDeducao = tempOutraDeducao;
		valorOutraDeducao = tempValorOutraDeducao;
	}

	public int getTotalOutrasDeducoes() {
		int total = 0; 
		for (int d: valorOutraDeducao) {
			total += d;
		}
		return total;
	}

	public boolean contemDeducao(String nomeDeducao) {
		for (String od : outraDeducao) {
			if (od.equalsIgnoreCase(nomeDeducao))
				return true; 
		}
		return false;
	}

	public float getTotalDeducoes() {
		float resposta = 0; 
		resposta += getTotalContribuicoes();
		resposta += 189.59f * dependentes.length;
		resposta += getTotalPensaoAlimenticia();
		resposta += getTotalOutrasDeducoes();
		
		return resposta;
	}

	public float getBaseDeCalculo() {
		return getTotalRendimentos() - getTotalDeducoes();
	}

	public float getOcupacao1aFaixa() {
		if (getBaseDeCalculo() <= 1903.98f) {
			return getBaseDeCalculo();
		}
		return 1903.98f; //por falsificacao
	}

	public float getImposto1aFaixa() {
		return 0;
	}

	public float getOcupacao2aFaixa() {
		float ocupacao2aFaixa = 0;
		if (getBaseDeCalculo() > 1903.98f + 922.67f) { //ocupou 2a faixa inteira 
			ocupacao2aFaixa = 922.67f;
		} else {
			if (getBaseDeCalculo() > 1903.98f) { //ocupou parte da 2a faixa; 
				ocupacao2aFaixa = getBaseDeCalculo() - 1903.98f;
			}
		}
		return ocupacao2aFaixa;
	}

	public float getImposto2aFaixa() {
		return 0.075f * getOcupacao2aFaixa();
	}

	public float getOcupacao3aFaixa() {
		float ocupacao3afaixa = 0 ;
		if (getBaseDeCalculo() > 1903.98f + 922.67f + 924.40f) { //ocupou a 3a faixa inteira
			ocupacao3afaixa = 924.40f;
		} else {
			if (getBaseDeCalculo() > 1903.98f + 922.67f) { //ocupou parte da 3a faixa
				ocupacao3afaixa = getBaseDeCalculo() - (1903.98f + 922.67f);
			}
		}
		return ocupacao3afaixa;
	}

	public float getImposto3aFaixa() {
		return 0.15f * getOcupacao3aFaixa();
	}

	public float getOcupacao4aFaixa() {
		float ocupacao4aFaixa = 0; 
		if (getBaseDeCalculo() > 1903.98f + 922.67f + 924.40f + 913.63f) { //ocupou a 4a faixa inteira
			ocupacao4aFaixa = 913.63f;
		} else {
			if (getBaseDeCalculo() > 1903.98f + 922.67f + 924.40f) { //ocupou parte da 4a faixa
				ocupacao4aFaixa = getBaseDeCalculo() - (1903.98f + 922.67f + 924.40f);
			}
		}
		return ocupacao4aFaixa;
	}

	public float getImposto4aFaixa() {
		return 0.225f * getOcupacao4aFaixa();
	}

	public float getOcupacao5aFaixa() {
		float ocupacao5aFaixa = 0;
		if (getBaseDeCalculo() > 1903.98f + 922.67f + 924.40f + 913.63f) { //avancou pela 5a faixa
			ocupacao5aFaixa = getBaseDeCalculo() - (1903.98f + 922.67f + 924.40f + 913.63f);
		}
		return ocupacao5aFaixa;
	}

	public float getImposto5aFaixa() {
		return 0.275f * getOcupacao5aFaixa();
	}

	public float getTotalFaixaBaseDeCalculo() {
		return getOcupacao1aFaixa() + 
				getOcupacao2aFaixa() + 
				getOcupacao3aFaixa() + 
				getOcupacao4aFaixa() + 
				getOcupacao5aFaixa();
	}

	public float getTotalImposto() {
		return getImposto1aFaixa() + 
				getImposto2aFaixa() + 
				getImposto3aFaixa() + 
				getImposto4aFaixa() + 
				getImposto5aFaixa(); 
	}

}






