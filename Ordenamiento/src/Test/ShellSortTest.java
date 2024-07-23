package Test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import NoElementales.ShellSort;

public class ShellSortTest {

	@Test
	public void testEmptyArray() {
		Integer[] array = {};
		new ShellSort().ordenar(array);
		assertArrayEquals(new Integer[] {}, array);
	}

	@Test
	public void testSingleElement() {
		Integer[] array = { 1 };
		new ShellSort().ordenar(array);
		assertArrayEquals(new Integer[] { 1 }, array);
	}

	@Test
	public void testAlreadySorted() {
		Integer[] array = { 1, 2, 3, 4, 5 };
		new ShellSort().ordenar(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, array);
	}

	@Test
	public void testReverseSorted() {
		Integer[] array = { 5, 4, 3, 2, 1 };
		new ShellSort().ordenar(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, array);
	}

	@Test
	public void testRandomOrder() {
		Integer[] array = { 3, 1, 4, 5, 2 };
		new ShellSort().ordenar(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, array);
	}

	@Test
	public void testDuplicates() {
		Integer[] array = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
		new ShellSort().ordenar(array);
		assertArrayEquals(new Integer[] { 1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9 }, array);
	}

}