package CalculadoraTeste;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import Classes.Calculadora;
import Exceptions.LimiteInferiorExtrapoladoException;
import Exceptions.LimiteSuperiorExtrapoladoException;


@RunWith(Parameterized.class)
public class CalculadoraTesteSoma {

		@Parameters
		public static Iterable getParameters() {
			Object[][] dados = new Object[][]{
				{3, 2, 5},
				{-3, -2, -5},
				{3, 0, 3},
				{-3, 0, -3},
				{0, 0, 0},
				{-32768, 0, -32768},
				{-32768, 1, -32767},
				{-32768, -1, 32766},
				{-32768,-2,- 32770},
				{32767,-1,32766},
				{32767,0,32767},
				{32767,1,32768},
				{32767,2,32769}
			};
			return Arrays.asList(dados);
		}

		private int op1;
		private int op2;
		private int resultadoEsperado;
		
		public CalculadoraTesteSoma(int op1,int op2, int resultadoEsperado){
			this.op1 = op1;
			this.op2 = op2;
			this.resultadoEsperado = resultadoEsperado;
		}

		@Test 
		public void Testes(){
			int resultado = Calculadora.Soma(op1,op2);
			assertEquals(resultadoEsperado, resultado );
		}
		
		@Test(expected= LimiteSuperiorExtrapoladoException.class) 
		public void TesteLimiteSuperior()throws LimiteSuperiorExtrapoladoException{
			int resultado = Calculadora.Soma(op1,op2);
			assertEquals(resultadoEsperado, resultado );
		}
		
		@Test(expected= LimiteInferiorExtrapoladoException.class) 
		public void TesteLimiteInferior()throws LimiteInferiorExtrapoladoException{
			int resultado = Calculadora.Soma(op1,op2);
			assertEquals(resultadoEsperado, resultado );
		}
}


