package supercompras;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResultadoRodada {
    public String mercadoVencedor;
    public String protocolo;
    public BigDecimal totalLote;
    public List<Pedido> pedidos = new ArrayList<>();

    public String getMercadoVencedor() { return mercadoVencedor; }
    public String getProtocolo() { return protocolo; }
    public BigDecimal getTotalLote() { return totalLote; }
    public List<Pedido> getPedidos() { return pedidos; }
}
