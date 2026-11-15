package supercompras;

/** Dado de entrada rejeitado. CONTRATO CONGELADO. */
public class EntradaInvalidaException extends RuntimeException {
    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
