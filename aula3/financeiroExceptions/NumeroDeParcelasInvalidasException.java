package financeiroExceptions;

public class NumeroDeParcelasInvalidasException extends Exception {

	public NumeroDeParcelasInvalidasException(int n) {
		super("Número de parcelas deve ser maior ou igual a 5. Parcelas informadas: " + n);
	}
	
}
