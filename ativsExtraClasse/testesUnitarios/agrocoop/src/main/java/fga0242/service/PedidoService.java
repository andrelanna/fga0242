package fga0242.service;

import fga0242.model.ItemPedido;
import fga0242.model.Pedido;

/**
 * Orquestra o processamento de um pedido: validação, reserva de
 * estoque, cálculo de frete e aplicação de desconto.
 */
public class PedidoService {

    private final Estoque estoque;
    private final CalculadoraFrete calculadoraFrete;
    private final AplicadorDesconto aplicadorDesconto;

    public PedidoService(Estoque estoque, CalculadoraFrete calculadoraFrete, AplicadorDesconto aplicadorDesconto) {
        this.estoque = estoque;
        this.calculadoraFrete = calculadoraFrete;
        this.aplicadorDesconto = aplicadorDesconto;
    }

    /**
     * Valida o pedido, reserva os itens no estoque e retorna o valor
     * final (produtos + frete - desconto).
     *
     * @throws PedidoInvalidoException se o pedido não tiver itens ou
     *         não possuir cliente associado.
     * @throws EstoqueInsuficienteException se algum item não tiver
     *         quantidade suficiente em estoque.
     */
    public double processar(Pedido pedido) {
        validar(pedido);

        for (ItemPedido item : pedido.getItens()) {
            estoque.reservar(item.getProduto(), item.getQuantidade());
        }

        double valorProdutos = pedido.getValorTotalProdutos();
        double frete = calculadoraFrete.calcularFrete(pedido.getPesoTotal(), pedido.getRegiaoEntrega());

        // Simplificação didática: usa a categoria do primeiro item como
        // categoria de referência para o cálculo de desconto.
        String categoriaReferencia = pedido.getItens().get(0).getProduto().getCategoria();
        double valorComDesconto = aplicadorDesconto.calcularValorComDesconto(
            pedido.getCliente().getTipo(), valorProdutos, categoriaReferencia);

        return valorComDesconto + frete;
    }

    /**
     * TODO (funcionalidade futura - Sprint 5): implementar frete
     * grátis para clientes ATACADO cujo valor total do pedido
     * ultrapasse R$ 1000,00. Ainda não implementado.
     */
    public double processarComFreteGratisAtacado(Pedido pedido) {
        throw new UnsupportedOperationException("Frete grátis para atacado ainda não implementado");
    }

    private void validar(Pedido pedido) {
        if (pedido.getCliente() == null) {
            throw new PedidoInvalidoException("Pedido sem cliente associado");
        }
        if (pedido.getItens().isEmpty()) {
            throw new PedidoInvalidoException("Pedido sem itens");
        }
    }
}
