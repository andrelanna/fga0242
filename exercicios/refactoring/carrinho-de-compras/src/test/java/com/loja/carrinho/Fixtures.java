package com.loja.carrinho;

import com.loja.carrinho.model.*;

/**
 * Fábrica de objetos de teste. Se a assinatura de um construtor precisar
 * mudar ao longo do exercício, ajuste APENAS aqui.
 */
public final class Fixtures {
    private Fixtures() {}

    public static Cliente cliente(TipoCliente tipo) {
        return new Cliente("Maria Silva", tipo, "Rua das Flores", 120, "Brasília", "70000-123");
    }

    public static Cliente clienteComCep(String cep) {
        return new Cliente("Maria Silva", TipoCliente.PADRAO, "Rua das Flores", 120, "Brasília", cep);
    }

    public static Produto caneca()   { return new Produto("P1", "Caneca", 40.0, 0.5); }
    public static Produto mochila()  { return new Produto("P2", "Mochila", 200.0, 1.5); }

    public static TabelaFrete tabela() { return new TabelaFrete(10.0, 2.0, 300.0); }

    public static Carrinho carrinho(TipoCliente tipo, Produto p, int qtd) {
        Carrinho c = new Carrinho(cliente(tipo));
        c.adicionar(p, qtd);
        return c;
    }
}
