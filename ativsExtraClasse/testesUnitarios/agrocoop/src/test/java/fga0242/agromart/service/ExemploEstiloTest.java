package fga0242.agromart.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import fga0242.model.ItemPedido;
import fga0242.model.Produto;

/**
 * ATENÇÃO: esta classe é apenas um EXEMPLO de estilo/convenção de
 * código de teste (padrão AAA: Arrange, Act, Assert; uso de @Before;
 * comparação de double com margem de erro). Ela NÃO faz parte da
 * entrega do exercício e NÃO deve ser copiada como solução de nenhum
 * dos requisitos pedidos no enunciado.
 */
public class ExemploEstiloTest {

    private static final double DELTA = 0.001;

    private Produto tomate;

    @Before
    public void setUp() {
        // Arrange (comum a todos os testes desta classe)
        tomate = new Produto("P001", "Tomate", "HORTIFRUTI", 4.50, 1.0);
    }

    @Test
    public void deveCalcularSubtotalCorretamente() {
        // Arrange
        ItemPedido item = new ItemPedido(tomate, 3);

        // Act
        double subtotal = item.getSubtotal();

        // Assert
        assertEquals(13.50, subtotal, DELTA);
    }
}
