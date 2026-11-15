package supercompras;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Sistema EXTERNO de um supermercado. Não é confiável: pode falhar, demorar,
 * devolver lixo ou até tentar alterar os dados que recebe.
 *
 * CONTRATO CONGELADO: não altere esta interface.
 */
public interface Mercado {

    /** Nome do mercado (usado como critério de desempate). */
    String nome();

    /**
     * Cotação do lote inteiro.
     *
     * @param itens SKU -> quantidade total do lote
     * @return SKU -> preço unitário (com o desconto por quantidade já aplicado pelo mercado).
     *         A ausência de um SKU significa "não temos esse item".
     */
    Map<String, BigDecimal> cotarPrecosUnitarios(Map<String, Integer> itens) throws MercadoIndisponivelException;

    /** Frete para entregar o lote. */
    BigDecimal frete(Map<String, Integer> itens) throws MercadoIndisponivelException;

    /**
     * Confirma a compra do lote aos preços informados.
     *
     * @return protocolo da compra (não vazio quando a compra foi aceita)
     */
    String comprar(Map<String, Integer> itens, Map<String, BigDecimal> precosUnitarios)
            throws MercadoIndisponivelException;
}
