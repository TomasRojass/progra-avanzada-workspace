package Test;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import Rescate.*;

public class RescatandoALaPrincesaTest {

	private Rescate rescate;

	private Archivo archivoEntrada;

	@Test
	public void testEjemplo() throws IOException {
		archivoEntrada = new Archivo("entrada");
		rescate = archivoEntrada.leerArchivoRescate(Archivo.RUTA_ARCHIVOS_TESTS_ENTRADA);
		// String respuestaRescateEsperado = "1 2 3 6 9";
		String respuestaRescateEsperado = "1 3 6 9";
		String respuestaRescateObtenido = rescate.resolver();
		assertEquals(respuestaRescateEsperado, respuestaRescateObtenido);
	}

}
