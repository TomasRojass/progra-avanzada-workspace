package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Costos.BellmanFord;
import Entidades.Grafo;
import Entidades.GrafoMatriz;
import Entidades.Vertice;
import Excepciones.CicloNegativoException;
import Excepciones.VerticeInvalidoException;

public class BellmanFordTest {

	private static final double DELTA = 1e-9;

	private Vertice<Character> U, V, X, Y, Z;

	Grafo<Character> grafoDeCaracteres;

	@Before
	public void setUp() throws Exception {
		U = new Vertice<>('U');
		V = new Vertice<>('V');
		X = new Vertice<>('X');
		Y = new Vertice<>('Y');
		Z = new Vertice<>('Z');
	}

	@Test
	public <T> void testEjemploPresentacion() throws VerticeInvalidoException, CicloNegativoException {

		int cantidadDeNodos = 5;

		grafoDeCaracteres = new GrafoMatriz<>(Grafo.ES_DIRIGIDO, Grafo.ES_PONDERADO, cantidadDeNodos);

		grafoDeCaracteres.agregarVertice(U);
		grafoDeCaracteres.agregarVertice(V);
		grafoDeCaracteres.agregarVertice(X);
		grafoDeCaracteres.agregarVertice(Y);
		grafoDeCaracteres.agregarVertice(Z);

		grafoDeCaracteres.agregarArista(Z, U, 6);
		grafoDeCaracteres.agregarArista(Z, X, 7);
		grafoDeCaracteres.agregarArista(U, X, 8);
		grafoDeCaracteres.agregarArista(U, V, 5);
		grafoDeCaracteres.agregarArista(U, Y, -4);
		grafoDeCaracteres.agregarArista(V, U, -2);
		grafoDeCaracteres.agregarArista(Y, V, 7);
		grafoDeCaracteres.agregarArista(Y, Z, 2);
		grafoDeCaracteres.agregarArista(X, Y, 9);
		grafoDeCaracteres.agregarArista(X, V, -3);

		Vertice<Character> verticeOrigen = Z;

		BellmanFord<Character> bellmanFord = new BellmanFord<>();

		bellmanFord.aplicarAlgoritmo(grafoDeCaracteres, verticeOrigen);

		double[] vectorDeDistanciasEsperado = { 2, 4, 7, -2, 0 };
		double[] vectorDeDistanciasObtenido = bellmanFord.getVectorDeDistancias();

		@SuppressWarnings("unchecked")
		Vertice<Character>[] vectorDePredecesoresEsperado = new Vertice[] { V, X, Z, U, Z };
		Vertice<Character>[] vectorDePredecesoresObtenido = bellmanFord.getVectorDePredecesores();

		assertArrayEquals(vectorDeDistanciasObtenido, vectorDeDistanciasEsperado, DELTA);
		assertArrayEquals(vectorDePredecesoresObtenido, vectorDePredecesoresEsperado);
	}

}
