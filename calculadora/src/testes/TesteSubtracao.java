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
class TesteSubtracao {
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] dadosSoma = new Object[][] {
			{3,2,1},
			{2,3,-1},
			{-3,-2,-1},
			{-2,-3,1},
			{3,0,3},
			{0	,3	,-3},
			{-3,	0,	-3},
			{0,3,-3},
			{0,0,0},
			{-32768,0,-32768},
			{-32768,	1, -32769},
			{1	-32768, 32769},
			{-32768,-1,-32767},
			{-1,-32768,32767},
			{-32768,	-2,	-32766},
			{-2,	-32768,	32766},
			{32767,	-1	,32766},
			{-1,	32767	,32768},
			{32767,	0	,32767},
			{0,	32767,	-32767},
			{32767,	1,	32766},
			{1,	32767,	-32768},
			{32767,	2,	32765},
			{2,	32767,	-32765}
		};
		return Arrays.asList(dadosSoma);
	}
	
	private int op1;
	private int op2;
	private int resultadoEsperado;
	
	public void testeSubtracaoParametrizado(int op1, int op2, int resultadoEsperado) {
		this.op1 = op1;
		this.op2 = op2;
		this.resultadoEsperado = resultadoEsperado;
	}
	
	@Test
	public void subtracaoTeste() throws LimiteinferiorException, LimiteSuperiorException {
		short resultado = new Calculadora().subtracao(op1, op2);
		assertEquals(resultadoEsperado, resultado);
	}

}