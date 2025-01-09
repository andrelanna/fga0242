package tst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import app.QuickSort;

public class InstanciacaoQuickSort {

	QuickSort q; 
	
	@Test
	public void testInstanciacao1() {
		int[] valores = new int[] {5, 3, 9, 2, 7, 6, 4, 3, 0, 1, -1, 8};
		q = QuickSort.getInstancia(valores);
		assertNotNull(q);
		assertEquals(12, q.getSize());
	}
	
	@Test
	public void testInstanciacao2() {
		int[] valores = new int[] {5, 3, 7, 4, -6, 0, 6, -10, -8, 2};
		q = QuickSort.getInstancia(valores);
		assertNotNull(q);
		assertEquals(10, q.getSize()); 
	}

	@Test
	public void testInstanciacao3() {
		int[] valores = new int[] {6, -2, 1, -5, 0, 7, -8, 4, 10, 1, 8, 4, 0, -5, -2, -1, -6, -1, -1, -2};
		q = QuickSort.getInstancia(valores);
		assertNotNull(q);
		assertEquals(20, q.getSize()); 
	}
	

}
