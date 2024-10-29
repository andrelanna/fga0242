package exercicios.tst;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ QuadradoTest.class, 
	            RetanguloTest.class, 
	            TrianguloTest.class, 
	            CirculoTest.class})
public class SteFiguraPlanaTests {

}
