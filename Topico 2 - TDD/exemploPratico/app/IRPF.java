package app;

public class IRPF {

	private float salario;
	private float previdenciaOficial;
	private String dependentes[];
	private float pensaoAlimenticia;
	
	private String[] outrasDeducoes;
	private float[] valorOutrasDeducoes;

	public IRPF() {
		this.dependentes = new String[0];  //diferente de nulo!
		this.outrasDeducoes = new String[0];
		this.valorOutrasDeducoes = new float[0];
	}
	
	public void cadastrarSalario(float salario) {
		this.salario += salario;
	}

	public float getSalario() {
		return salario; 
	}

	public void cadastrarPrevidenciaOficial(float contribuicao) {
		this.previdenciaOficial = contribuicao;
	}

	public float getPrevidenciaOficial() {
		return this.previdenciaOficial;
	}

	public void cadastrarDependente(String dependente) {
		String[] temp = new String[dependentes.length + 1];
		for (int i=0; i<this.dependentes.length; i++) {
			temp[i] = dependentes[i];
		}
		temp[dependentes.length] = dependente;
		this.dependentes = temp;
	}

	public float  getDeducaoDependentes() {
		return dependentes.length * 189.59f;
	}

	public void cadastrarDeducaoPensaoAlimenticia(float valor) {
		this.pensaoAlimenticia += valor;
	}

	public float getDeducaoPensaoAlimenticia() {
		return this.pensaoAlimenticia;
	}

	public void cadastrarOutraDeducao(String deducao, float valor) {
		String[] tempNomeDeducoes = new String[this.outrasDeducoes.length + 1];
		float[] tempValorDeducoes = new float[this.outrasDeducoes.length + 1];
		
		for (int i=0; i < this.outrasDeducoes.length; i++) {
			tempNomeDeducoes[i] = this.outrasDeducoes[i];
			tempValorDeducoes[i] = this.valorOutrasDeducoes[i];
		}
		
		tempNomeDeducoes[this.outrasDeducoes.length] = deducao; 
		tempValorDeducoes[this.outrasDeducoes.length] = valor; 
		
		this.outrasDeducoes = tempNomeDeducoes;
		this.valorOutrasDeducoes = tempValorDeducoes; 
	}

	public float getOutrasDeducoes() {
		float resposta = 0; 
		for (float d : this.valorOutrasDeducoes) {
			resposta += d;
		}
		return resposta;
	}

	public boolean possuiDeducao(String nomeDeducao) {
		boolean resposta = false; 

		for (String nd : this.outrasDeducoes) {
			if (nd.equalsIgnoreCase(nomeDeducao)) {
				resposta = true; 
				break;
			}
		}
		return resposta;
	}

	public float getTotalDeducoes() {
		return getDeducaoDependentes() + 
			   getDeducaoPensaoAlimenticia() + 
			   getOutrasDeducoes() + 
			   getPrevidenciaOficial();
	}

}







