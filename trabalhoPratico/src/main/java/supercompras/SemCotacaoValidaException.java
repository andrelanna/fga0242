package supercompras;

/** Nenhum mercado apresentou uma cotação válida. CONTRATO CONGELADO. */
public class SemCotacaoValidaException extends RuntimeException {
    public SemCotacaoValidaException(String mensagem) {
        super(mensagem);
    }
}
