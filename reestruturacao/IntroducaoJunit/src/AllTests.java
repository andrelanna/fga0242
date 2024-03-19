import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tst.CadastrarAlunoFeliz;
import tst.CadastrarAlunoInvalido;

@RunWith(Suite.class)
@SuiteClasses({CadastrarAlunoFeliz.class, CadastrarAlunoInvalido.class})
public class AllTests {

}
