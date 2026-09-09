package fga0242.service;

import fga0242.model.TipoCliente;

/**
 * Concentra as regras de desconto comercial da cooperativa AgroMart.
 *
 * Regras de negócio (RN):
 *  RN01 - Produtos da categoria "INSUMOS" nunca recebem desconto,
 *         independentemente do tipo de cliente ou do valor do pedido.
 *  RN02 - Cliente COOPERADO recebe 10% de desconto quando o valor total
 *         do pedido é >= 100.0.
 *  RN03 - Cliente ATACADO recebe 15% de desconto quando o valor total
 *         do pedido é >= 500.0, ou 5% quando está entre 100.0 (inclusive)
 *         e 500.0 (exclusive).
 *  RN04 - Cliente VAREJO recebe 5% de desconto apenas na categoria
 *         "HORTIFRUTI", quando o valor total do pedido é >= 200.0.
 */
public class AplicadorDesconto {

    private static final String CATEGORIA_INSUMOS = "INSUMOS";
    private static final String CATEGORIA_HORTIFRUTI = "HORTIFRUTI";

    /**
     * Calcula o percentual de desconto (ex.: 0.10 = 10%) aplicável a um
     * pedido, de acordo com o tipo de cliente, o valor total do pedido
     * e a categoria predominante dos produtos.
     */
    public double calcularPercentualDesconto(TipoCliente tipoCliente, double valorTotalPedido, String categoriaProduto) {
        if (CATEGORIA_INSUMOS.equals(categoriaProduto)) {
            return 0.0;
        }

        switch (tipoCliente) {
            case COOPERADO:
                return valorTotalPedido >= 100.0 ? 0.10 : 0.0;
            case ATACADO:
                if (valorTotalPedido >= 500.0) {
                    return 0.15;
                }
                return valorTotalPedido >= 100.0 ? 0.05 : 0.0;
            case VAREJO:
                boolean elegivel = CATEGORIA_HORTIFRUTI.equals(categoriaProduto) && valorTotalPedido >= 200.0;
                return elegivel ? 0.05 : 0.0;
            default:
                return 0.0;
        }
    }

    public boolean isElegivelParaDesconto(TipoCliente tipoCliente, double valorTotalPedido, String categoriaProduto) {
        return calcularPercentualDesconto(tipoCliente, valorTotalPedido, categoriaProduto) > 0.0;
    }

    public double calcularValorComDesconto(TipoCliente tipoCliente, double valorTotalPedido, String categoriaProduto) {
        double percentual = calcularPercentualDesconto(tipoCliente, valorTotalPedido, categoriaProduto);
        return valorTotalPedido * (1 - percentual);
    }
}
