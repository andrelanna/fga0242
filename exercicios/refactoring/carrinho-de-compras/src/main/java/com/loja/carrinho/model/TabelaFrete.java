package com.loja.carrinho.model;

/** Parâmetros de cálculo de frete. */
public class TabelaFrete {
    private final double valorBase;
    private final double taxaPorKg;
    private final double limiteFreteGratis;

    public TabelaFrete(double valorBase, double taxaPorKg, double limiteFreteGratis) {
        this.valorBase = valorBase;
        this.taxaPorKg = taxaPorKg;
        this.limiteFreteGratis = limiteFreteGratis;
    }

    public double getValorBase() { return valorBase; }
    public double getTaxaPorKg() { return taxaPorKg; }
    public double getLimiteFreteGratis() { return limiteFreteGratis; }
}
