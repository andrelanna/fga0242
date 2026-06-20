
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

// JUnit 5

@RunWith(Parameterized.class)
class TestSoma {
	
	@ParameterizedTest
	@CsvSource({
		"3, 2, 5",
		"-3, -2, -5",
		"3, 0, 3",
		"-3, 0, -3",
		"-32768, 0, -32768",
		"-32768, 1, -32767",
		"32767, -1, 32766",
		"32767, 0, 32767"
	})
	void testSoma(int input1, int input2, int expectedOutput) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		Calculadora calc = new Calculadora(input1, input2);
		assertEquals(calc.soma(), expectedOutput);
	}
	
	@ParameterizedTest
	@CsvSource({
		"-32768, -1",
		"-32768, -2"
	})
	void testSomaComLimiteInferiorExtrapolado(int input1, int input2){
		assertThrows(LimiteInferiorExtrapoladoException.class, () -> {
			new Calculadora(input1, input2).soma();
		});
	}
	
	@ParameterizedTest
	@CsvSource({
		"32767, 1",
		"32767, 2"
	})
	void testSomaComLimiteSuperiorExtrapolado(int input1, int input2) {
		assertThrows(LimiteSuperiorExtrapoladoException.class, () -> {
			System.out.println(input1 + input2);
			new Calculadora(input1, input2).soma();
		});
	}
	
}
