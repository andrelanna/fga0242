package app;

import java.util.Date;

public class PessoaFisica {
	private String nome;
	private Date nascimento;

	public PessoaFisica(String nome, Date nascimento) {
		this.nome = nome; 
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}
}
