package fga0242.service;

public class PedidoInvalidoException extends RuntimeException {

    public PedidoInvalidoException(String motivo) {
        super(motivo);
    }
}
