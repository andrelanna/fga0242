package app;

public class Calculadora {
	
	short a;
	short b;
	
	public Calculadora(short a, short b) {
		this.a = a;
		this.b = b;
	}
	
	public short soma() throws ArithmeticException {
		short resultado = (short) (this.a + this.b);
		if(a < 0 && b < 0 && resultado > 0) {
			throw new LimiteInferiorExtrapoladoException();
		}
		if(a > 0 && b > 0 && resultado < 0) {
			throw new LimiteSuperiorExtrapoladoException();
		}
		return resultado;
	}
	
	public short subtracao() {
		return (short) (this.a - this.b);
	}
	
}
