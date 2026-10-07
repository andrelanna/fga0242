package com.loja.carrinho.service;

import static org.junit.Assert.*;

import com.loja.carrinho.Fixtures;
import com.loja.carrinho.model.*;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

/** Regras RN01 a RN04, RN06 e RN07, observadas pela API pública do serviço. */
public class FechamentoPedidoTest {

    private static final LocalDate HOJE = LocalDate.of(2026, 10, 5);
    private static final double DELTA = 0.001;
    private CarrinhoService service;

    @Before
    public void setUp() {
        service = new CarrinhoService(Fixtures.tabela());
    }

    private Cupom cupom(double pct, double minimo, LocalDate validade, boolean ouro) {
        return new Cupom("PROMO", pct, minimo, validade, ouro);
    }

    // ---------- validações ----------

    @Test(expected = IllegalStateException.class)
    public void carrinhoVazioNaoPodeSerFechado() {
        service.fecharPedido(new Carrinho(Fixtures.cliente(TipoCliente.PADRAO)), null, HOJE, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroParcelasEhRejeitado() {
        service.fecharPedido(Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.caneca(), 1), null, HOJE, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void maisDeDozeParcelasEhRejeitado() {
        service.fecharPedido(Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.caneca(), 1), null, HOJE, 13);
    }

    // ---------- valores básicos ----------

    @Test
    public void pedidoSimplesAVistaComFrete() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.caneca(), 2); // 80,00; 1,0 kg
        Fatura f = service.fecharPedido(c, null, HOJE, 1);
        assertEquals(80.0, f.getSubtotal(), DELTA);
        assertEquals(0.0, f.getDescontoFidelidade(), DELTA);
        assertEquals(12.0, f.getFrete(), DELTA);
        assertEquals(0.0, f.getJuros(), DELTA);
        assertEquals(92.0, f.getTotal(), DELTA);
        assertEquals(92.0, f.getValorParcela(), DELTA);
        assertEquals(92.0, f.getUltimaParcela(), DELTA);
    }

    @Test
    public void clienteOuroTemDescontoEFreteGratis() {
        Carrinho c = Fixtures.carrinho(TipoCliente.OURO, Fixtures.mochila(), 2); // 400
        Fatura f = service.fecharPedido(c, null, HOJE, 1);
        assertEquals(40.0, f.getDescontoFidelidade(), DELTA);
        assertEquals(0.0, f.getFrete(), DELTA);
        assertEquals(360.0, f.getTotal(), DELTA);
    }

    @Test
    public void clientePrataTemDescontoDeCincoPorCento() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PRATA, Fixtures.mochila(), 1); // 200
        Fatura f = service.fecharPedido(c, null, HOJE, 1);
        assertEquals(10.0, f.getDescontoFidelidade(), DELTA);
        assertEquals(13.0, f.getFrete(), DELTA);
        assertEquals(203.0, f.getTotal(), DELTA);
    }

    @Test
    public void totalEhArredondadoParaCentavos() {
        Produto p = new Produto("P3", "Cabo", 10.333, 0.1);
        Fatura f = service.fecharPedido(Fixtures.carrinho(TipoCliente.PADRAO, p, 1), null, HOJE, 1);
        assertEquals(20.53, f.getTotal(), 0.0001); // 10,333 + 10,20
    }

    @Test
    public void freteEhCobradoPorPeso() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.caneca(), 2);
        assertEquals(12.0, service.calcularFrete(c), DELTA);
    }

    @Test
    public void freteEhGratisExatamenteNoLimite() {
        Produto p = new Produto("P4", "Fone", 300.0, 0.2);
        Carrinho c = Fixtures.carrinho(TipoCliente.PADRAO, p, 1);
        assertEquals(0.0, service.calcularFrete(c), DELTA);
    }

    // ---------- cupom (RN03) ----------

    @Test
    public void cupomValidoAplicaPercentual() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.mochila(), 2);
        Fatura f = service.fecharPedido(c, cupom(0.10, 100.0, HOJE, false), HOJE, 1);
        assertEquals(40.0, f.getDescontoCupom(), DELTA);
        assertEquals(360.0, f.getTotal(), DELTA);
    }

    @Test
    public void cupomVencidoNaoAplica() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.mochila(), 2);
        Fatura f = service.fecharPedido(c, cupom(0.10, 100.0, HOJE.minusDays(1), false), HOJE, 1);
        assertEquals(400.0, f.getTotal(), DELTA);
    }

    @Test
    public void cupomAbaixoDoMinimoNaoAplica() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.mochila(), 2);
        Fatura f = service.fecharPedido(c, cupom(0.10, 500.0, HOJE, false), HOJE, 1);
        assertEquals(400.0, f.getTotal(), DELTA);
    }

    @Test
    public void cupomExclusivoOuroNaoAplicaParaPrata() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PRATA, Fixtures.mochila(), 2);
        Fatura f = service.fecharPedido(c, cupom(0.10, 100.0, HOJE, true), HOJE, 1);
        assertEquals(380.0, f.getTotal(), DELTA);
    }

    @Test
    public void cupomExclusivoOuroAplicaParaOuro() {
        Carrinho c = Fixtures.carrinho(TipoCliente.OURO, Fixtures.mochila(), 2);
        Fatura f = service.fecharPedido(c, cupom(0.10, 100.0, HOJE, true), HOJE, 1);
        assertEquals(36.0, f.getDescontoCupom(), DELTA);
        assertEquals(324.0, f.getTotal(), DELTA);
    }

    // ---------- parcelamento (RN06) ----------

    @Test
    public void ateTresParcelasNaoTemJuros() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.mochila(), 2); // 400
        Fatura f = service.fecharPedido(c, null, HOJE, 3);
        assertEquals(0.0, f.getJuros(), DELTA);
        assertEquals(133.33, f.getValorParcela(), DELTA);
        assertEquals(133.34, f.getUltimaParcela(), DELTA); // absorve os centavos
    }

    @Test
    public void acimaDeTresParcelasCobraJurosSimples() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.mochila(), 2); // 400
        Fatura f = service.fecharPedido(c, null, HOJE, 6);
        assertEquals(24.0, f.getJuros(), DELTA);   // 400 * 2% * 3
        assertEquals(424.0, f.getTotal(), DELTA);
        assertEquals(70.67, f.getValorParcela(), DELTA);
        assertEquals(70.65, f.getUltimaParcela(), DELTA);
    }

    @Test
    public void jurosIncidemSobreValorJaComDescontoEFrete() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PRATA, Fixtures.mochila(), 1); // 190 + 13
        Fatura f = service.fecharPedido(c, null, HOJE, 12);
        assertEquals(36.54, f.getJuros(), DELTA);   // 203 * 2% * 9
        assertEquals(239.54, f.getTotal(), DELTA);
    }

    // ---------- pontos (RN07) ----------

    @Test
    public void pontosParaClientePadrao() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PADRAO, Fixtures.caneca(), 2); // total 92
        assertEquals(9, service.fecharPedido(c, null, HOJE, 1).getPontos());
    }

    @Test
    public void pontosParaClientePrata() {
        Carrinho c = Fixtures.carrinho(TipoCliente.PRATA, Fixtures.mochila(), 1); // total 203 -> 20
        assertEquals(30, service.fecharPedido(c, null, HOJE, 1).getPontos());
    }

    @Test
    public void pontosParaClienteOuro() {
        Carrinho c = Fixtures.carrinho(TipoCliente.OURO, Fixtures.mochila(), 2); // total 360 -> 36
        assertEquals(72, service.fecharPedido(c, null, HOJE, 1).getPontos());
    }
}
