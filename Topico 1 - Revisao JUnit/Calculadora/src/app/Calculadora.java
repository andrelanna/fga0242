package app;

import exeptions.LimiteInferiorExtrapoladoException;
import exeptions.LimiteSuperiorExtrapoladoException;

public class Calculadora {
	public Calculadora () {
		
	}
	private static int LIMITE_INFERIOR = -32768;
	private static int LIMITE_SUPERIOR = 32767;

	public short adicao(short operando_1, short operando_2) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		int res = (int)operando_1 + (int) operando_2;
		if(res < LIMITE_INFERIOR)
			throw new LimiteInferiorExtrapoladoException();
		if(res > LIMITE_SUPERIOR)
			throw new LimiteSuperiorExtrapoladoException();
		
		return (short) (operando_1 + operando_2);
	}
	public short subtracao(short operando_1, short operando_2) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		int res = (int)operando_1 - (int) operando_2;
		if(res < LIMITE_INFERIOR)
			throw new LimiteInferiorExtrapoladoException();
		if(res > LIMITE_SUPERIOR)
			throw new LimiteSuperiorExtrapoladoException();

		return (short) (operando_1 - operando_2);
	}
}
