package com.loja.carrinho.model;

/** Produto do catálogo. Preço em reais, peso em kg. */
public class Produto {
    private final String codigo;
    private final String nome;
    private final double preco;
    private final double pesoKg;

    public Produto(String codigo, String nome, double preco, double pesoKg) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.pesoKg = pesoKg;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public double getPesoKg() { return pesoKg; }
}
