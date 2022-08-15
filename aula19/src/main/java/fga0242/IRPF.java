package main.java.fga0242;

public class IRPF {

	/* Constantes extraídas a partir do código, através da 
	 * operação de refatoração "Extrair Constante". 
	 * 
	 * Todas as ocorrências dos valores foram alteradas para 
	 * utilização das novas constantes. 
	 */
	private static final float TAMANHO1AFAIXA = 1903.98f;
	private static final float TAMANHO2AFAIXA = 922.67f;
	private static final float TAMANHO3AFAIXA = 924.40f;
	private static final float TAMANHO4AFAIXA = 913.63f;
	private static final float DEDUCAODEPENDENTE = 189.59f;


	private CadastroRendimentos rendimentos = new CadastroRendimentos();
	private String[] dependentes;

	private int previdenciaOficial;
	private int pensaoAlimenticia;
	
	String outraDeducao[];
	int valorOutraDeducao[];
	
	public IRPF() {
		dependentes = new String[0];
		pensaoAlimenticia = 0;
		outraDeducao = new String[0];
		valorOutraDeducao = new int[0];
	}

	public float cadastrarRendimento(String nome, float v) {
		
		return rendimentos.cadastrarRendimento(nome, v);
	}

	/*
	 * Método criado à partir da extração da instrução nomeRendimento.length, 
	 * através da operação de refatoração Extrair Metodo. 
	 * 
	 * Todas as ocorrências de nomeRendimento.length foram substituidas por 
	 * uma chamada ao novo método. Não há mais esse código duplicado. 
	 */
	/**
	 * Método que retorna o número de rendimentos já cadastrados.
	 * @return numero de rendimentos cadastrados.
	 */
	int numeroRendimentos() {
		return rendimentos.getNomeRendimento().length;
	}
	
	public String getNomeRendimento() {
		return rendimentos.getNomeRendimento()[numeroRendimentos()-1];
	}

	public float getTotalRendimentos() {
		return rendimentos.getValorTotalRendimentos();
	}

	public boolean containsRendimento(String rendimento) {
		boolean resposta = false; 
		for (String r:rendimentos.getNomeRendimento()) {
			if (r.equalsIgnoreCase(rendimento))
				return true;
		}
		
		return resposta;
	}

	public int  cadastrarPrevidenciaOficial(int previdencia) throws ValorInvalidoException {
		if (previdencia <= 0) {
			throw new ValorInvalidoException(previdencia); 
		}
		previdenciaOficial += previdencia; 
		return previdenciaOficial;
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
		return numeroDependentes * DEDUCAODEPENDENTE;
	}

	public int  getTotalContribuicoes() {
		return previdenciaOficial;
	}

	public int cadastrarPensaoAlimenticia(int pensao) throws ValorInvalidoException {
		if (pensao <= 0) 
			throw new ValorInvalidoException(pensao);
		pensaoAlimenticia += pensao;
		return pensaoAlimenticia;
	}

	public int  getTotalPensaoAlimenticia() {
		return pensaoAlimenticia;
	}

	public void cadastrarOutraDeducao(String nome, int valor) {
		new CadastrarOutraDeducao(this, nome, valor).computar();
		return;
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
		resposta += DEDUCAODEPENDENTE * dependentes.length;
		resposta += getTotalPensaoAlimenticia();
		resposta += getTotalOutrasDeducoes();
		
		return resposta;
	}

	public float getBaseDeCalculo() {
		return getTotalRendimentos() - getTotalDeducoes();
	}

	public float getOcupacao1aFaixa() {
		if (getBaseDeCalculo() <= TAMANHO1AFAIXA) {
			return getBaseDeCalculo();
		}
		return TAMANHO1AFAIXA; //por falsificacao
	}

	public float getImposto1aFaixa() {
		return 0;
	}

	public float getOcupacao2aFaixa() {
		float ocupacao2aFaixa = 0;
		if (getBaseDeCalculo() > TAMANHO1AFAIXA + TAMANHO2AFAIXA) { //ocupou 2a faixa inteira 
			ocupacao2aFaixa = TAMANHO2AFAIXA;
		} else {
			if (getBaseDeCalculo() > TAMANHO1AFAIXA) { //ocupou parte da 2a faixa; 
				ocupacao2aFaixa = getBaseDeCalculo() - TAMANHO1AFAIXA;
			}
		}
		return ocupacao2aFaixa;
	}

	public float getImposto2aFaixa() {
		return 0.075f * getOcupacao2aFaixa();
	}

	public float getOcupacao3aFaixa() {
		float ocupacao3afaixa = 0 ;
		if (getBaseDeCalculo() > TAMANHO1AFAIXA + TAMANHO2AFAIXA + TAMANHO3AFAIXA) { //ocupou a 3a faixa inteira
			ocupacao3afaixa = TAMANHO3AFAIXA;
		} else {
			if (getBaseDeCalculo() > TAMANHO1AFAIXA + TAMANHO2AFAIXA) { //ocupou parte da 3a faixa
				ocupacao3afaixa = getBaseDeCalculo() - (TAMANHO1AFAIXA + TAMANHO2AFAIXA);
			}
		}
		return ocupacao3afaixa;
	}

	public float getImposto3aFaixa() {
		return 0.15f * getOcupacao3aFaixa();
	}

	public float getOcupacao4aFaixa() {
		float ocupacao4aFaixa = 0; 
		if (getBaseDeCalculo() > TAMANHO1AFAIXA + TAMANHO2AFAIXA + TAMANHO3AFAIXA + TAMANHO4AFAIXA) { //ocupou a 4a faixa inteira
			ocupacao4aFaixa = TAMANHO4AFAIXA;
		} else {
			if (getBaseDeCalculo() > TAMANHO1AFAIXA + TAMANHO2AFAIXA + TAMANHO3AFAIXA) { //ocupou parte da 4a faixa
				ocupacao4aFaixa = getBaseDeCalculo() - (TAMANHO1AFAIXA + TAMANHO2AFAIXA + TAMANHO3AFAIXA);
			}
		}
		return ocupacao4aFaixa;
	}

	public float getImposto4aFaixa() {
		return 0.225f * getOcupacao4aFaixa();
	}

	public float getOcupacao5aFaixa() {
		float ocupacao5aFaixa = 0;
		if (getBaseDeCalculo() > TAMANHO1AFAIXA + TAMANHO2AFAIXA + TAMANHO3AFAIXA + TAMANHO4AFAIXA) { //avancou pela 5a faixa
			ocupacao5aFaixa = getBaseDeCalculo() - (TAMANHO1AFAIXA + TAMANHO2AFAIXA + TAMANHO3AFAIXA + TAMANHO4AFAIXA);
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






