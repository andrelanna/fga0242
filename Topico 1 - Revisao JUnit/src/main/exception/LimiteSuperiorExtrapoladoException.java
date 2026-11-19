package exception;

public class LimiteSuperiorExtrapoladoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public LimiteSuperiorExtrapoladoException() {
		super("Resultado extrapola limite superior do tipo short");
	}
	
}
