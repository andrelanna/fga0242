package financeiroExceptions;

public class PrestacaoMaiorQueMargemException extends Exception {

	public PrestacaoMaiorQueMargemException(float f, float margem) {
		super("O valor da prestacao ( " + f + " ) é maior do que o valor permitido pela margem ( " + margem + ")");
	}
	
}
