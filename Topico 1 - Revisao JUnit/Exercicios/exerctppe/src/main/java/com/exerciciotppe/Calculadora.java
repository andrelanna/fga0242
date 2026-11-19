package com.exerciciotppe;

public class Calculadora {
    private short a;
    private short b;
    private final short LIMITE_INFERIOR = -32768;
    private final short LIMITE_SUPERIOR = 32767;

    public Calculadora(short a, short b){
        this.a = a;
        this.b = b;
    }

    public short adicao() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException{
        short resultado = (short) (a + b);

        if ( resultado < LIMITE_INFERIOR) {
			throw new LimiteInferiorExtrapoladoException();
		} else if (resultado > LIMITE_SUPERIOR) {
			throw new LimiteSuperiorExtrapoladoException();
		}
        
        return resultado;
    }

    public short subtracao() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException{
        short resultado = (short) (a - b);

        if (resultado < LIMITE_INFERIOR) {
			throw new LimiteInferiorExtrapoladoException();
		} else if (resultado > LIMITE_SUPERIOR) {
			throw new LimiteSuperiorExtrapoladoException();
		}

        return resultado;
    }

}
