package app;
import app.exception.*;

public class CalculatorMain {

    public CalculatorMain() {
    }

    public short sum(short numberOne, short numberTwo) throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException {

        int result = (int)numberOne + (int)numberTwo;

        if( result < -32768 ){
            throw new LimiteInferiorExtrapoladoException();
        }

        if( result > 32767 ){
            throw new LimiteSuperiorExtrapoladoException();
        }

        return (short)result;
    }

    public short subtraction(short numberOne, short numberTwo) throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException {

        int result = (int)numberOne - (int)numberTwo;

        if( result < -32768 ){
            throw new LimiteInferiorExtrapoladoException();
        }

        if( result > 32767 ){
            throw new LimiteSuperiorExtrapoladoException();
        }

        return (short)result;
    }
}
