
package fga0242;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TesteSubtracaoParametrizado {

	// Passo 0: definição do objeto em teste
	private Calculadora c;
	
	/* Passo 1: definição anterior a cada caso de teste, @BeforeEach substitui 
	o antigo @Before e executa antes de cada execução parametrizada */
	@BeforeEach
	public void setup() {
		c = new Calculadora();
	}
	
	// Passo 2: definição de metodo que retorna conjunto de parametros, futuramente associados a @MethodSource nos testes
	// Formato: op1, op2, resultadoEsperadoSub, resultadoEsperadoSoma
	private static Stream<Arguments> parametros() {
		return Stream.of(
			Arguments.of( 3,  2,  1,  5),
			Arguments.of( 2,  3, -1,  5),
			Arguments.of( 3, -2,  5,  1),
			Arguments.of( 2, -3,  5, -1),
			Arguments.of(-3, -2, -1, -5),
			Arguments.of(-2, -3,  1, -5),
			Arguments.of( 0,  3, -3,  3)
        	);
	}

	// Passo 3: escrever os testes!
	@ParameterizedTest(name = "#{index} => {0} - {1} = {2}") // #num_do_teste => op1 - op2 = resultadoEsperadoSub
    	@MethodSource("parametros")
	public void testSubtracao(int op1, int op2, int resultadoEsperadoSub, int resultadoEsperadoSoma) {
		assertEquals(resultadoEsperadoSub, c.subtracao(op1, op2));
	}


	@ParameterizedTest(name = "#{index} => {0} + {1} = {3}") // #num_do_teste => op1 + op2 = resultadoEsperadoSoma
	@MethodSource("parametros")
	void testSoma(int op1, int op2, int resultadoEsperadoSub, int resultadoEsperadoSoma) {
		assertEquals(resultadoEsperadoSoma, c.soma(op1, op2));
	}
	
}
