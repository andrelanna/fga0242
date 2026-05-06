package test.java.fga0242;

import org.junit.Before;

import main.java.fga0242.IRPF;

public class BaseTest {

	IRPF irpf; 
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}

}
