package app;

public class Calculadora {
    private int i;
    private int j;

    public Calculadora(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int soma() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
        if ((i+j) < -32768 ){
            throw new LimiteInferiorExtrapoladoException();
        }

        else if ((i+j) > 32767) {
            throw new LimiteSuperiorExtrapoladoException();
        }
        else

            return (i + j);
    }

    public int sub() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
        if ((i-j) < -32768 ){
            throw new LimiteInferiorExtrapoladoException();
        }

        else if ((i-j) > 32767) {
            throw new LimiteSuperiorExtrapoladoException();
        }
        else

            return (i - j);
    }
}