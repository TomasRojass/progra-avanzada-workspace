package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Costos.Warshall;
import Entidades.Grafo;
import Entidades.GrafoLista;
import Entidades.GrafoMatriz;
import Entidades.Vertice;

public class WarshallTest {

	private Grafo<Integer> grafo;

	private Vertice<Integer> uno, dos, tres, cuatro;

	@Before
	public void setUp() throws Exception {
		uno = new Vertice<Integer>(1);
		dos = new Vertice<Integer>(2);
		tres = new Vertice<Integer>(3);
		cuatro = new Vertice<Integer>(4);
	}

	// https://youtu.be/mTNSvI1pRPA?si=2Lx6MFeSc15IderL
	@Test
	public void testEjemploVideo() {

		grafo = new GrafoLista<Integer>(Grafo.ES_DIRIGIDO, Grafo.NO_ES_PONDERADO);

		grafo.agregarVertice(uno);
		grafo.agregarVertice(dos);
		grafo.agregarVertice(tres);
		grafo.agregarVertice(cuatro);

		grafo.agregarArista(uno, dos);
		grafo.agregarArista(dos, uno);
		grafo.agregarArista(dos, tres);
		grafo.agregarArista(tres, cuatro);

		Warshall<Integer> warshall = new Warshall<>();
		warshall.aplicarAlgoritmo(grafo);
		
		boolean[][] matrizObtenida = new boolean[][] { { true, true, true, true }, { true, true, true, true },
				{ false, false, false, true }, { false, false, false, false } };

		boolean[][] matrizEsperada = warshall.getMatrizDeCerradura();

		assertEquals(matrizEsperada.length, matrizObtenida.length);
		for (int i = 0; i < matrizEsperada.length; i++) {
			assertArrayEquals(matrizEsperada[i], matrizObtenida[i]);
		}
	}

	@Test
	public void testEjercicioDeClase() {

		int cantidadDeNodos = 3;

		grafo = new GrafoMatriz<Integer>(Grafo.ES_DIRIGIDO, Grafo.NO_ES_PONDERADO, cantidadDeNodos);

		grafo.agregarVertice(uno);
		grafo.agregarVertice(dos);
		grafo.agregarVertice(tres);

		grafo.agregarArista(uno, dos);
		grafo.agregarArista(uno, tres);
		grafo.agregarArista(dos, uno);
		grafo.agregarArista(tres, dos);

		Warshall<Integer> warshall = new Warshall<>();
		warshall.aplicarAlgoritmo(grafo);

		boolean[][] matrizObtenida = new boolean[][] { { true, true, true }, { true, true, true },
				{ true, true, true } };

		boolean[][] matrizEsperada = warshall.getMatrizDeCerradura();

		assertEquals(matrizEsperada.length, matrizObtenida.length);
		for (int i = 0; i < matrizEsperada.length; i++) {
			assertArrayEquals(matrizEsperada[i], matrizObtenida[i]);
		}
	}

}
