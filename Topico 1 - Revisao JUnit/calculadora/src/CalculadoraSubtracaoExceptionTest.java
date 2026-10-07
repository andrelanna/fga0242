import org.junit.Test;

public class CalculadoraSubtracaoExceptionTest {
	
	@Test(expected = LimiteInferiorExtrapoladoException.class)
	public void subtracaoLimiteInferiorTest() throws OperacaoInvalida, LimiteSuperiorExtrapoladoException,
	                                LimiteInferiorExtrapoladoException {
		
		Calculadora.calcula(new Operacao((short) -32768, (short) 1, OperacaoTipo.SUBTRACAO));
		
	}
	
	@Test(expected = LimiteSuperiorExtrapoladoException.class)
	public void subtracaoLimiteSuperiorTest() throws OperacaoInvalida, LimiteSuperiorExtrapoladoException,
	                                              LimiteInferiorExtrapoladoException {
		
		Calculadora.calcula(new Operacao((short) 1, (short) -32768, OperacaoTipo.SUBTRACAO));
		
	}

}
