package app;

import app.exception.LimiteInferiorExtrapoladoException;
import app.exception.LimiteSuperiorExtrapoladoException;

public class Calculator {

    public Calculator() { //No args constructor
    }

    private static final int LOWER_LIMIT = -32768;
    private static final int HIGHER_LIMIT = 32767;

    public short addition(final short x, final short y) throws LimiteSuperiorExtrapoladoException,
            LimiteInferiorExtrapoladoException {

        int result = (int) x + (int) y;

        if (result < LOWER_LIMIT) {
            throw new LimiteInferiorExtrapoladoException("Lower limit extrapolated");
        }
        if (result > HIGHER_LIMIT) {
            throw new LimiteSuperiorExtrapoladoException("Higher limit extrapolated");
        }

        return (short) (x + y);
    }

    public short subtraction(final short x, final short y) throws LimiteSuperiorExtrapoladoException,
            LimiteInferiorExtrapoladoException {

        int result = (int) x - (int) y;

        if (result < LOWER_LIMIT) {
            throw new LimiteInferiorExtrapoladoException("Lower limit extrapolated");
        }
        if (result > HIGHER_LIMIT) {
            throw new LimiteSuperiorExtrapoladoException("Higher limit extrapolated");
        }

        return (short) (x - y);
    }

}
