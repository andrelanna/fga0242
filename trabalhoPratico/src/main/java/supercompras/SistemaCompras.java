package supercompras;

import java.math.BigDecimal;
import java.util.*;

/**
 * Compras coletivas de supermercado.
 * (código legado: funciona "na maioria dos casos")
 */
public class SistemaCompras {
    public List<Mercado> mercados;
    public PedidoRepositorio repo;
    public Map<String, Map<String, Integer>> listas = new LinkedHashMap<>();
    static int contador = 0;

    public SistemaCompras(List<Mercado> mercados, PedidoRepositorio repo) {
        this.mercados = mercados;
        this.repo = repo;
    }

    // recebe a lista de um comprador
    public void receberLista(String compradorId, Map<String, Integer> itens) {
        System.out.println("Recebendo lista de " + compradorId + " com itens " + itens);
        if (itens == null) {
            return;
        }
        listas.put(compradorId, itens);
    }

    // fecha a rodada: cota, compra e divide
    public ResultadoRodada fecharRodada() {
        contador++;
        // junta todas as listas
        Map<String, Integer> lote = new TreeMap<>();
        for (String c : listas.keySet()) {
            Map<String, Integer> l = listas.get(c);
            for (String sku : l.keySet()) {
                if (lote.containsKey(sku)) {
                    lote.put(sku, lote.get(sku) + l.get(sku));
                } else {
                    lote.put(sku, l.get(sku));
                }
            }
        }
        // pede cotacao pra todo mundo
        Mercado vencedor = null;
        double melhorTotal = 999999999;
        Map<String, BigDecimal> melhorPrecos = null;
        for (Mercado m : mercados) {
            double total = 0;
            Map<String, BigDecimal> precos = null;
            try {
                precos = m.cotarPrecosUnitarios(lote);
                for (String sku : lote.keySet()) {
                    BigDecimal p = precos.get(sku);
                    if (p == null) {
                        total += 0;
                    } else {
                        total += p.doubleValue() * lote.get(sku);
                    }
                }
                // frete a gente soma depois
            } catch (Throwable t) {
                System.out.println("erro no mercado " + m.nome());
                continue;
            }
            if (total < melhorTotal) {
                melhorTotal = total;
                vencedor = m;
                melhorPrecos = precos;
            }
        }
        // compra
        String protocolo = null;
        try {
            protocolo = vencedor.comprar(lote, melhorPrecos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultadoRodada r = new ResultadoRodada();
        r.mercadoVencedor = vencedor.nome();
        r.protocolo = protocolo;
        BigDecimal freteLote = null;
        try {
            freteLote = vencedor.frete(lote);
        } catch (Exception e) {
        }
        double totalLote = 0;
        // divide entre os compradores
        for (String c : listas.keySet()) {
            Map<String, Integer> l = listas.get(c);
            Pedido p = new Pedido();
            p.setId(protocolo + "-" + c);
            p.setCompradorId(c);
            p.setMercado(vencedor.nome());
            p.setProtocolo(protocolo);
            p.setItens(l);
            double sub = 0;
            Map<String, BigDecimal> valores = new HashMap<>();
            for (String sku : l.keySet()) {
                double v = melhorPrecos.get(sku).doubleValue() * l.get(sku);
                v = Math.round(v * 100) / 100.0;
                valores.put(sku, BigDecimal.valueOf(v));
                sub += v;
            }
            p.setValoresPorSku(valores);
            p.setSubtotal(BigDecimal.valueOf(sub));
            double f = freteLote.doubleValue() / listas.size();
            p.setFrete(BigDecimal.valueOf(Math.round(f * 100) / 100.0));
            p.setTotal(BigDecimal.valueOf(Math.round((sub + f) * 100) / 100.0));
            totalLote += sub + f;
            r.pedidos.add(p);
            repo.salvar(p);
        }
        r.totalLote = BigDecimal.valueOf(Math.round(totalLote * 100) / 100.0);
        listas.clear();
        return r;
    }
}
