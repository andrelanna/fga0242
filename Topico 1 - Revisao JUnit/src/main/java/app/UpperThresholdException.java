package app;

public class UpperThresholdException extends ArithmeticException {
    public UpperThresholdException() {
        super("Resultado excede limite superior suportado.");
    }
}
