package tst;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CadastroDeducaoPrevidenciaOficial.class,
	CadastroDependentesTeste.class,
	TstCadastroRendimentos.class,
	BuscaDependentesTest.class, 
	CadastroPensaoAlimenticiaTest.class, 
	BaseDeCalculoTest.class})
public class AllTests {

}
