import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// JUnit 5

@RunWith(Parameterized.class)
class TestSubtracao {

	@ParameterizedTest
	@CsvSource({
		"3, 2, 1",
		"2, 3, -1",
		"-3, -2, -1",
		"-2, -3, 1",
		"3, 0, 3",
		"0, 3, -3",
		"-3, 0, -3",
		"0, 3, -3",
		"0, 0, 0",
		"-32768, 0, -32768",
		"-32768, -1, -32767",
		"-1, -32768, 32767",
		"-32768, -2, -32766",
		"-2, -32768, 32766",
		"-1, 32767, -32768",
		"32767, 0, 32767",
		"0, 32767, -32767",
		"32767, 1, 32766",
		"1, 32767, -32766",
		"32767, 2, 32765",
		"2, 32767, -32765"
	})
	void testSubtracao(int input1, int input2, int expectedOutput) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		Calculadora calc = new Calculadora(input1, input2);
		assertEquals(calc.subtracao(), expectedOutput);
	}
	
	@ParameterizedTest
	@CsvSource({
		"-32768, 1"
	})
	void testSubtracaoComLimiteInferiorExtrapolado(int input1, int input2) {
		assertThrows(LimiteInferiorExtrapoladoException.class, () -> {
			new Calculadora(input1, input2).subtracao();
		});
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, -32768",
		"32767, -1"
	})
	void testSubtracaoComLimiteSuperiorExtrapolado(int input1, int input2) {
		assertThrows(LimiteSuperiorExtrapoladoException.class, () -> {
			new Calculadora(input1, input2).subtracao();
		});
	}

}
