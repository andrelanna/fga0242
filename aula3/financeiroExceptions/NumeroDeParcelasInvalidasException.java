package financeiroExceptions;

public class NumeroDeParcelasInvalidasException extends Exception {

	public NumeroDeParcelasInvalidasException(int n) {
		super("Número de parcelas deve >= 5. Parcelas informadas: " + n);
	}

}