package tst;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteCriacaoAluno.class, TesteCriacaoCadastro.class, TstCadastroAlunos.class })
public class AllTests {

}
