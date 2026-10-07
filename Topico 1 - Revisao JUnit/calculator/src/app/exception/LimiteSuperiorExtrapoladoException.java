package app.exception;

public class LimiteSuperiorExtrapoladoException extends Exception{
    public LimiteSuperiorExtrapoladoException() {
        super("Limite superior extrapolado");
    }
}
