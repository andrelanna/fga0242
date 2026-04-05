package com.example.calculadora;

public class Calculadora {
    private short value1;
    private short value2;

    public short getValue1() {
        return value1;
    }

    public void setValue1(short value1) {
        this.value1 = value1;
    }

    public short getValue2() {
        return value2;
    }

    public void setValue2(short value2) {
        this.value2 = value2;
    }

    public Calculadora(int value1, int value2){
        setValue1((short) value1);
        setValue2((short) value2);
    }

    public short Soma() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException{
        int resultado = getValue1() + getValue2();

        if (resultado > 32767)
            throw new LimiteSuperiorExtrapoladoException("Resultado acima do limite da soma");
        else if(resultado < -32768)
            throw new LimiteInferiorExtrapoladoException("Resultado abaixo do limite da soma");

        return (short)resultado;
    }

    public short Subtracao() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
        int resultado = getValue1() - getValue2();

        if (resultado > 32767)
            throw new LimiteSuperiorExtrapoladoException("Resultado acima do limite da subtração");
        else if(resultado < -32768)
            throw new LimiteInferiorExtrapoladoException("Resultado abaixo do limite da subtração");

        return (short)resultado;
    }
}
