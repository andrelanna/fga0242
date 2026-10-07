package com.loja.carrinho.model;

import java.time.LocalDate;

/** Cupom promocional. Percentual em [0,1]. */
public class Cupom {
    private final String codigo;
    private final double percentual;
    private final double valorMinimo;
    private final LocalDate validade;
    private final boolean exclusivoOuro;

    public Cupom(String codigo, double percentual, double valorMinimo,
                 LocalDate validade, boolean exclusivoOuro) {
        this.codigo = codigo;
        this.percentual = percentual;
        this.valorMinimo = valorMinimo;
        this.validade = validade;
        this.exclusivoOuro = exclusivoOuro;
    }

    public String getCodigo() { return codigo; }
    public double getPercentual() { return percentual; }
    public double getValorMinimo() { return valorMinimo; }
    public LocalDate getValidade() { return validade; }
    public boolean isExclusivoOuro() { return exclusivoOuro; }
}
