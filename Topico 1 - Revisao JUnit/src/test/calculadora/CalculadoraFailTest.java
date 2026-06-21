package calculadora;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import exception.LimiteInferiorExtrapoladoException;
import exception.LimiteSuperiorExtrapoladoException;

public class CalculadoraFailTest {

	
	@Test
	public void testSubFail(){
		
		assertThrows(LimiteInferiorExtrapoladoException.class, ()->new Calculadora().subtracao(-32768, 1));
		assertThrows(LimiteSuperiorExtrapoladoException.class, ()->new Calculadora().subtracao(1, -32768));
	}
	
	@Test
	public void testSomaFail(){
		
		assertThrows(LimiteInferiorExtrapoladoException.class, ()->new Calculadora().soma(-32768, -1));
		assertThrows(LimiteInferiorExtrapoladoException.class, ()->new Calculadora().soma(-32768, -2));
		assertThrows(LimiteSuperiorExtrapoladoException.class, ()->new Calculadora().soma(32767, 2));
		assertThrows(LimiteSuperiorExtrapoladoException.class, ()->new Calculadora().soma(32767, 1));
	}
}
