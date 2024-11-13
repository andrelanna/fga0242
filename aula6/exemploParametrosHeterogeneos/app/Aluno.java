package exemploParametrosHeterogeneos.app;

import java.util.HashMap;

public class Aluno {

	private String nome;
	private Matricula matricula;
	private HashMap<String, String> atributos;

	public Aluno(String nome, int ano, int semestre, int sequencial) {
		this.nome = nome;
		this.matricula = new Matricula(ano, semestre, sequencial);
		this.atributos = new HashMap<String,String>();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public String addAtrib(String chave, String valor) {
		return atributos.put(chave, valor);
	}

	public String getAtrib(String chave) {
		return atributos.get(chave);
	}

}
