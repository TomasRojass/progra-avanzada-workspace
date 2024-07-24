package Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Costos.Floyd;
import Entidades.Grafo;
import Entidades.GrafoMatriz;
import Entidades.Vertice;

public class FloydTest {
	
	// NUMEROS DISTINTOS DE CEROS EN LAS DIAGONALES
	// MATRICES QUE DEVUELVAN INFINITO AL FINAL
	// MATRICES QUE NUNCA CAMBIEN
	// VER CASOS LIMITES

	private static final double DELTA = 1e-9;

	private Grafo<Character> grafoDeCaracteres;

	private Grafo<Integer> grafoDeEnteros;

	private Vertice<Integer> uno, dos, tres;

	private Vertice<Character> A, B, C, D, E;

	@Before
	public void setUp() throws Exception {
		A = new Vertice<Character>('A');
		B = new Vertice<Character>('B');
		C = new Vertice<Character>('C');
		D = new Vertice<Character>('D');
		E = new Vertice<Character>('E');

		uno = new Vertice<Integer>(1);
		dos = new Vertice<Integer>(2);
		tres = new Vertice<Integer>(3);
	}

	// https://youtu.be/h-nmexY9gtA?si=xodOS7H_YFT8_CAd
	@Test
	public void testEjemploVideo() {

		int cantidadDeNodos = 5;

		grafoDeCaracteres = new GrafoMatriz<Character>(Grafo.ES_DIRIGIDO, Grafo.ES_PONDERADO, cantidadDeNodos);

		grafoDeCaracteres.agregarVertice(A);
		grafoDeCaracteres.agregarVertice(B);
		grafoDeCaracteres.agregarVertice(C);
		grafoDeCaracteres.agregarVertice(D);
		grafoDeCaracteres.agregarVertice(E);

		grafoDeCaracteres.agregarArista(A, C, 8);
		grafoDeCaracteres.agregarArista(A, B, 4);
		grafoDeCaracteres.agregarArista(B, A, 4);
		grafoDeCaracteres.agregarArista(B, C, 1);
		grafoDeCaracteres.agregarArista(B, D, 2);
		grafoDeCaracteres.agregarArista(C, A, 8);
		grafoDeCaracteres.agregarArista(C, D, 4);
		grafoDeCaracteres.agregarArista(C, E, 2);
		grafoDeCaracteres.agregarArista(D, B, 2);
		grafoDeCaracteres.agregarArista(D, C, 4);
		grafoDeCaracteres.agregarArista(D, E, 7);
		grafoDeCaracteres.agregarArista(E, C, 2);
		grafoDeCaracteres.agregarArista(E, D, 7);

		Floyd<Character> floyd = new Floyd<>();
		floyd.aplicarAlgoritmo(grafoDeCaracteres);

		double[][] matrizDeCostosEsperado = new double[][] { { 0, 4, 5, 6, 7 }, { 4, 0, 1, 2, 3 }, { 8, 6, 0, 4, 2 },
				{ 6, 2, 3, 0, 5 }, { 10, 8, 2, 6, 0 } };

		double[][] matrizDeCostosObtenido = floyd.getMatrizDeCostos();

		@SuppressWarnings("unchecked")
		Vertice<Character>[][] matrizDePredecesoresEsperado = new Vertice[][] { { null, B, B, B, C },
				{ A, null, C, D, C }, { A, D, null, D, E }, { B, B, B, null, C }, { C, D, C, C, null } };

		Vertice<Character>[][] matrizDePredecesoresObtenido = floyd.getMatrizDePredecesores();

		assertEquals(matrizDeCostosEsperado.length, matrizDeCostosObtenido.length);
		for (int i = 0; i < matrizDeCostosEsperado.length; i++) {
			assertArrayEquals(matrizDeCostosEsperado[i], matrizDeCostosObtenido[i], DELTA);
		}

		assertEquals(matrizDePredecesoresEsperado.length, matrizDePredecesoresObtenido.length);
		for (int i = 0; i < matrizDePredecesoresEsperado.length; i++) {
			for (int j = 0; j < matrizDePredecesoresEsperado[i].length; j++) {
				assertEquals(matrizDePredecesoresEsperado[i][j], matrizDePredecesoresObtenido[i][j]);
			}
		}
	}

	@Test
	public void testEjemploDeClase() {

		int cantidadDeNodos = 3;

		grafoDeEnteros = new GrafoMatriz<Integer>(Grafo.ES_DIRIGIDO, Grafo.NO_ES_PONDERADO, cantidadDeNodos);

		grafoDeEnteros.agregarVertice(uno);
		grafoDeEnteros.agregarVertice(dos);
		grafoDeEnteros.agregarVertice(tres);

		grafoDeEnteros.agregarArista(uno, dos, 8);
		grafoDeEnteros.agregarArista(uno, tres, 5);
		grafoDeEnteros.agregarArista(dos, uno, 3);
		grafoDeEnteros.agregarArista(tres, dos, 2);

		Floyd<Integer> floyd = new Floyd<>();
		floyd.aplicarAlgoritmo(grafoDeEnteros);

		double[][] matrizDeCostosEsperado = new double[][] { { 0, 7, 5 }, { 3, 0, 8 }, { 5, 2, 0 } };

		double[][] matrizDeCostosObtenido = floyd.getMatrizDeCostos();

		@SuppressWarnings("unchecked")
		Vertice<Integer>[][] matrizDePredecesoresEsperado = new Vertice[][] { { null, tres, tres }, { uno, null, uno },
				{ dos, dos, null } };

		Vertice<Integer>[][] matrizDePredecesoresObtenido = floyd.getMatrizDePredecesores();

		assertEquals(matrizDeCostosEsperado.length, matrizDeCostosObtenido.length);
		for (int i = 0; i < matrizDeCostosEsperado.length; i++) {
			assertArrayEquals(matrizDeCostosEsperado[i], matrizDeCostosObtenido[i], DELTA);
		}

		assertEquals(matrizDePredecesoresEsperado.length, matrizDePredecesoresObtenido.length);
		for (int i = 0; i < matrizDePredecesoresEsperado.length; i++) {
			for (int j = 0; j < matrizDePredecesoresEsperado[i].length; j++) {
				assertEquals(matrizDePredecesoresEsperado[i][j], matrizDePredecesoresObtenido[i][j]);
			}
		}
	}

}
