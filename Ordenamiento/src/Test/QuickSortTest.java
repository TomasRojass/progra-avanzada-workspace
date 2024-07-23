package Test;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import NoElementales.QuickSortInt;

public class QuickSortTest {

	@Test
	public void testOrdenarCasiOrdenado() {
		int[] arr = { 1, 3, 2, 5, 4 };
		int[] expected = { 1, 2, 3, 4, 5 };
		QuickSortInt.ordenar(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr);
	}

	@Test
	public void testOrdenarReversa() {
		int[] arr = { 5, 4, 3, 2, 1 };
		int[] expected = { 1, 2, 3, 4, 5 };
		QuickSortInt.ordenar(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr);
	}

	@Test
	public void testOrdenarConDuplicados() {
		int[] arr = { 4, 5, 2, 2, 3, 4, 1 };
		int[] expected = { 1, 2, 2, 3, 4, 4, 5 };
		QuickSortInt.ordenar(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr);
	}

	@Test
	public void testOrdenarConNegativos() {
		int[] arr = { 3, -1, 4, -5, 2 };
		int[] expected = { -5, -1, 2, 3, 4 };
		QuickSortInt.ordenar(arr, 0, arr.length - 1);
		assertArrayEquals(expected, arr);
	}
}
