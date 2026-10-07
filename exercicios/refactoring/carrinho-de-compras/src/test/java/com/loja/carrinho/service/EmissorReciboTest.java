package com.loja.carrinho.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.loja.carrinho.Fixtures;
import com.loja.carrinho.model.*;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

/** Compara o recibo gerado, caractere a caractere, com o texto esperado. */
public class EmissorReciboTest {

    private static final LocalDate HOJE = LocalDate.of(2026, 10, 5);
    private static final LocalDate ENTREGA = LocalDate.of(2026, 10, 8);
    private CarrinhoService service;
    private EmissorRecibo emissor;

    @Before
    public void setUp() {
        service = new CarrinhoService(Fixtures.tabela());
        emissor = new EmissorRecibo();
    }

    @Test
    public void reciboCompletoClienteOuroParceladoEmCinco() {
        Carrinho c = new Carrinho(Fixtures.cliente(TipoCliente.OURO));
        c.adicionar(Fixtures.caneca(), 2);
        c.adicionar(Fixtures.mochila(), 1);
        Fatura f = service.fecharPedido(c, null, HOJE, 5);

        String esperado =
            "========================================\n" +
            "LOJA ONLINE - RECIBO DE COMPRA\n" +
            "Emissao: 05/10/2026\n" +
            "========================================\n" +
            "Cliente: Maria Silva\n" +
            "Endereco: Rua das Flores, 120 - Brasília (CEP 70000-123)\n" +
            "----------------------------------------\n" +
            "Caneca           2 x    40.00 =     80.00\n" +
            "Mochila          1 x   200.00 =    200.00\n" +
            "----------------------------------------\n" +
            "Subtotal:                         280.00\n" +
            "Desconto fidelidade:              -28.00\n" +
            "Frete:                             15.00\n" +
            "Juros:                             10.68\n" +
            "TOTAL:                            277.68\n" +
            "Pagamento: 5x de 55.54 (ultima: 55.52)\n" +
            "Pontos ganhos: 54\n" +
            "Entrega prevista: 08/10/2026\n" +
            "========================================\n";
        assertEquals(esperado, emissor.emitir(c, f, HOJE, ENTREGA));
    }

    @Test
    public void reciboSimplesAVistaComFreteGratisECupom() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.mochila(), 2);
        Cupom cupom = new Cupom("PROMO", 0.10, 100.0, HOJE, false);
        Fatura f = service.fecharPedido(c, cupom, HOJE, 1);

        String esperado =
            "========================================\n" +
            "LOJA ONLINE - RECIBO DE COMPRA\n" +
            "Emissao: 05/10/2026\n" +
            "========================================\n" +
            "Cliente: Maria Silva\n" +
            "Endereco: Rua das Flores, 120 - Brasília (CEP 70000-123)\n" +
            "----------------------------------------\n" +
            "Mochila          2 x   200.00 =    400.00\n" +
            "----------------------------------------\n" +
            "Subtotal:                         400.00\n" +
            "Cupom:                            -40.00\n" +
            "Frete:                            GRATIS\n" +
            "TOTAL:                            360.00\n" +
            "Pagamento: a vista\n" +
            "Pontos ganhos: 36\n" +
            "Entrega prevista: 08/10/2026\n" +
            "========================================\n";
        assertEquals(esperado, emissor.emitir(c, f, HOJE, ENTREGA));
    }

    @Test
    public void reciboAvisaQuandoCepEhInvalido() {
        Carrinho c = new Carrinho(Fixtures.clienteComCep("700001"));
        c.adicionar(Fixtures.caneca(), 1);
        Fatura f = service.fecharPedido(c, null, HOJE, 1);
        String recibo = emissor.emitir(c, f, HOJE, ENTREGA);
        assertTrue(recibo.contains("ATENCAO: CEP invalido, confirme o endereco\n"));
    }
}
