package fga0242.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {

    private final Cliente cliente;
    private final List<ItemPedido> itens;
    private final String regiaoEntrega; // "DF", "GO", "OUTROS"

    public Pedido(Cliente cliente, List<ItemPedido> itens, String regiaoEntrega) {
        this.cliente = cliente;
        this.itens = new ArrayList<>(itens);
        this.regiaoEntrega = regiaoEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public String getRegiaoEntrega() {
        return regiaoEntrega;
    }

    public double getValorTotalProdutos() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public double getPesoTotal() {
        double peso = 0.0;
        for (ItemPedido item : itens) {
            peso += item.getPesoTotal();
        }
        return peso;
    }
}
