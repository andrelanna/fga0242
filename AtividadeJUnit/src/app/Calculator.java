package app;

public class Calculator {
    private static final short SHORT_MIN_VALUE = -32768;
    private static final short SHORT_MAX_VALUE = 32767;

    private short x;
    private short y;

    public Calculator(int x, int y) {
        this.x = (short) x;
        this.y = (short) y;
    }

    public short sum() throws ArithmeticException {
        int result = x + y;

        checkLimits(result);

        return (short) result;
    }

    public short subtract() throws ArithmeticException {
        int result = x - y;

        checkLimits(result);

        return (short) result;
    }

    public void checkLimits(int result) throws ArithmeticException {
        if (result > SHORT_MAX_VALUE) {
            throw new OverflowException("Valor máximo ultrapassado");
        } else if (result < SHORT_MIN_VALUE) {
            throw new UnderflowException("Valor mínimo ultrapassado");
        }
    }
}
