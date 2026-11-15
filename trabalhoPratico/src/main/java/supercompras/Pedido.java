package supercompras;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private String id;
    private String compradorId;
    private String mercado;
    private String protocolo;
    private Map<String, Integer> itens = new HashMap<>();
    private Map<String, BigDecimal> valoresPorSku = new HashMap<>();
    private BigDecimal subtotal;
    private BigDecimal frete;
    private BigDecimal total;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCompradorId() { return compradorId; }
    public void setCompradorId(String compradorId) { this.compradorId = compradorId; }
    public String getMercado() { return mercado; }
    public void setMercado(String mercado) { this.mercado = mercado; }
    public String getProtocolo() { return protocolo; }
    public void setProtocolo(String protocolo) { this.protocolo = protocolo; }
    public Map<String, Integer> getItens() { return itens; }
    public void setItens(Map<String, Integer> itens) { this.itens = itens; }
    public Map<String, BigDecimal> getValoresPorSku() { return valoresPorSku; }
    public void setValoresPorSku(Map<String, BigDecimal> v) { this.valoresPorSku = v; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    public BigDecimal getFrete() { return frete; }
    public void setFrete(BigDecimal frete) { this.frete = frete; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
