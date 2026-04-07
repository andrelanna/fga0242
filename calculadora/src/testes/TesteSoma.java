package testes;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculadora.Calculadora;
import calculadora.LimiteSuperiorException;
import calculadora.LimiteinferiorException;

import static org.junit.Assert.*;

import java.util.Arrays;

@RunWith(Parameterized.class)
class TesteSoma {
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] dadosSubtracao = new Object[][] {
			{3, 2, 5},
			{-3, -2, -5},
			{3, 0, 3},
			{-3, 0, -3},
			{0, 0, 0},
			{-32768, 0, -32768},
			{-32768, 1, -32767},
			{32767, -1, 32766},
			{-32768,-2,32770},
			{32767,-1,32766},
			{32767,0,32767},
			{32767,1,32768},
			{32767,2,32769}
		};
		return Arrays.asList(dadosSoma);
	}
	
	private int op1;
	private int op2;
	private int resultadoEsperado;
	
	public void testeSomaParametrizado(int op1, int op2, int resultadoEsperado) {
		this.op1 = op1;
		this.op2 = op2;
		this.resultadoEsperado = resultadoEsperado;
	}
	
	@Test
	public void somaTeste() throws LimiteinferiorException, LimiteSuperiorException {
		short resultado = new Calculadora().soma(op1, op2);
		assertEquals(resultadoEsperado, resultado);
	}

}