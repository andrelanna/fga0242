package com.loja.carrinho.model;

import static org.junit.Assert.*;

import com.loja.carrinho.Fixtures;
import org.junit.Test;

/** Comportamento de Cliente (dados cadastrais e endereço). */
public class ClienteTest {

    @Test
    public void formataEndereco() {
        assertEquals("Rua das Flores, 120 - Brasília (CEP 70000-123)",
                Fixtures.cliente(TipoCliente.PADRAO).getEnderecoFormatado());
    }

    @Test
    public void cepNoFormatoCorretoEhValido() {
        assertTrue(Fixtures.clienteComCep("70000-123").isCepValido());
    }

    @Test
    public void cepSemHifenEhInvalido() {
        assertFalse(Fixtures.clienteComCep("70000123").isCepValido());
    }

    @Test
    public void cepNuloEhInvalido() {
        assertFalse(Fixtures.clienteComCep(null).isCepValido());
    }
}
