package exemplo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SteTestesFuncionais.class, SteTestesDesempenho.class, SteTestesDeExcecao.class})
public class AllTests {

}
