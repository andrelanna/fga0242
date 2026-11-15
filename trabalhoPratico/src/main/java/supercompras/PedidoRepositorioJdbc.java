package supercompras;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PedidoRepositorioJdbc implements PedidoRepositorio {
    Connection c;

    public PedidoRepositorioJdbc(Connection c) {
        this.c = c;
        try {
            Statement s = c.createStatement();
            s.execute("CREATE TABLE IF NOT EXISTS pedido (id VARCHAR(200) PRIMARY KEY, comprador_id VARCHAR(100), "
                    + "mercado VARCHAR(200), protocolo VARCHAR(200), subtotal DECIMAL(19,2), frete DECIMAL(19,2), total DECIMAL(19,2))");
            s.execute("CREATE TABLE IF NOT EXISTS pedido_item (pedido_id VARCHAR(200), sku VARCHAR(20), "
                    + "quantidade INT, valor DECIMAL(19,2))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvar(Pedido p) {
        try {
            Statement s = c.createStatement();
            s.executeUpdate("INSERT INTO pedido VALUES ('" + p.getId() + "', '" + p.getCompradorId() + "', '"
                    + p.getMercado() + "', '" + p.getProtocolo() + "', " + p.getSubtotal() + ", " + p.getFrete()
                    + ", " + p.getTotal() + ")");
            for (Map.Entry<String, Integer> e : p.getItens().entrySet()) {
                s.executeUpdate("INSERT INTO pedido_item VALUES ('" + p.getId() + "', '" + e.getKey() + "', "
                        + e.getValue() + ", " + p.getValoresPorSku().get(e.getKey()) + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pedido> buscarPorComprador(String compradorId) {
        List<Pedido> r = new ArrayList<>();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM pedido WHERE comprador_id = '" + compradorId + "'");
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getString("id"));
                p.setCompradorId(rs.getString("comprador_id"));
                p.setMercado(rs.getString("mercado"));
                p.setProtocolo(rs.getString("protocolo"));
                p.setSubtotal(rs.getBigDecimal("subtotal"));
                p.setFrete(rs.getBigDecimal("frete"));
                p.setTotal(rs.getBigDecimal("total"));
                Statement s2 = c.createStatement();
                ResultSet ri = s2.executeQuery("SELECT * FROM pedido_item WHERE pedido_id = '" + p.getId() + "'");
                while (ri.next()) {
                    p.getItens().put(ri.getString("sku"), ri.getInt("quantidade"));
                    p.getValoresPorSku().put(ri.getString("sku"), ri.getBigDecimal("valor"));
                }
                r.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
}
