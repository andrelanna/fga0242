package test;

import java.util.Arrays;

import static org.junit.Assert.*; 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import code.Calculadora;
import code.LimiteException;
import code.LimiteInferiorExtrapoladoException;


@RunWith(Parameterized.class)
public class TestCalculadora {
	@Parameters
	public static Iterable getParameters() {
		Object[][] dados = new Object[][] {
			{(short) 3,(short) 2,(short) 5},
			{(short) -3,(short) -2,(short) -5},
			{(short) 3,(short) 0,(short) 3},
			{(short) -3,(short) 0,(short) -3},
			{(short) 0,(short) 0, (short) 0},
			{(short) -32768, (short) 0, (short) -32768},
			{(short) -32768,(short) 1,(short) -32767}, 
			{(short) -32768, (short) -1, (short)22}/*
				|   -32768   |     -2     |  LimiteInferiorExtrapoladoException |
				|    32767   |     -1     |         32766                       |
				|    32767   |      0     |         32767                       |
				|    32767   |      1     |  LimiteSuperiorExtrapoladoException |
				|    32767   |      2     |  LimiteSuperiorExtrapoladoException}
		*/
		};	
	return Arrays.asList(dados);
	}

	private short op1;
	private short op2;
	private short resultado;
	
	public TestCalculadora(short op1,short op2,short resultado){
		op1 = this.op1;
		op2 = this.op2;
		resultado = this.resultado;
	}
	
	@Test()
	public void testAdicao() {
		try {
			short res = new Calculadora(op1,op2).adicao();
			assertEquals(resultado,res);
		}catch(Exception e) {
			System.out.println("aaa");
			assertEquals(resultado,e);
		}
	}
}
