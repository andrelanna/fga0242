package supercompras;

/** Nenhum mercado com cotação válida aceitou a compra. CONTRATO CONGELADO. */
public class CompraNaoRealizadaException extends RuntimeException {
    public CompraNaoRealizadaException(String mensagem) {
        super(mensagem);
    }
}
