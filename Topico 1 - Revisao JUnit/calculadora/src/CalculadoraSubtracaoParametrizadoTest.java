import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class CalculadoraSubtracaoParametrizadoTest {
	
	private int a;
	private int b;
	private OperacaoTipo tipo;
	private int resultadoEsperado;
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] dados = new Object[][] {
						{ 3, 2, OperacaoTipo.SUBTRACAO, 1 },
						{ 2, 3, OperacaoTipo.SUBTRACAO, -1 },
						{ -3, -2, OperacaoTipo.SUBTRACAO, -1 },
						{ -2, -3, OperacaoTipo.SUBTRACAO, 1 },
						{ 3, 0, OperacaoTipo.SUBTRACAO, 3 },
						{ 0, 3, OperacaoTipo.SUBTRACAO, -3 },
						{ -3, 0, OperacaoTipo.SUBTRACAO, -3 },
						{ 0, 3, OperacaoTipo.SUBTRACAO, -3 },
						{ 0, 0, OperacaoTipo.SUBTRACAO, 0 },
						{ -32768, 0, OperacaoTipo.SUBTRACAO, -32768 },
						{ -32768, -1, OperacaoTipo.SUBTRACAO, -32767 },
						{ -1, -32768, OperacaoTipo.SUBTRACAO, 32767 },
						{ -32768, -2, OperacaoTipo.SUBTRACAO, -32766 },
						{ -2, 32766, OperacaoTipo.SUBTRACAO, -32768 },
						{ -1, 32767, OperacaoTipo.SUBTRACAO, 32768 },
						{ 32767, 0, OperacaoTipo.SUBTRACAO, 32767 },
						{ 0, 32767, OperacaoTipo.SUBTRACAO, -32767 },
						{ 32767, 1, OperacaoTipo.SUBTRACAO, 32766 },
						{ 1, 32767, OperacaoTipo.SUBTRACAO, -32766 },
						{ 32767, 2, OperacaoTipo.SUBTRACAO, 32765 },
						{ 2, 32767, OperacaoTipo.SUBTRACAO, -32765 }
			
		};
		
		return Arrays.asList(dados);
	}
	
	public CalculadoraSubtracaoParametrizadoTest(final int a, final int b, final OperacaoTipo tipo,
	                                             final int resultadoEsperado) {
		this.a = a;
		this.b = b;
		this.tipo = tipo;
		this.resultadoEsperado = resultadoEsperado;
	}
	
	@Test
	public void subtracaoTest() throws OperacaoInvalida, LimiteSuperiorExtrapoladoException,
	                                LimiteInferiorExtrapoladoException {
		
		Operacao operacao = new Operacao((short) this.a, (short) this.b, this.tipo);
		Assert.assertEquals((short) this.resultadoEsperado, Calculadora.calcula(operacao));
		
	}
	
}
