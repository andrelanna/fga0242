package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import app.QuickSort;

public class Particionamento {

	QuickSort q; 
	
	@Test
	public void testeParticionamento1() {
		int[] valores = new int[] {5, 3, 9, 2, 7, 6, 4, 3, 0, 1, -1, 8};
		q = QuickSort.getInstancia(valores);
		assertEquals(7, q.particionamento(0, valores.length-1));
	}
	
	@Test
	public void testParticionamento2() {
		int[] valores = new int[] {2, 3, 4, -6, 0, -10, -8, 5, 6, 7};
		q = QuickSort.getInstancia(valores);
		assertEquals(4, q.particionamento(0, valores.length-1));
	}
	
	@Test
	public void testParticionamento3() {
		int[] valores = new int[] {6, -2, 1, -5, 0, 7, -8, 4, 10, 1, 8, 4, 0, -5, -2, -1, -6, -1, -1, -2};
		q = QuickSort.getInstancia(valores);
		assertNotNull(q);
		assertEquals(16, q.particionamento(0, valores.length-1)); 
	}

}
