package seleccion;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class test {

    @Test
    public void testEmptyArray() {
        int[] array = {};
        new Seleccion().ordenarPorSeleccion(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void testSingleElement() {
        int[] array = {1};
        new Seleccion().ordenarPorSeleccion(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void testAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        new Seleccion().ordenarPorSeleccion(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        new Seleccion().ordenarPorSeleccion(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testRandomOrder() {
        int[] array = {3, 1, 4, 5, 2};
        new Seleccion().ordenarPorSeleccion(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testDuplicates() {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        new Seleccion().ordenarPorSeleccion(array);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9}, array);
    }
}