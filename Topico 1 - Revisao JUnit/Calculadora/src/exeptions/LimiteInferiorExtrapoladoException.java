package exeptions;

public class LimiteInferiorExtrapoladoException extends Exception {

	private static final long serialVersionUID = 1L;

	public LimiteInferiorExtrapoladoException() {
        super("Limite Inferior Extrapolado");
    }

}
