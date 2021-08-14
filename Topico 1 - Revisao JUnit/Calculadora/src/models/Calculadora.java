package models;

import exceptions.LimiteInferiorExtrapoladoException;
import exceptions.LimiteSuperiorExtrapoladoException;

public class Calculadora
{
    public Calculadora() { }

    public short sum(int primeiroOperando, int segundoOperando) throws Exception
    {
        int resultado = primeiroOperando + segundoOperando;
        verificaLimites(resultado);
        return (short) resultado;
    }

    public short sub(int primeiroOperando, int segundoOperando) throws Exception {
        int resultado = primeiroOperando - segundoOperando;
        verificaLimites(resultado);
        return (short) resultado;
    }

    private void verificaLimites(int numero) throws Exception
    {
        if (numero > Short.MAX_VALUE) {
            throw new LimiteSuperiorExtrapoladoException();
        } else if(numero < Short.MIN_VALUE) {
            throw new LimiteInferiorExtrapoladoException();
        }
    }
}
