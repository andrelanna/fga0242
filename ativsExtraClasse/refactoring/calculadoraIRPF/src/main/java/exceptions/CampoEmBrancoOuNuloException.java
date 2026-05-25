package exceptions;

public class CampoEmBrancoOuNuloException extends RuntimeException {

	public CampoEmBrancoOuNuloException(String msg) {
		super("Campo está em branco ou é nulo: " + msg);
	}

}
