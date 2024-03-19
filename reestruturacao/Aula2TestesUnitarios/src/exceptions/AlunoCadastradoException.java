package exceptions;

public class AlunoCadastradoException extends Exception {

	public AlunoCadastradoException(int matricula) {
		super("Aluno já matriculado. Matricula: " + matricula);
	}

}
