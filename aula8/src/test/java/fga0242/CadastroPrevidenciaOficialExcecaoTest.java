package test.java.fga0242;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.fga0242.ValorInvalidoException;

public class CadastroPrevidenciaOficialExcecaoTest extends BaseTest{

	@Test(expected = ValorInvalidoException.class)
	public void test() throws ValorInvalidoException {
		irpf.cadastrarPrevidenciaOficial(-100);
	}

}
