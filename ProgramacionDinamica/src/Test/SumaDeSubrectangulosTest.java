package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SumaDeSubrectangulos.SumaDeSubrectangulos;

public class SumaDeSubrectangulosTest {

	private SumaDeSubrectangulos sumaDeSubrectangulos;

	@Before
	public void setUp() throws Exception {
		sumaDeSubrectangulos = new SumaDeSubrectangulos();
	}

	@Test
	public void testEjemploDeClase() {
		int[][] matriz = { { -5, 3, 5, 8, 2, 1, -4 }, { 3, -8, -10, 2, -2, 5, 4 }, { 1, 8, 3, -6, 0, 9, 3 },
				{ 12, 7, 1, -4, -9, 5, -6 }, { -15, 8, -12, 6, 3, -10, 3 }, };
		long resultadoEsperado = 32;
		long resultadoObtenido = sumaDeSubrectangulos.calcularMaximaSumaSubrectangulo(matriz);
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

}
