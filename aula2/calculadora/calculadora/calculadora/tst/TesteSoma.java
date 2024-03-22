package calculadora.tst;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de testes (TestSuite) é um agrupamento de casos de teste (TestCase)
 * ou de outras suites de teste. Por se tratar de um tipo de teste diferente,
 * é necessário definir explicitamente qual o Runner que deve ser utilizado. 
 * Isso se dá através da anotação @RunWith(Suite.class). 
 * 
 * É necessário ainda informar quais são as classes de teste que compõem a 
 * suite de testes. Isso se faz ao definir a anotação @SuiteClasses({..., ...})
 * em que é informado o conjunto de classes de testes a serem executadas.
 * 
 * O Runner de uma Suite "varre" as classes que compõem a suite e, para cada uma, 
 * executa-a conforme o runner apropriado. 
 * 
 * No caso desse exemplo, TesteSomaFloat é um TestCase (logo o runner de TestCase 
 * será utilizado para sua execução) e TesteSomaInteiro é uma outra suite de testes
 * (nesse caso será executada segundo o runner de uma Suite).
 * 
 * @author andrelanna
 *
 */


@RunWith(Suite.class)
@SuiteClasses({ TesteSomaFloat.class, TesteSomaInteiro.class })
public class TesteSoma {

}
