package test.java.fga0242;

import org.junit.Before;

import main.java.fga0242.ValorInvalidoException;

public class CalculoFaixaBaseTest extends BaseTest{
	
	@Before 
	public void setup() {
		super.setup();
		irpf.cadastrarRendimento("Salario", 10000);
		try {
			irpf.cadastrarPrevidenciaOficial(1000);
			irpf.cadastrarPensaoAlimenticia(500);
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		}
		irpf.cadastrarDependente("Fulano");
		irpf.cadastrarOutraDeducao("Previdencia privada", 500);
	}
}
