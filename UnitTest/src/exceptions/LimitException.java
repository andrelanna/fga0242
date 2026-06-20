package exceptions;

public class LimitException extends ArithmeticException {

	private static final long serialVersionUID = 1L;
	
	public LimitException(final String message) {
		super(message);
	}
}
