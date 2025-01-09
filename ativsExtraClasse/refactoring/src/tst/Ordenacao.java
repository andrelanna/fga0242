package tst;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import app.QuickSort;

public class Ordenacao {

	QuickSort q; 
	
	@Test
	public void test() {
		int[] valores = new int[] {5, 3, 9, 2, 7, 6, 4, 3, 0, 1, -1, 8};
		q = QuickSort.getInstancia(valores);
		int[] respostaEsperada = new int[] {-1, 0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		assertArrayEquals(respostaEsperada, q.ordenar(0, valores.length-1));
	}

}
