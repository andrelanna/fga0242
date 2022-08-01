package main.java.fga0242;

public class ValorInvalidoException extends Exception{

	public ValorInvalidoException(int previdenciaOficial) {
		super("Valor nulo ou negativo informado: " + previdenciaOficial);
	}

}
