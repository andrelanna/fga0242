import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class CalculadoraSomaParametrizadoTest {
	
	private int a;
	private int b;
	private OperacaoTipo tipo;
	private int resultadoEsperado;
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] dados = new Object[][] {
						{ 3, 2, OperacaoTipo.ADICAO, 5 },
						{ -3, -2, OperacaoTipo.ADICAO, -5 },
						{ 3, 0, OperacaoTipo.ADICAO, 3 },
						{ -3, 0, OperacaoTipo.ADICAO, -3 },
						{ 0, 0, OperacaoTipo.ADICAO, 0 },
						{ -32768, 0, OperacaoTipo.ADICAO, -32768 },
						{ -32768, 1, OperacaoTipo.ADICAO, -32767 },
						{ 32767, -1, OperacaoTipo.ADICAO, 32766 },
						{ 32767, 0, OperacaoTipo.ADICAO, 32767 }
			
		};
		
		return Arrays.asList(dados);
	}
	
	public CalculadoraSomaParametrizadoTest(final int a, final int b, final OperacaoTipo tipo, final int resultadoEsperado) {
		this.a = a;
		this.b = b;
		this.tipo = tipo;
		this.resultadoEsperado = resultadoEsperado;
	}
	
	@Test
	public void adicaoTest() throws OperacaoInvalida, LimiteSuperiorExtrapoladoException,
	                                LimiteInferiorExtrapoladoException {
		
		Operacao operacao = new Operacao((short) this.a, (short) this.b, this.tipo);
		Assert.assertEquals((short) this.resultadoEsperado, Calculadora.calcula(operacao));
		
	}
	
}
