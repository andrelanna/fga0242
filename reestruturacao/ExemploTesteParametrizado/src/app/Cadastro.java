package app;

import java.util.LinkedList;
import java.util.List;

public class Cadastro {
	List<PessoaFisica> cadastro; 
	
	public Cadastro() {
		cadastro = new LinkedList<PessoaFisica>();
	}
	
	public boolean cadastrarPF(String nome, String sobreNome) {
		for (PessoaFisica p : cadastro) {
			if (p.getNome().equalsIgnoreCase(nome) && 
			    p.getSobrenome().equalsIgnoreCase(sobreNome)) {
				return false; 
			}
		}
		PessoaFisica pf = new PessoaFisica(nome, sobreNome);
		boolean resposta = cadastro.add(pf);
		return resposta; 
	}
}
