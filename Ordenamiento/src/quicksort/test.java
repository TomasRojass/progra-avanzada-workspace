package quicksort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class test {

    @Test
    public void testOrdenarCasiOrdenado() {
        int[] arr = {1, 3, 2, 5, 4};
        int[] expected = {1, 2, 3, 4, 5};
        Quicksort2.ordenar(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testOrdenarReversa() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Quicksort2.ordenar(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testOrdenarConDuplicados() {
        int[] arr = {4, 5, 2, 2, 3, 4, 1};
        int[] expected = {1, 2, 2, 3, 4, 4, 5};
        Quicksort2.ordenar(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testOrdenarConNegativos() {
        int[] arr = {3, -1, 4, -5, 2};
        int[] expected = {-5, -1, 2, 3, 4};
        Quicksort2.ordenar(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }
}
