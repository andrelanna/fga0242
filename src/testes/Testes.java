import org.junit.runners.Suite.*;
import org.junit.runners.RunWith;
import static org.junit.Assert.*;

@RunWith(Suite.class) 
@SuiteClasses({ testeAdicaoParametrizado.class, testeAdicaoParametrizadoOverflow.class, testeSubtracaoParametrizado.class, testeSubtracaoParametrizadoOverflow.class })
public class Testes {}