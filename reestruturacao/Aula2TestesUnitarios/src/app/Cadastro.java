package app;

import java.util.LinkedList;
import java.util.List;

import exceptions.AlunoCadastradoException;

public class Cadastro {

	private List<Aluno> alunos;

	public Cadastro() {
		alunos = new LinkedList<Aluno>();
	}
	
	public int getNumeroAlunos() {
		return alunos.size();
	}

	public boolean existemAlunos() {
		return (alunos != null ? true : false);
	}

	public boolean cadastrarAluno(Aluno a) throws AlunoCadastradoException {
		
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		boolean alunoCadastrado = pesquisar(a.getMatricula());
		boolean resposta = false; 
		if (!alunoCadastrado) {
			resposta = alunos.add(a);
		} else {
			throw new AlunoCadastradoException(a.getMatricula());
		}
		return resposta;
	}

	private boolean pesquisar(int matricula) {
		for (Aluno a : alunos) {
			if (a.getMatricula() == matricula)
				return true; 
		}
		return false;
	}

}







