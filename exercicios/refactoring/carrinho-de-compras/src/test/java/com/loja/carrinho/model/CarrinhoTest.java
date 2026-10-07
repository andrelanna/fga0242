package com.loja.carrinho.model;

import static org.junit.Assert.*;

import com.loja.carrinho.Fixtures;
import org.junit.Before;
import org.junit.Test;

/** Comportamento do carrinho (itens, subtotal, peso). */
public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void setUp() {
        carrinho = new Carrinho(Fixtures.cliente(TipoCliente.PADRAO));
        carrinho.adicionar(Fixtures.caneca(), 2);   // 80,00 / 1,0 kg
        carrinho.adicionar(Fixtures.mochila(), 1);  // 200,00 / 1,5 kg
    }

    @Test
    public void somaSubtotalDosItens() {
        assertEquals(280.0, carrinho.getSubtotal(), 0.001);
    }

    @Test
    public void somaPesoDosItens() {
        assertEquals(2.5, carrinho.getPesoTotal(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void quantidadeZeroEhRejeitada() {
        carrinho.adicionar(Fixtures.caneca(), 0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listaDeItensEhSomenteLeitura() {
        carrinho.getItens().clear();
    }
}
