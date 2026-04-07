package Exceptions;

public class LimiteSuperiorExtrapoladoException extends ArithmeticException {
    public LimiteSuperiorExtrapoladoException(String limite_superior_extrapolado) {
        super(limite_superior_extrapolado);
    }
}
