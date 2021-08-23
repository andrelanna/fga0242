package app;

public class IRPF {

	private float salario;
	private float previdenciaOficial;
	private String dependentes[];

	public IRPF() {
		this.dependentes = new String[0];  //diferente de nulo!
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
		return dependentes.length * 189.59f;  //por falsificacao
	}

}
