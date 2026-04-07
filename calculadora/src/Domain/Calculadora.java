package Domain;

import Exceptions.LimiteInferiorExtrapoladoException;
import Exceptions.LimiteSuperiorExtrapoladoException;

public class Calculadora {

    private final int limiteInferior = -32768;
    private final int limiteSuperior = 32767;

    public Calculadora() {
    }

    public short adicao(short operando1, short operando2) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
        short resultado = (short) (operando1 + operando2);
        if(resultado < limiteInferior)
            throw new LimiteInferiorExtrapoladoException("Limite inferior extrapolado");
        else if(resultado > limiteSuperior)
            throw new LimiteSuperiorExtrapoladoException("Limite superior extrapolado");
        return (short) (operando1 + operando2);
    }

    public short subtracao(short operando1, short operando2) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
        short resultado = (short) (operando1 - operando2);
        if(resultado < limiteInferior)
            throw new LimiteInferiorExtrapoladoException("Limite inferior extrapolado");
        else if(resultado > limiteSuperior)
            throw new LimiteSuperiorExtrapoladoException("Limite superior extrapolado");
        return (short) (operando1 - operando2);
    }

}
