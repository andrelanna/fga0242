package tst;

import org.junit.Before;

import app.IRPF;

public class BaseTest {

	IRPF irpf;

	@Before
	public void setup() {
		irpf = new IRPF();
	}

}
