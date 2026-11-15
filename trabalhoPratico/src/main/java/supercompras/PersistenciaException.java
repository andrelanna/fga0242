package supercompras;

/** Falha ao gravar ou ler pedidos. CONTRATO CONGELADO. */
public class PersistenciaException extends RuntimeException {
    public PersistenciaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
