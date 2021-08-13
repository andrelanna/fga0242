package app;

public class OverflowException extends ArithmeticException {
    public OverflowException(String errorMessage) {
        super(errorMessage);
    }
}
