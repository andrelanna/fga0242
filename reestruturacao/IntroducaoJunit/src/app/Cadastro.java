package app;

import java.util.LinkedList;
import java.util.List;

public class Cadastro {
	
	private List<Aluno> alunos;
	
	public Cadastro() {
		alunos = new LinkedList<Aluno>();
	}
	
	
	public boolean cadastrarAluno(String nome, int matricula) throws NomeEmBrancoException, MatriculaInvalidaException {
		if (nome.isEmpty()) {
			throw new NomeEmBrancoException(); 
		}
		if (matricula <= 0) {
			throw new MatriculaInvalidaException();
		}

		Aluno a = new Aluno(nome, matricula);
		try {
			Thread.sleep(1005);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		boolean resposta = alunos.add(a);
		return resposta; 
	}
	
	public int numeroAlunos() {
		return alunos.size();
	}
	
}






