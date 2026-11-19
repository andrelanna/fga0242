package main;
import exceptions.LimitesException;

public class Calculadora {


	private static short SUPERIOR = 32767;
	private static short INFERIOR = -32768;

	public short soma(int num1, int num2) throws LimitesException{
		int valor = num1 + num2;
		checarLimites(valor);
		return (short) valor;
	}

	public short subtracao(int num1, int num2) throws LimitesException{
		int valor = num1 - num2;
		checarLimites(valor);
		return (short) valor;
	}

	private void checarLimites(int valor) throws LimitesException{
		if(valor>SUPERIOR || valor<INFERIOR ) {
			throw new LimitesException();
		}
	}
}