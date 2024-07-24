package Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Varilla.CortadorDeVarilla;
import Varilla.Varilla;

public class VarillaTest {

	private CortadorDeVarilla cortadorDeVarilla;

	private Varilla varilla;

	@Before
	public void setUp() throws Exception {
		cortadorDeVarilla = new CortadorDeVarilla();
		varilla = new Varilla();
	}

	@Test
	public void testPrimerEjemplo() {
		int longitudVarilla = 7;
		int[] cortes = { 3, 5, 1, 4 };
		int resultadoEsperado = 16;
		int resultadoObtenido = this.varilla.cortarVarilla(longitudVarilla, cortes);
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void testPrimerEjemploConCortesOrdenados() {
		int longitudVarilla = 7;
		int[] cortes = { 1, 3, 4, 5 };
		int resultadoEsperado = 16;
		int resultadoObtenido = this.cortadorDeVarilla.cortarOptimoTopDown(longitudVarilla, cortes);
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void testSegundoEjemplo() {
		int longitudVarilla = 9;
		int[] cortes = { 5, 6, 1, 4, 2 };
		int resultadoEsperado = 22;
		int resultadoObtenido = this.varilla.cortarVarilla(longitudVarilla, cortes);
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
}
