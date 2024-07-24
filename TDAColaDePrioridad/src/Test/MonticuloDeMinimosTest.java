package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import Entidades.Monticulo;
import Entidades.MonticuloDeMinimos;
import Excepciones.MonticuloVacioException;

public class MonticuloDeMinimosTest {

	@Test
	public void sacarElemento() throws MonticuloVacioException {
		Monticulo<Integer> monticulo = new MonticuloDeMinimos<>();
		monticulo.agregarElemento(5);
		monticulo.agregarElemento(7);
		monticulo.agregarElemento(15);
		monticulo.agregarElemento(14);
		monticulo.agregarElemento(9);
		monticulo.agregarElemento(18);
		monticulo.agregarElemento(20);
		monticulo.agregarElemento(6);
		monticulo.agregarElemento(4);

		int elementoObtenido = monticulo.sacarElemento();
		int elementoEsperado = 4;

		assertEquals(elementoObtenido, elementoEsperado);
	}

	@Test(expected = MonticuloVacioException.class)
	public void sacarElementoEnMonticuloVacio() throws MonticuloVacioException {
		Monticulo<Integer> monticulo = new MonticuloDeMinimos<>();
		monticulo.sacarElemento();
	}

	@Test
	public void agregarElementos() {
		Monticulo<Integer> monticulo = new MonticuloDeMinimos<>();

		monticulo.agregarElemento(5);
		monticulo.agregarElemento(7);
		monticulo.agregarElemento(15);
		monticulo.agregarElemento(14);
		monticulo.agregarElemento(9);
		monticulo.agregarElemento(18);
		monticulo.agregarElemento(20);
		monticulo.agregarElemento(6);

		Comparable<Integer>[] resultadoObtenidoComparable = monticulo.getVector();
		Integer[] resultadoObtenido = new Integer[monticulo.getTope()];
		System.arraycopy(resultadoObtenidoComparable, 0, resultadoObtenido, 0, monticulo.getTope());

		Integer[] resultadoEsperado = { null, 5, 6, 15, 7, 9, 18, 20, 14 };

		assertArrayEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void verTopeDeMonticulo() throws MonticuloVacioException {
		Monticulo<Integer> monticulo = new MonticuloDeMinimos<>();

		monticulo.agregarElemento(7);
		monticulo.agregarElemento(15);
		monticulo.agregarElemento(2);
		monticulo.agregarElemento(9);

		int elementoObtenido = monticulo.verRaiz();
		int elementoEsperado = 2;

		assertEquals(elementoObtenido, elementoEsperado);
	}

	@Test(expected = MonticuloVacioException.class)
	public void verTopeDeMonticuloVacio() throws MonticuloVacioException {
		Monticulo<Integer> monticulo = new MonticuloDeMinimos<>();
		monticulo.verRaiz();
	}
}
