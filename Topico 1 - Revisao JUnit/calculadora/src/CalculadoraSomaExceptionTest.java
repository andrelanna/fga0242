import org.junit.Assert;
import org.junit.Test;

public class CalculadoraSomaExceptionTest {
	
	@Test(expected = LimiteInferiorExtrapoladoException.class)
	public void adicaoLimiteInferiorTest() throws OperacaoInvalida, LimiteSuperiorExtrapoladoException,
	                                LimiteInferiorExtrapoladoException {
		
		Calculadora.calcula(new Operacao((short) -32768, (short) -1, OperacaoTipo.ADICAO));
		Calculadora.calcula(new Operacao((short) -32768, (short) -2, OperacaoTipo.ADICAO));
		
	}
	
	@Test(expected = LimiteSuperiorExtrapoladoException.class)
	public void adicaoLimiteSuperiorTest() throws OperacaoInvalida, LimiteSuperiorExtrapoladoException,
	                                              LimiteInferiorExtrapoladoException {
		
		Calculadora.calcula(new Operacao((short) 32767, (short) 1, OperacaoTipo.ADICAO));
		Calculadora.calcula(new Operacao((short) 32767, (short) 2, OperacaoTipo.ADICAO));
		
	}

}
