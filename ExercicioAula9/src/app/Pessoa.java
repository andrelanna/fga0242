package app;

public class Pessoa {

	private static Pessoa[] pessoas = new Pessoa[0];

	private String nome;
	private String sobreNome;
	private Pessoa conjuge;
	private String sexo;

	private Pessoa[] filhos;
	private Pessoa pai;
	private Pessoa mae;





	private Pessoa(String nome, String sobreNome, String sexo) {
		this.nome = nome; 
		this.sobreNome = sobreNome;
		this.sexo = sexo;
		this.filhos = new Pessoa[0];
	}
	
	public static Pessoa getPessoa(String nome, String sobreNome, String sexo) {
		Pessoa p = pesquisarPessoa(nome, sobreNome);
		if (p == null) {
			p = new Pessoa(nome, sobreNome, sexo.toUpperCase());
			adicionarPessoa(p);
		}
		return p;
	}

	private static void adicionarPessoa(Pessoa p) {
		Pessoa[] temp = new Pessoa[pessoas.length + 1];
		for (int i=0; i<pessoas.length; i++) {
			temp[i] = pessoas[i];
		}
		temp[pessoas.length] = p;
		pessoas = temp;
	}

	public static Pessoa pesquisarPessoa(String nome, String sobreNome) {
		Pessoa resposta = null;
		for (Pessoa p : pessoas) {
			if (p.getNome().equalsIgnoreCase(nome) &&
				p.getSobrenome().equalsIgnoreCase(sobreNome)) {
				resposta = p;
			}
		}
		return resposta; 
	}

	private String getSobrenome() {
		return sobreNome;
	}

	private String getNome() {
		return nome;
	}

	public static int numPessoas() {
		return pessoas.length;
	}

	public static boolean removerPessoa(String nome, String sobrenome) {
		boolean resposta = false; 
		Pessoa p = pesquisarPessoa(nome, sobrenome);
		if (p == null)
			return resposta; 
		
		Pessoa[] temp = new Pessoa[pessoas.length - 1];
		int j=0; 
		for (int i=0; i<pessoas.length; i++) {
			if (pessoas[i] != p) {
				temp[j] = pessoas[i];
				j++;
			} else {
				resposta = true; 
			}
		}
		
		pessoas = temp;
		return resposta; 
		
	}

	public boolean casar(Pessoa p) {
		boolean resposta = false; 
		if (conjuge == null && p.getConjuge() == null) {
			p.conjuge = this;   //REFATORAR!!!!
			conjuge = p;
			resposta = true;
		} else {
			if (conjuge == p && p.getConjuge() == this) 
				resposta = true;
		}
		return resposta;
	}

	public Pessoa getConjuge() {
		return conjuge;
	}

	public boolean filiar(Pessoa filho) {
		boolean resposta = false; 
		Pessoa[] temp = new Pessoa[filhos.length + 1];
		for (int i=0; i<filhos.length; i++) {
			temp[i] = filhos[i];
		}
		temp[filhos.length] = filho; 
		filhos = temp;
		if (filhos[filhos.length - 1] == filho) {
			resposta = true;
			if (this.sexo.equalsIgnoreCase("M")) {
				filho.setPai(this);
				filho.setMae(conjuge);
			}
			else {
				filho.setMae(this);
				filho.setPai(conjuge);
			}
		} 
		return resposta;
	}

	private void setMae(Pessoa pessoa) {
		this.mae = pessoa;
	}

	private void setPai(Pessoa pessoa) {
		this.pai = pessoa;
	}

	public Pessoa getPai() {
		return pai;
	}

	public Pessoa getMae() {
		return mae;
	}

	public static Pessoa[] getRaizes() {
		Pessoa[] resposta = new Pessoa[0]; 
		for (Pessoa p : pessoas) { 
			if (p.getMae() == null && p.getPai() == null) {
				Pessoa[] temp = new Pessoa[resposta.length + 1]; 
				for (int i=0; i<resposta.length; i++) {
					temp[i] = resposta[i];
				}
				temp[resposta.length] = p; 
				resposta = temp;
			}
		}
		return resposta;
	}

}
