package com.loja.carrinho.model;

/** Resultado do fechamento de um pedido. Valores em reais. */
public class Fatura {
    private final double subtotal;
    private final double descontoFidelidade;
    private final double descontoCupom;
    private final double frete;
    private final double juros;
    private final double total;
    private final int parcelas;
    private final double valorParcela;
    private final double ultimaParcela;
    private final int pontos;

    public Fatura(double subtotal, double descontoFidelidade, double descontoCupom,
                  double frete, double juros, double total, int parcelas,
                  double valorParcela, double ultimaParcela, int pontos) {
        this.subtotal = subtotal;
        this.descontoFidelidade = descontoFidelidade;
        this.descontoCupom = descontoCupom;
        this.frete = frete;
        this.juros = juros;
        this.total = total;
        this.parcelas = parcelas;
        this.valorParcela = valorParcela;
        this.ultimaParcela = ultimaParcela;
        this.pontos = pontos;
    }

    public double getSubtotal() { return subtotal; }
    public double getDescontoFidelidade() { return descontoFidelidade; }
    public double getDescontoCupom() { return descontoCupom; }
    public double getFrete() { return frete; }
    public double getJuros() { return juros; }
    public double getTotal() { return total; }
    public int getParcelas() { return parcelas; }
    public double getValorParcela() { return valorParcela; }
    public double getUltimaParcela() { return ultimaParcela; }
    public int getPontos() { return pontos; }
}
