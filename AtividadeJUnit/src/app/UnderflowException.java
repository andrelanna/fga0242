package app;

public class UnderflowException extends ArithmeticException {
    public UnderflowException(String errorMessage) {
        super(errorMessage);
    }
}
