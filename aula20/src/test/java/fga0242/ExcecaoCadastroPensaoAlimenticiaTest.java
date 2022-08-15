package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.fga0242.ValorInvalidoException;

public class ExcecaoCadastroPensaoAlimenticiaTest extends BaseTest{

	@Test(expected = ValorInvalidoException.class)
	public void testCadastroPensaoNegativa() throws ValorInvalidoException {
		irpf.cadastrarPensaoAlimenticia(-500);
	}

	
	@Test(expected = ValorInvalidoException.class)
	public void testCadastroPensaoNula() throws ValorInvalidoException {
		irpf.cadastrarPensaoAlimenticia(0);
	}
}
