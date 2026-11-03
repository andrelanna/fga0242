package app.exception;

public class LimiteInferiorExtrapoladoException extends Exception{
    public LimiteInferiorExtrapoladoException() {
        super("Limite inferior extrapolado");
    }
}
