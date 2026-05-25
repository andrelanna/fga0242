package fga0242;

import exceptions.CampoEmBrancoOuNuloException;

public class FcdCadastroDeclaracoes {

	CadastroDeclaracoes cadDeclaracoes = CadastroDeclaracoes.obterInstancia(); 
	
	private FcdCadastroDeclaracoes() {
		cadDeclaracoes = CadastroDeclaracoes.obterInstancia();
	}
	
	
	public IDeclaracao criarDeclaracao(String nome, String cpf) {
		
		if (nome == null || nome.isBlank() || nome.isEmpty()) {
			throw new CampoEmBrancoOuNuloException("nome");
		} else if (cpf == null || cpf.isBlank() || cpf.isEmpty()){
			throw new CampoEmBrancoOuNuloException("cpf");
		}
		
		IDeclaracao decl = cadDeclaracoes.pesquisarCPF(cpf); 
		if (decl == null) {
			decl = cadDeclaracoes.criarDeclaracao(nome, cpf);
		}
		return decl;
	}

	public int numDeclaracoes() {
		return cadDeclaracoes.numDeclaracoes();
	}

	public static FcdCadastroDeclaracoes obterInstancia() {
		return new FcdCadastroDeclaracoes();
	}


	public IDeclaracao pesquisarDeclaracaoCPF(String cpf) {
		IDeclaracao resposta = cadDeclaracoes.pesquisarCPF(cpf);
		return resposta;
	}

}
