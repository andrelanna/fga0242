package com.loja.carrinho.service;

import static org.junit.Assert.assertEquals;

import com.loja.carrinho.Fixtures;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Prazos de entrega, boleto e troca (RN05).
 * Cada tupla: data de hoje, prazo de entrega, vencimento do boleto, prazo de troca.
 * Datas em 2026 — 05/10 é segunda-feira.
 */
@RunWith(Parameterized.class)
public class PrazosParametrizadoTest {

    @Parameters(name = "hoje={0}")
    public static Collection<Object[]> dados() {
        return Arrays.asList(new Object[][] {
            // hoje             entrega (+3)        boleto (+2)         troca (+7)
            {LocalDate.of(2026, 10, 5),  LocalDate.of(2026, 10, 8),  LocalDate.of(2026, 10, 7),  LocalDate.of(2026, 10, 12)}, // seg
            {LocalDate.of(2026, 10, 6),  LocalDate.of(2026, 10, 9),  LocalDate.of(2026, 10, 8),  LocalDate.of(2026, 10, 13)}, // ter
            {LocalDate.of(2026, 10, 7),  LocalDate.of(2026, 10, 12), LocalDate.of(2026, 10, 9),  LocalDate.of(2026, 10, 14)}, // qua: +3 = sáb -> seg
            {LocalDate.of(2026, 10, 8),  LocalDate.of(2026, 10, 12), LocalDate.of(2026, 10, 12), LocalDate.of(2026, 10, 15)}, // qui: +3 = dom -> seg ; +2 = sáb -> seg
            {LocalDate.of(2026, 10, 9),  LocalDate.of(2026, 10, 12), LocalDate.of(2026, 10, 12), LocalDate.of(2026, 10, 16)}, // sex: +2 = dom -> seg
            {LocalDate.of(2026, 10, 10), LocalDate.of(2026, 10, 13), LocalDate.of(2026, 10, 12), LocalDate.of(2026, 10, 19)}, // sáb: +7 = sáb -> seg
        });
    }

    private final LocalDate hoje, entrega, boleto, troca;

    public PrazosParametrizadoTest(LocalDate hoje, LocalDate entrega, LocalDate boleto, LocalDate troca) {
        this.hoje = hoje; this.entrega = entrega; this.boleto = boleto; this.troca = troca;
    }

    private final CarrinhoService service = new CarrinhoService(Fixtures.tabela());

    @Test public void prazoDeEntrega()      { assertEquals(entrega, service.prazoEntrega(hoje)); }
    @Test public void vencimentoDoBoleto()  { assertEquals(boleto,  service.vencimentoBoleto(hoje)); }
    @Test public void prazoDeTroca()        { assertEquals(troca,   service.prazoTroca(hoje)); }
}
