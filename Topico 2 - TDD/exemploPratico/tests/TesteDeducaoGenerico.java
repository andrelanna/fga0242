package tests;

import org.junit.Before;

import app.IRPF;

public class TesteDeducaoGenerico {

	protected IRPF irpf;

	@Before
	public void setup() {
		this.irpf = new IRPF();
	}

}
