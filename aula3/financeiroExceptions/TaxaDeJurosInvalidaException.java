package financeiroExceptions;

public class TaxaDeJurosInvalidaException extends Exception {

	public TaxaDeJurosInvalidaException() {
		super("A taxa de juros não pode ser zerada.");
	}

}