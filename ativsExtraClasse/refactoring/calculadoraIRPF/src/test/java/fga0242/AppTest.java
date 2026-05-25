package fga0242;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CadastroDeducoesTest.class, 
	           CadastroDependentesTest.class, 
	           CadastroRendimentosTest.class, 
	           CriacaoIRPFTest.class, 
	           BaseDeCalculoTest.class, 
	           CalculoImpostoTest.class})
public class AppTest {

}