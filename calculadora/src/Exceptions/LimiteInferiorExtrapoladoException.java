package Exceptions;

public class LimiteInferiorExtrapoladoException extends ArithmeticException {
    public LimiteInferiorExtrapoladoException(String limite_inferior_extrapolado) {
        super(limite_inferior_extrapolado);
    }
}
