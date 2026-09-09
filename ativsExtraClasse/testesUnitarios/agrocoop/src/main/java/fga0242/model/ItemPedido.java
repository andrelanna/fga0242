package fga0242.model;

public class ItemPedido {

    private final Produto produto;
    private final int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return produto.getPrecoUnitario() * quantidade;
    }

    public double getPesoTotal() {
        return produto.getPesoKg() * quantidade;
    }
}
