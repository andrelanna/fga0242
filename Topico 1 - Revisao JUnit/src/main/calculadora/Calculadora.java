package calculadora;

import exception.LimiteInferiorExtrapoladoException;
import exception.LimiteSuperiorExtrapoladoException;

public class Calculadora {

	
	private static short LIMITE_SUPERIOR = 32767;
	private static short LIMITE_INFERIOR = -32768;
	
	public short soma(int param1, int param2) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		int valor = param1 + param2;
		checarLimites(valor);
		return (short) valor;
	}
	
	public short subtracao(int param1, int param2) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		int valor = param1 - param2;
		checarLimites(valor);
		return (short) valor;
	}
	
	
	private void checarLimites(int valor) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		
		if(valor>LIMITE_SUPERIOR) {
			throw new LimiteSuperiorExtrapoladoException();
		} else if (valor<LIMITE_INFERIOR) {
			throw new LimiteInferiorExtrapoladoException();
		}
		
	}
}
