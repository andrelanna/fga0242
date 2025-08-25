package app;

public class Calculator {
    private short x;
    private short y;

    public Calculator(int x, int y) {
        this.x = (short) x;
        this.y = (short) y;
    }

    public short sum() throws LowerThresholdException, UpperThresholdException {
        int result = x + y;
        checkViolation(result);
        return (short) result;
    }

    public short subtraction() throws LowerThresholdException, UpperThresholdException {
        int result = x - y;
        checkViolation(result);
        return (short) result;
    }

    private void checkViolation(int result) throws LowerThresholdException, UpperThresholdException {
        short UPPER_THRESHOLD = 32767;
        short LOWER_THRESHOLD = -32768;

        if (result > UPPER_THRESHOLD) {
            throw new UpperThresholdException();
        } else if (result < LOWER_THRESHOLD) {
            throw new LowerThresholdException();
        }
    }
}