package fga0242.model;

/**
 * Perfis de cliente atendidos pela cooperativa AgroMart.
 * O tipo de cliente influencia diretamente as regras de desconto
 * aplicadas no fechamento do pedido.
 */
public enum TipoCliente {
    COOPERADO,  // produtor associado à cooperativa
    VAREJO,     // pequeno comerciante / consumidor final
    ATACADO     // distribuidor / grande comprador
}
