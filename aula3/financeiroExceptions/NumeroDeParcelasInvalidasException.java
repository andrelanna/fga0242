package financeiroExceptions;

public class NumeroDeParcelasInvalidasException extends Exception {

  public NumeroDeParcelasInvalidasException(int n) {
    super("O numero de parcelas ( " + n + " ) é menor do que o permitido");
  }
        
}