package com.loja.carrinho.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Carrinho de compras de um cliente. */
public class Carrinho {
    private final Cliente cliente;
    private final List<ItemCarrinho> itens = new ArrayList<>();
    private final double percentualDescontoFidelidade;

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
        switch (cliente.getTipo()) {
            case OURO:  this.percentualDescontoFidelidade = 0.10; break;
            case PRATA: this.percentualDescontoFidelidade = 0.05; break;
            default:    this.percentualDescontoFidelidade = 0.0;
        }
    }

    public Cliente getCliente() { return cliente; }
    public List<ItemCarrinho> getItens() { return Collections.unmodifiableList(itens); }
    public double getPercentualDescontoFidelidade() { return percentualDescontoFidelidade; }

    public void adicionar(Produto produto, int quantidade) {
        itens.add(new ItemCarrinho(produto, quantidade));
    }

    public double getSubtotal() {
        double total = 0;
        for (ItemCarrinho i : itens) {
            total += i.getSubtotal();
        }
        return total;
    }

    public double getPesoTotal() {
        double peso = 0;
        for (ItemCarrinho i : itens) {
            peso += i.getPeso();
        }
        return peso;
    }

    public double calcularFrete(TabelaFrete tabela) {
        if (getSubtotal() >= tabela.getLimiteFreteGratis()) {
            return 0.0;
        }
        return tabela.getValorBase() + getPesoTotal() * tabela.getTaxaPorKg();
    }
}
