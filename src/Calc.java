public class Calc {

    private short first;
    private short second;

    public Calc(short first, short second) {
        this.first = first;
        this.second = second;
    }

    public short sum() throws LimiteInferiorException, LimiteSuperiorException {
        if (first + second < Short.MIN_VALUE) {
            throw new LimiteInferiorException();
        } else if (first + second > Short.MAX_VALUE) {
            throw new LimiteSuperiorException();
        }
        return (short) (first + second);
    }

    public short sub() throws LimiteInferiorException, LimiteSuperiorException {
        if (first - second < Short.MIN_VALUE) {
            throw new LimiteInferiorException();
        } else if (first - second > Short.MAX_VALUE) {
            throw new LimiteSuperiorException();
        }
        return (short) (first - second);
    }
}
