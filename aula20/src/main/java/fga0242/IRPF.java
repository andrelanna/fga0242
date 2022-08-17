package main.java.fga0242;

public class IRPF {

	private CadastroRendimentos rendimentos = new CadastroRendimentos();
	private CadastroDependentes dependentes = new CadastroDependentes();
	private int previdenciaOficial;
	private int pensaoAlimenticia;
	private Imposto imposto;
	
	String outraDeducao[];
	int valorOutraDeducao[];
	
	public IRPF() {
		pensaoAlimenticia = 0;
		outraDeducao = new String[0];
		valorOutraDeducao = new int[0];
		imposto = new Imposto();
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
		return dependentes.cadastrarDependente(dependente);
	}

	public boolean possuiDependente(String dependente) {
		return dependentes.possuiDependente(dependente);
	}

	public float getDeducaoDependentes() {
		return dependentes.getDeducaoDependentes();
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
		resposta += dependentes.getDeducaoDependentes();
		resposta += getTotalPensaoAlimenticia();
		resposta += getTotalOutrasDeducoes();
		
		return resposta;
	}

	public float getBaseDeCalculo() {
		return imposto.getBaseDeCalculo(this);
	}

	public float getOcupacao1aFaixa() {
		return imposto.getOcupacao1aFaixa(this);
	}

	public float getImposto1aFaixa() {
		return 0;
	}

	public float getOcupacao2aFaixa() {
		return imposto.getOcupacao2aFaixa(this);
	}

	public float getImposto2aFaixa() {
		return 0.075f * getOcupacao2aFaixa();
	}

	public float getOcupacao3aFaixa() {
		return imposto.getOcupacao3aFaixa(this);
	}

	public float getImposto3aFaixa() {
		return 0.15f * getOcupacao3aFaixa();
	}

	public float getOcupacao4aFaixa() {
		return imposto.getOcupacao4aFaixa(this);
	}

	public float getImposto4aFaixa() {
		return 0.225f * getOcupacao4aFaixa();
	}

	public float getOcupacao5aFaixa() {
		return imposto.getOcupacao5aFaixa(this);
	}

	public float getImposto5aFaixa() {
		return 0.275f * getOcupacao5aFaixa();
	}

	public float getTotalFaixaBaseDeCalculo() {
		return imposto.getTotalFaixaBaseDeCalculo(this);
	}

	public float getTotalImposto() {
		return imposto.getTotalImposto(this);
	}

}






