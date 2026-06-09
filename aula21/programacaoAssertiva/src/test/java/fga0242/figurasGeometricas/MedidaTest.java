package fga0242.figurasGeometricas;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedidaTest {

	@Test
	public void medidaCorretaTest() {
		Medida m = Medida.getMedida(10, "cm");
		assertEquals(10, m.getValor());
		assertTrue("cm".equalsIgnoreCase(m.getUnidade()));
	}
	

}
