package testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testeAdicaoParametrizado.class, testeAdicaoParametrizadoOverflow.class,
		testeSubtracaoParametrizado.class, testeSubtracaoParametrizadoOverflow.class })
public class AllTests {

}
