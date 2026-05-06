package test.java.fga0242;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CadastroDeDoisRendimentosTest.class, 
				CadastroDeRendimentosTest.class, 
				CadastroPrevidenciaOficialTest.class,
				CadastroPrevidenciaOficialExcecaoTest.class,
				CadastroDeDependentesTest.class, 
				CadastroPensaoAlimenticiaTest.class, 
				ExcecaoCadastroPensaoAlimenticiaTest.class})
public class SteCadastrosRendimentosTest {

}
