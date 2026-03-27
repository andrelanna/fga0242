package exception;

public class LimiteInferiorExtrapoladoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public LimiteInferiorExtrapoladoException() {
		super("Resultado extrapola limite inferior do tipo short");
	}
	
}
