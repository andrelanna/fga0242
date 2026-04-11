package exemplo;

public class DivisaoPorZeroException extends ArithmeticException{
	
	public DivisaoPorZeroException() {
		super("Divisão por zero detectada.");
	}
}
