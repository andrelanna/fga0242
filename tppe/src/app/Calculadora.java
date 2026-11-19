package app;

public class Calculadora {

	private short a;
	private short b;
	
	public Calculadora(short a, short b) {
		this.a = a;
		this.b = b;
	}
	
	public short soma() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		if ((int)(a+b) < -32768) {
			throw new LimiteInferiorExtrapoladoException();
		} else if ((int)(a+b) > 32767) {
			throw new LimiteSuperiorExtrapoladoException();
		}
		return (short) (a+b);
	}
	
	public short subtracao() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		if ((int)(a-b) < -32768) {
			throw new LimiteInferiorExtrapoladoException();
		} else if ((int)(a-b) > 32767) {
			throw new LimiteSuperiorExtrapoladoException();
		}
		return (short) (a-b);
	}
}
