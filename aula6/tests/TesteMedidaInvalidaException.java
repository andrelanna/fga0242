package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import app.Triangulo;
import exception.MedidaInvalidaException;

public class TesteMedidaInvalidaException {

	@Test(expected = MedidaInvalidaException.class)
	@Category(TesteExcecao.class)
	public void test() throws MedidaInvalidaException {
		Triangulo t1 = new Triangulo(-3, 8, 1); //Lançar excecao
		assertNull(t1);
	}

}
