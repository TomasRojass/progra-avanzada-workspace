package Test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;
import Elementales.Seleccion;
import Entidades.Ordenamiento;

public class SeleccionTest {

	private Ordenamiento ordenamiento;

	Integer[] vectorEnteros = { 3, -2, 5, 1, -6, 9, -4, 2, -1, 8, -3, 7, -5, 4, -7, 6 };

	Character[] vector = { 'A', 'S', 'O', 'R', 'T', 'I', 'N', 'G', 'E', 'X', 'A', 'M', 'P', 'L', 'E' };

	Character[] nombreYApellido = { 'L', 'E', 'A', 'N', 'D', 'R', 'O', 'S', 'A', 'N', 'D', 'O', 'V', 'A', 'L' };

	String[] nombres = { "Vasquez", "Leandro", "Juan", "Sandoval" };

	@Before
	public void setUp() throws Exception {
		this.ordenamiento = new Seleccion();
	}

	@Test
	public void testOrdenarVectorCaracteres() {
		ordenamiento.ordenar(nombreYApellido);
		Character[] resultadoEsperado = { 'A', 'A', 'A', 'D', 'D', 'E', 'L', 'L', 'N', 'N', 'O', 'O', 'R', 'S', 'V' };
		assertArrayEquals(resultadoEsperado, nombreYApellido);
	}

	@Test
	public void testOrdenarVectorCadenas() {
		ordenamiento.ordenar(nombres);
		String[] resultadoEsperado = { "Juan", "Leandro", "Sandoval", "Vasquez" };
		assertArrayEquals(resultadoEsperado, nombres);
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