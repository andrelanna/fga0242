package app;

public class LowerThresholdException extends ArithmeticException {
    public LowerThresholdException() {
        super("Resultado excede limite inferior suportado.");
    }
}
