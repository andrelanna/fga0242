package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.LimitesException;
import main.Calculadora;

@RunWith(Parameterized.class)
public class Subtracao{

	@Parameters
	public static Iterable getSubParameters() {
		Object[][] mocados = new Object[][] {
			{3,	2, 1},
			{2,	3, -1},
			{-3, -2, -1},
			{-2, -3, 1},
			{3, 0, 3},
			{0,	3, -3},
			{-3, 0, -3},
			{0,	3, -3},
			{0,	0, 0},
			{-32768, 0, -32768},
			{-32768, -1, -32767},
			{-1, -32768, 32767},
			{-32768, -2, -32766},
			{-2, -32768, 32766},
			{32767,	1, 32766},
			{-1, 32767,	-32768},
			{32767,	0, 32767},
			{0,	32767, -32767},
			{32767,	1, 32766},
			{1,	32767, -32766},
			{32767,	2, 32765},
			{2,	32767, -32765},
		};
		return Arrays.asList(mocados);
	}

	private int num1;
	private int num2;
	private int num3;

	public Subtracao(int num1, int num2, int num3){
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

	@Test
	public void subtracao() throws LimitesException{
		short valorSub = new Calculadora().subtracao(num1, num2);
		assertEquals(num3, valorSub);
	}
}