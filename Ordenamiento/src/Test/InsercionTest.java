package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Elementales.Insercion;
import Entidades.Ordenamiento;

public class InsercionTest {

	private Ordenamiento ordenamiento;

	private int[] vectorInt = { 5, 6, 8, 2, 4, 7, 25, 69, 12, 14, 19, 25 };

	private Character[] vectorCharacter = { 'L', 'E', 'A', 'N', 'D', 'R', 'O', 'S', 'A', 'N', 'D', 'O', 'V', 'A', 'L' };

	private String[] vectorString = { "Vasquez", "Leandro", "Juan", "Sandoval" };

	@Before
	public void setUp() throws Exception {
		this.ordenamiento = new Insercion();
	}

	@Test
	public void testOrdenarVectorEnteros() {
		ordenamiento.ordenar(vectorInt);
		int[] resutadoEsperado = { 2, 4, 5, 6, 7, 8, 12, 14, 19, 25, 25, 69 };
		assertArrayEquals(resutadoEsperado, vectorInt);
	}

	@Test
	public void testOrdenarVectorCaracteres() {
		ordenamiento.ordenar(vectorCharacter);
		Character[] resultadoEsperado = { 'A', 'A', 'A', 'D', 'D', 'E', 'L', 'L', 'N', 'N', 'O', 'O', 'R', 'S', 'V' };
		assertArrayEquals(resultadoEsperado, vectorCharacter);
	}

	@Test
	public void testOrdenarVectorCadenas() {
		ordenamiento.ordenar(vectorString);
		String[] resultadoEsperado = { "Juan", "Leandro", "Sandoval", "Vasquez" };
		assertArrayEquals(resultadoEsperado, vectorString);
	}

	@Test
	public void testVectorVacio() {
		Integer[] array = {};
		ordenamiento.ordenar(array);
		assertArrayEquals(new Integer[] {}, array);
	}

	@Test
	public void testUnicoElemento() {
		Integer[] array = { 1 };
		ordenamiento.ordenar(array);
		assertArrayEquals(new Integer[] { 1 }, array);
	}

	@Test
	public void testVectorYaOrdenado() {
		Integer[] array = { 1, 2, 3, 4, 5 };
		ordenamiento.ordenar(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, array);
	}

	@Test
	public void testVectorOrdenadoAlReves() {
		Integer[] array = { 5, 4, 3, 2, 1 };
		ordenamiento.ordenar(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, array);
	}

	@Test
	public void testOrdenAleatorio() {
		Integer[] array = { 3, 1, 4, 5, 2 };
		ordenamiento.ordenar(array);
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, array);
	}

	@Test
	public void testValoresDuplicados() {
		Integer[] array = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
		ordenamiento.ordenar(array);
		assertArrayEquals(new Integer[] { 1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9 }, array);
	}

}
