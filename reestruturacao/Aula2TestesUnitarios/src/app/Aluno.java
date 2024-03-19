package app;

import exceptions.DadosInvalidosException;

public class Aluno {

	private String nome;
	private int matricula;

	public Aluno(String nome, int matricula) throws DadosInvalidosException {
		if (nome == null || nome.equals("") ||
		    matricula <= 0)
			throw new DadosInvalidosException();
		this.nome = nome; 
		this.matricula = matricula; 
	}

	public String getNome() {
		return nome;
	}

	public int getMatricula() {
		return matricula;
	}

}
