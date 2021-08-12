package calculator;

public class Calculator{
	private static int LIMITE_INFERIOR = -32768;
	private static int LIMITE_SUPERIOR = 32767;
	public static short sum(short a, short b) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		int res = (int)a+(int)b;
		if(res<LIMITE_INFERIOR)
			throw new LimiteInferiorExtrapoladoException();
		if(res>LIMITE_SUPERIOR)
			throw new LimiteSuperiorExtrapoladoException();
		return (short)res;
	}
	public static short subtract(short a, short b) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		int res =(int)a - (int)b;
		if(res<LIMITE_INFERIOR)
			throw new LimiteInferiorExtrapoladoException();
		if(res>LIMITE_SUPERIOR)
			throw new LimiteSuperiorExtrapoladoException();
		return (short)res;
	}
	
}