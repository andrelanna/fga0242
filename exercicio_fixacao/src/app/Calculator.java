package app;

public class Calculator {
    private short i;
    private short j;
    public static final short SHORT_MAX = 32767;
    public static final short SHORT_MIN = -32768;

    public Calculator(short i, short j) {
        this.i = i;
        this.j = j;
    }

    public int sum() throws ArithmeticException {
        int res = this.i + this.j;

        check_exceptions(res);

        return res;
    }

    public int sub() throws ArithmeticException {
        int res = this.i - this.j;

        check_exceptions(res);

        return res;
    }

    private void check_exceptions(int res) throws ArithmeticException {
        if (res > 32767)
            throw new LimiteSuperiorExtrapoladoException();
        else if (res < -32768)
            throw new LimiteInferiorExtrapoladoException();
    }
}
