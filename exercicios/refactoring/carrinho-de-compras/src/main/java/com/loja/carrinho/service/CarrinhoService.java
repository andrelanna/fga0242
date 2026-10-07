package com.loja.carrinho.service;

import com.loja.carrinho.model.Carrinho;
import com.loja.carrinho.model.Cupom;
import com.loja.carrinho.model.Fatura;
import com.loja.carrinho.model.TabelaFrete;
import com.loja.carrinho.model.TipoCliente;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Serviço de fechamento do carrinho.
 *
 * Regras de negócio:
 *  RN01 - Carrinho vazio não pode ser fechado (IllegalStateException).
 *  RN02 - Desconto de fidelidade: OURO 10%, PRATA 5%, PADRAO 0%.
 *  RN03 - Cupom: dentro da validade, valor (após fidelidade) >= mínimo do cupom
 *         e, se exclusivo, só para clientes OURO.
 *  RN04 - Frete grátis se subtotal bruto >= limite; senão base + peso * taxa.
 *  RN05 - Prazos nunca caem em fim de semana (sábado/domingo vão para segunda).
 *  RN06 - Parcelamento de 1 a 12 vezes (IllegalArgumentException fora disso).
 *         Até 3 parcelas sem juros; acima disso, 2% do valor por parcela
 *         excedente (juros simples). A última parcela absorve a diferença de
 *         centavos.
 *  RN07 - Pontos de fidelidade: 1 ponto a cada R$ 10 do total (parte inteira);
 *         OURO recebe o dobro e PRATA uma vez e meia.
 */
public class CarrinhoService {

    private final TabelaFrete tabelaFrete;
    private final PoliticaDesconto politica = new PoliticaDesconto();

    public CarrinhoService(TabelaFrete tabelaFrete) {
        this.tabelaFrete = tabelaFrete;
    }

    public double calcularFrete(Carrinho carrinho) {
        return carrinho.calcularFrete(tabelaFrete);
    }

    public Fatura fecharPedido(Carrinho carrinho, Cupom cupom, LocalDate hoje, int parcelas) {
        if (carrinho.getItens().isEmpty()) {
            throw new IllegalStateException("Carrinho vazio");
        }
        if (parcelas < 1 || parcelas > 12) {
            throw new IllegalArgumentException("Parcelas deve estar entre 1 e 12");
        }

        double subtotal = carrinho.getSubtotal();
        double descontoFidelidade = subtotal * politica.percentualFidelidade(carrinho);
        double aposFidelidade = subtotal - descontoFidelidade;

        double descontoCupom = 0.0;
        if (cupom != null && !hoje.isAfter(cupom.getValidade())
                && aposFidelidade >= cupom.getValorMinimo()
                && (!cupom.isExclusivoOuro()
                    || carrinho.getCliente().getTipo() == TipoCliente.OURO)) {
            descontoCupom = aposFidelidade * cupom.getPercentual();
        }

        double frete = carrinho.calcularFrete(tabelaFrete);
        double base = aposFidelidade - descontoCupom + frete;

        double juros = 0.0;
        if (parcelas > 3) {
            juros = base * 0.02 * (parcelas - 3);
        }
        double total = Math.round((base + juros) * 100.0) / 100.0;

        double valorParcela = Math.round(total / parcelas * 100.0) / 100.0;
        double ultimaParcela = Math.round((total - valorParcela * (parcelas - 1)) * 100.0) / 100.0;

        int pontos = (int) (total / 10);
        if (carrinho.getCliente().getTipo() == TipoCliente.OURO) {
            pontos = pontos * 2;
        } else if (carrinho.getCliente().getTipo() == TipoCliente.PRATA) {
            pontos = pontos + pontos / 2;
        }

        return new Fatura(subtotal, descontoFidelidade, descontoCupom, frete, juros,
                total, parcelas, valorParcela, ultimaParcela, pontos);
    }

    public LocalDate prazoEntrega(LocalDate hoje) {
        LocalDate d = hoje.plusDays(3);
        if (d.getDayOfWeek() == DayOfWeek.SATURDAY) {
            d = d.plusDays(2);
        } else if (d.getDayOfWeek() == DayOfWeek.SUNDAY) {
            d = d.plusDays(1);
        }
        return d;
    }

    public LocalDate vencimentoBoleto(LocalDate hoje) {
        LocalDate d = hoje.plusDays(2);
        if (d.getDayOfWeek() == DayOfWeek.SATURDAY) {
            d = d.plusDays(2);
        } else if (d.getDayOfWeek() == DayOfWeek.SUNDAY) {
            d = d.plusDays(1);
        }
        return d;
    }

    public LocalDate prazoTroca(LocalDate hoje) {
        LocalDate d = hoje.plusDays(7);
        if (d.getDayOfWeek() == DayOfWeek.SATURDAY) {
            d = d.plusDays(2);
        } else if (d.getDayOfWeek() == DayOfWeek.SUNDAY) {
            d = d.plusDays(1);
        }
        return d;
    }
}
