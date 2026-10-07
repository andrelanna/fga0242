package com.loja.carrinho.model;

/** Linha do carrinho: produto + quantidade. */
public class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public double getPeso() {
        return produto.getPesoKg() * quantidade;
    }
}
