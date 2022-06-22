package testesParametrizados.tst;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteRaizNaoParametrizado.class, TesteRaizParametrizado.class, TesteSomaNaoParametrizado.class,
		TesteSomaParametrizado.class })
public class AllTests {

}
