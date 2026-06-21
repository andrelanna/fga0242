package app;

public class Calculadora {
    private short x;
    private short y;

    public Calculadora(short x, short y){
        this.x = x;
        this.y = y;
    }

    public short adicao() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
        int ans = this.x + this.y;
        if (ans > 32767) {
            throw new LimiteInferiorExtrapoladoException();
        } else if (ans < -32768) {
            throw new LimiteInferiorExtrapoladoException();
        }
        return (short) ans;
    }

    public short subtracao() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
        int ans = this.x - this.y;
        if (ans > 32767) {
            throw new LimiteInferiorExtrapoladoException();
        } else if (ans < -32768) {
            throw new LimiteInferiorExtrapoladoException();
        }
        return (short) ans;
    }
}