package fga0242.service;

import java.util.HashMap;
import java.util.Map;

import fga0242.model.Produto;


/**
 * Controla a quantidade disponível de cada produto no armazém
 * da cooperativa.
 */
public class Estoque {

    private final Map<String, Integer> quantidadesPorProduto;

    public Estoque() {
        this.quantidadesPorProduto = new HashMap<>();
    }

    public void repor(Produto produto, int quantidade) {
        quantidadesPorProduto.merge(produto.getId(), quantidade, Integer::sum);
    }

    public int consultarQuantidade(Produto produto) {
        return quantidadesPorProduto.getOrDefault(produto.getId(), 0);
    }

    /**
     * Reserva a quantidade solicitada de um produto para um pedido.
     *
     * @throws EstoqueInsuficienteException caso a quantidade disponível
     *         seja menor que a solicitada.
     */
    public void reservar(Produto produto, int quantidadeSolicitada) {
        int disponivel = consultarQuantidade(produto);
        if (quantidadeSolicitada > disponivel) {
            throw new EstoqueInsuficienteException(produto.getId(), quantidadeSolicitada, disponivel);
        }
        quantidadesPorProduto.put(produto.getId(), disponivel - quantidadeSolicitada);
    }
}
