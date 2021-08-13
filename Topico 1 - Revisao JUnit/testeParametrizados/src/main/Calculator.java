package main;

import Expections.LimiteInferiorExtrapoladoException;
import Expections.LimiteSuperiorExtrapoladoException;

public class Calculator {
    private static final int HIGHER_LIMIT = 32767;
    private static final int LOWER_LIMIT = -32768;

    public static short sum(int x, int y) throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException {
        int result = x + y;
        if (result > HIGHER_LIMIT) {
            throw new LimiteSuperiorExtrapoladoException();
        } else if (result < LOWER_LIMIT) {
            throw new LimiteInferiorExtrapoladoException();
        }

        return (short) result;
    }

    public static short subtract(int x, int y) throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException {
        int result = x - y;
        if (result > HIGHER_LIMIT) {
            throw new LimiteSuperiorExtrapoladoException();
        } else if (result < LOWER_LIMIT) {
            throw new LimiteInferiorExtrapoladoException();
        }

        return (short) result;
    }
}
