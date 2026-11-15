package supercompras;

/** Falha prevista na comunicação com um mercado. CONTRATO CONGELADO. */
public class MercadoIndisponivelException extends Exception {
    public MercadoIndisponivelException(String mensagem) {
        super(mensagem);
    }

    public MercadoIndisponivelException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
