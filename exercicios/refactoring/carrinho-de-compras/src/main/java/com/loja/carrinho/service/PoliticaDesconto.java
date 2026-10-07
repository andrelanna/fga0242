package com.loja.carrinho.service;

import com.loja.carrinho.model.Carrinho;

/** Política de desconto por fidelidade. */
public class PoliticaDesconto {

    public double percentualFidelidade(Carrinho carrinho) {
        return carrinho.getPercentualDescontoFidelidade();
    }
}
