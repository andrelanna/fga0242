package supercompras;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * TESTE DE CONTRATO (visível, entregue pelo professor).
 *
 * Ele só verifica que a API pública CONGELADA continua existindo com as mesmas assinaturas.
 * Se este teste deixar de COMPILAR, a suíte oculta também não compila e a nota de testes é ZERO.
 * Não apague, não altere. Rode-o a cada commit.
 */
public class ContratoApiTest {

    @Test
    public void contratoDaApiContinuaCompilando() throws Exception {
        Mercado mercado = new Mercado() {
            @Override
            public String nome() {
                return "Mercado Teste";
            }

            @Override
            public Map<String, BigDecimal> cotarPrecosUnitarios(Map<String, Integer> itens)
                    throws MercadoIndisponivelException {
                Map<String, BigDecimal> precos = new HashMap<>();
                for (String sku : itens.keySet()) {
                    precos.put(sku, new BigDecimal("2.50"));
                }
                return precos;
            }

            @Override
            public BigDecimal frete(Map<String, Integer> itens) throws MercadoIndisponivelException {
                return new BigDecimal("1.00");
            }

            @Override
            public String comprar(Map<String, Integer> itens, Map<String, BigDecimal> precosUnitarios)
                    throws MercadoIndisponivelException {
                return "PROTO-1";
            }
        };
        PedidoRepositorio repoNulo = new PedidoRepositorio() {
            @Override
            public void salvar(Pedido pedido) {
            }

            @Override
            public List<Pedido> buscarPorComprador(String compradorId) {
                return List.of();
            }
        };

        SistemaCompras sistema = new SistemaCompras(List.of(mercado), repoNulo);
        Map<String, Integer> itens = new HashMap<>();
        itens.put("LEI-0001", 2);
        sistema.receberLista("ana", itens);
        ResultadoRodada resultado = sistema.fecharRodada();

        assertNotNull(resultado.getMercadoVencedor());
        assertNotNull(resultado.getProtocolo());
        assertNotNull(resultado.getTotalLote());
        List<Pedido> pedidos = resultado.getPedidos();
        Pedido p = pedidos.get(0);
        assertNotNull(p.getId());
        assertNotNull(p.getCompradorId());
        assertNotNull(p.getMercado());
        assertNotNull(p.getProtocolo());
        assertNotNull(p.getItens());
        assertNotNull(p.getValoresPorSku());
        assertNotNull(p.getSubtotal());
        assertNotNull(p.getFrete());
        assertNotNull(p.getTotal());

        try (Connection c = DriverManager.getConnection("jdbc:h2:mem:contrato;DB_CLOSE_DELAY=-1")) {
            PedidoRepositorio jdbc = new PedidoRepositorioJdbc(c);
            jdbc.salvar(p);
            assertNotNull(jdbc.buscarPorComprador("ana"));
        }

        // as exceções do contrato existem, com estes construtores
        new MercadoIndisponivelException("x");
        new MercadoIndisponivelException("x", new RuntimeException());
        new EntradaInvalidaException("x");
        new SemCotacaoValidaException("x");
        new CompraNaoRealizadaException("x");
        new PersistenciaException("x", new RuntimeException());
    }
}
