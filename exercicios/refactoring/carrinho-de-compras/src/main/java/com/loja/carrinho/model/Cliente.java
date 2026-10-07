package com.loja.carrinho.model;

/** Cliente da loja. */
public class Cliente {
    private final String nome;
    private final TipoCliente tipo;
    private final String rua;
    private final int numero;
    private final String cidade;
    private final String cep;

    public Cliente(String nome, TipoCliente tipo,
                   String rua, int numero, String cidade, String cep) {
        this.nome = nome;
        this.tipo = tipo;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getNome() { return nome; }
    public TipoCliente getTipo() { return tipo; }

    public String getEnderecoFormatado() {
        return rua + ", " + numero + " - " + cidade + " (CEP " + cep + ")";
    }

    public boolean isCepValido() {
        return cep != null && cep.matches("\\d{5}-\\d{3}");
    }
}
