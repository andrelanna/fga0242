package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDeducaoPrevidenciaOficial.class, 
	            TesteCadastroRendimentos.class, 
	            TestCadastroDependentes.class})
public class AllTests {

}
