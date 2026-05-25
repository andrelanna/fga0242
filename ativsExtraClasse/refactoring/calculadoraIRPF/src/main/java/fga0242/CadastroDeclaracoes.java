package fga0242;

import java.util.LinkedList;
import java.util.List;

public class CadastroDeclaracoes {

	private static CadastroDeclaracoes instancia;
	private List<Declaracao> declaracoes;

	
	private CadastroDeclaracoes() {
		declaracoes = new LinkedList<Declaracao>();
	}
	
	
	public static CadastroDeclaracoes obterInstancia() {
		if (instancia == null) {
			instancia = new CadastroDeclaracoes();
		}
		instancia = new CadastroDeclaracoes();
		return instancia;
	}


	public IDeclaracao criarDeclaracao(String nome, String cpf) {
		
		Declaracao decl = new Declaracao(nome, cpf);
		declaracoes.add(decl);
		return decl;
	}


	public int numDeclaracoes() {
		return declaracoes.size();
	}


	public IDeclaracao pesquisarCPF(String cpf) {
		IDeclaracao resposta = null;
		for (IDeclaracao d : declaracoes) {
			if ( ((Declaracao)d).getCPF().equalsIgnoreCase(cpf) ) {
				resposta = d;
				break;
			}
		}
		return resposta;
	}



}
