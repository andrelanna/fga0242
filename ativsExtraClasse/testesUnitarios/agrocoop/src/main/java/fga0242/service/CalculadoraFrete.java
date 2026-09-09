package fga0242.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsável pelo cálculo de frete da cooperativa AgroMart.
 */
public class CalculadoraFrete {

    private static final double BASE_DF = 8.0;
    private static final double BASE_GO = 12.0;
    private static final double BASE_OUTROS = 25.0;

    private static final double TAXA_KG_DF = 0.50;
    private static final double TAXA_KG_GO = 0.80;
    private static final double TAXA_KG_OUTROS = 1.50;

    /**
     * Calcula o valor do frete a partir do peso total do pedido e da
     * região de entrega.
     */
    public double calcularFrete(double pesoTotalKg, String regiao) {
        switch (regiao) {
            case "DF":
                return BASE_DF + pesoTotalKg * TAXA_KG_DF;
            case "GO":
                return BASE_GO + pesoTotalKg * TAXA_KG_GO;
            default:
                return BASE_OUTROS + pesoTotalKg * TAXA_KG_OUTROS;
        }
    }

    /**
     * Calcula a rota de entrega de menor distância total testando TODAS
     * as permutações possíveis dos pontos de entrega (força bruta).
     *
     * ATENÇÃO PEDAGÓGICA: a complexidade deste método é O(n!). Ele é
     * adequado apenas para pedidos com poucos pontos de entrega (na
     * prática, cooperativas pequenas raramente entregam mais que 7-8
     * pontos numa mesma rota). É exatamente esse tipo de método —
     * correto, porém sensível ao tamanho da entrada — que justifica a
     * existência de testes com timeout: eles funcionam como uma rede de
     * segurança contra regressões de desempenho.
     */
    public double calcularRotaMaisEconomica(List<String> pontosDeEntrega, double[][] distancias) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 1; i < pontosDeEntrega.size(); i++) {
            indices.add(i);
        }
        return menorDistancia(0, indices, distancias);
    }

    private double menorDistancia(int origem, List<Integer> restantes, double[][] distancias) {
        if (restantes.isEmpty()) {
            return 0.0;
        }
        double menor = Double.MAX_VALUE;
        for (int i = 0; i < restantes.size(); i++) {
            int proximo = restantes.get(i);
            List<Integer> semProximo = new ArrayList<>(restantes);
            semProximo.remove(i);
            double distancia = distancias[origem][proximo] + menorDistancia(proximo, semProximo, distancias);
            menor = Math.min(menor, distancia);
        }
        return menor;
    }
}
