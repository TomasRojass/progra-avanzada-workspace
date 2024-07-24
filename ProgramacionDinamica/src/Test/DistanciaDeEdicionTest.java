package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import DistanciaDeEdicion.DistanciaDeEdicion;

public class DistanciaDeEdicionTest {

	@Test
	public void testEjemploDeClase() {
		String primeraPalabra = "inside";
		String segundaPalabra = "index";
		int resultadoEsperado = 3;
		int resultadoObtenido = DistanciaDeEdicion.obtenerMinimaDeOperaciones(primeraPalabra, segundaPalabra);
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

}
