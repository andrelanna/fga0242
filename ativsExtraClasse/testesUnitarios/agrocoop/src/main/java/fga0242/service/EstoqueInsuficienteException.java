package fga0242.service;

public class EstoqueInsuficienteException extends RuntimeException {

    public EstoqueInsuficienteException(String produtoId, int solicitado, int disponivel) {
        super(String.format(
            "Estoque insuficiente para o produto %s: solicitado=%d, disponivel=%d",
            produtoId, solicitado, disponivel));
    }
}
