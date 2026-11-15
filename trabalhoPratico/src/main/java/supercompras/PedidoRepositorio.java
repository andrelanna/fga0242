package supercompras;

import java.util.List;

/** CONTRATO CONGELADO. */
public interface PedidoRepositorio {

    /** Grava o pedido. Falhas viram {@link PersistenciaException}. */
    void salvar(Pedido pedido);

    /** Pedidos de um comprador (lista vazia se não houver). */
    List<Pedido> buscarPorComprador(String compradorId);
}
