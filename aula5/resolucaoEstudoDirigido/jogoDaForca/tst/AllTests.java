package tst;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de testes contendo todos os testes desenvolvidos ao longo da aula
 */

@RunWith(Suite.class)
@SuiteClasses({ TstCaractereNuloOuInvalido.class, TstForca.class, TstResolucaoForca.class })
public class AllTests {

}
