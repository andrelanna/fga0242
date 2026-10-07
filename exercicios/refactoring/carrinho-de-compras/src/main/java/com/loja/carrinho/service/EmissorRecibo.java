package com.loja.carrinho.service;

import com.loja.carrinho.model.Carrinho;
import com.loja.carrinho.model.Cliente;
import com.loja.carrinho.model.Fatura;
import com.loja.carrinho.model.ItemCarrinho;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/** Gera o recibo textual de uma compra. */
public class EmissorRecibo {

    public String emitir(Carrinho carrinho, Fatura fatura, LocalDate emissao, LocalDate entrega) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("========================================\n");
        sb.append("LOJA ONLINE - RECIBO DE COMPRA\n");
        sb.append("Emissao: ").append(emissao.format(fmt)).append("\n");
        sb.append("========================================\n");

        Cliente cliente = carrinho.getCliente();
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Endereco: ").append(cliente.getEnderecoFormatado()).append("\n");
        if (!cliente.isCepValido()) {
            sb.append("ATENCAO: CEP invalido, confirme o endereco\n");
        }
        sb.append("----------------------------------------\n");

        for (ItemCarrinho item : carrinho.getItens()) {
            sb.append(String.format(Locale.ROOT, "%-14s %3d x %8.2f = %9.2f\n",
                    item.getProduto().getNome(), item.getQuantidade(),
                    item.getProduto().getPreco(), item.getSubtotal()));
        }
        sb.append("----------------------------------------\n");

        sb.append(String.format(Locale.ROOT, "%-30s %9.2f\n", "Subtotal:", fatura.getSubtotal()));
        if (fatura.getDescontoFidelidade() > 0) {
            sb.append(String.format(Locale.ROOT, "%-30s %9.2f\n", "Desconto fidelidade:",
                    -fatura.getDescontoFidelidade()));
        }
        if (fatura.getDescontoCupom() > 0) {
            sb.append(String.format(Locale.ROOT, "%-30s %9.2f\n", "Cupom:",
                    -fatura.getDescontoCupom()));
        }
        if (fatura.getFrete() == 0) {
            sb.append(String.format(Locale.ROOT, "%-30s %9s\n", "Frete:", "GRATIS"));
        } else {
            sb.append(String.format(Locale.ROOT, "%-30s %9.2f\n", "Frete:", fatura.getFrete()));
        }
        if (fatura.getJuros() > 0) {
            sb.append(String.format(Locale.ROOT, "%-30s %9.2f\n", "Juros:", fatura.getJuros()));
        }
        sb.append(String.format(Locale.ROOT, "%-30s %9.2f\n", "TOTAL:", fatura.getTotal()));

        if (fatura.getParcelas() == 1) {
            sb.append("Pagamento: a vista\n");
        } else {
            sb.append(String.format(Locale.ROOT, "Pagamento: %dx de %.2f (ultima: %.2f)\n",
                    fatura.getParcelas(), fatura.getValorParcela(), fatura.getUltimaParcela()));
        }
        sb.append("Pontos ganhos: ").append(fatura.getPontos()).append("\n");
        sb.append("Entrega prevista: ").append(entrega.format(fmt)).append("\n");
        sb.append("========================================\n");

        return sb.toString();
    }
}
