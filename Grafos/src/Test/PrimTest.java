package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.GrafoLista;
import Entidades.Vertice;
import Excepciones.VerticeInvalidoException;
import MST.MST;
import MST.Prim;

public class PrimTest {

	private Prim prim;

	private Grafo<Character> grafoDeCaracteres;

	private Grafo<Integer> grafoDeEnteros;

	private Vertice<Character> A, B, C, D, E, F, G, H;

	private Vertice<Integer> uno, dos, tres, cuatro, cinco, seis;

	@Before
	public void setUp() throws Exception {
		prim = new Prim();

		A = new Vertice<>('A');
		B = new Vertice<>('B');
		C = new Vertice<>('C');
		D = new Vertice<>('D');
		E = new Vertice<>('E');
		F = new Vertice<>('F');
		G = new Vertice<>('G');
		H = new Vertice<>('H');

		uno = new Vertice<Integer>(1);
		dos = new Vertice<Integer>(2);
		tres = new Vertice<Integer>(3);
		cuatro = new Vertice<Integer>(4);
		cinco = new Vertice<Integer>(5);
		seis = new Vertice<Integer>(6);

		grafoDeCaracteres = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.ES_PONDERADO);

		grafoDeEnteros = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.ES_PONDERADO);
	}

	// https://youtu.be/-2NlTulDUq4?si=HHjKtL9igOC7qdS1
	@Test
	public void testEjemploVideo() throws VerticeInvalidoException {

		grafoDeCaracteres.agregarVertice(A);
		grafoDeCaracteres.agregarVertice(B);
		grafoDeCaracteres.agregarVertice(C);
		grafoDeCaracteres.agregarVertice(D);
		grafoDeCaracteres.agregarVertice(E);
		grafoDeCaracteres.agregarVertice(F);
		grafoDeCaracteres.agregarVertice(G);
		grafoDeCaracteres.agregarVertice(H);

		grafoDeCaracteres.agregarArista(A, B, 1);
		grafoDeCaracteres.agregarArista(A, C, 13);
		grafoDeCaracteres.agregarArista(A, D, 6);
		grafoDeCaracteres.agregarArista(A, F, 5);
		grafoDeCaracteres.agregarArista(B, C, 5);
		grafoDeCaracteres.agregarArista(B, D, 14);
		grafoDeCaracteres.agregarArista(B, E, 3);
		grafoDeCaracteres.agregarArista(C, E, 4);
		grafoDeCaracteres.agregarArista(C, H, 15);
		grafoDeCaracteres.agregarArista(D, F, 7);
		grafoDeCaracteres.agregarArista(D, G, 9);
		grafoDeCaracteres.agregarArista(E, H, 8);
		grafoDeCaracteres.agregarArista(E, G, 11);
		grafoDeCaracteres.agregarArista(F, G, 2);
		grafoDeCaracteres.agregarArista(F, H, 16);
		grafoDeCaracteres.agregarArista(G, H, 10);

		MST<Character> mst = prim.generarMST(A, grafoDeCaracteres);
		int resultadoEsperado = 29;
		int resultadoObtenido = mst.getCostoTotal();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void testEjercicioDeClase() throws VerticeInvalidoException {

		grafoDeCaracteres.agregarVertice(A);
		grafoDeCaracteres.agregarVertice(B);
		grafoDeCaracteres.agregarVertice(C);
		grafoDeCaracteres.agregarVertice(D);
		grafoDeCaracteres.agregarVertice(E);
		grafoDeCaracteres.agregarVertice(F);
		grafoDeCaracteres.agregarVertice(G);

		grafoDeCaracteres.agregarArista(A, B, 2);
		grafoDeCaracteres.agregarArista(A, D, 4);
		grafoDeCaracteres.agregarArista(A, F, 5);
		grafoDeCaracteres.agregarArista(B, C, 7);
		grafoDeCaracteres.agregarArista(B, D, 1);
		grafoDeCaracteres.agregarArista(B, E, 3);
		grafoDeCaracteres.agregarArista(B, F, 8);
		grafoDeCaracteres.agregarArista(B, G, 4);
		grafoDeCaracteres.agregarArista(C, E, 10);
		grafoDeCaracteres.agregarArista(C, G, 6);
		grafoDeCaracteres.agregarArista(D, E, 2);
		grafoDeCaracteres.agregarArista(F, G, 1);

		MST<Character> mst = prim.generarMST(A, grafoDeCaracteres);
		int resultadoEsperado = 16;
		int resultadoObtenido = mst.getCostoTotal();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void testEjercicioParcial() throws VerticeInvalidoException {

		grafoDeCaracteres.agregarVertice(A);
		grafoDeCaracteres.agregarVertice(B);
		grafoDeCaracteres.agregarVertice(C);
		grafoDeCaracteres.agregarVertice(D);
		grafoDeCaracteres.agregarVertice(E);
		grafoDeCaracteres.agregarVertice(F);
		grafoDeCaracteres.agregarVertice(G);
		grafoDeCaracteres.agregarVertice(H);

		grafoDeCaracteres.agregarArista(A, B, 2);
		grafoDeCaracteres.agregarArista(A, E, 7);
		grafoDeCaracteres.agregarArista(B, C, 7);
		grafoDeCaracteres.agregarArista(B, E, 2);
		grafoDeCaracteres.agregarArista(B, F, 12);
		grafoDeCaracteres.agregarArista(B, G, 10);
		grafoDeCaracteres.agregarArista(C, D, 3);
		grafoDeCaracteres.agregarArista(C, G, 9);
		grafoDeCaracteres.agregarArista(C, H, 8);
		grafoDeCaracteres.agregarArista(D, H, 4);
		grafoDeCaracteres.agregarArista(E, F, 11);
		grafoDeCaracteres.agregarArista(F, G, 3);
		grafoDeCaracteres.agregarArista(G, H, 13);

		MST<Character> mst = prim.generarMST(A, grafoDeCaracteres);
		int resultadoEsperado = 30;
		int resultadoObtenido = mst.getCostoTotal();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test
	public void testEjercicioRecuperatorio() throws VerticeInvalidoException {

		grafoDeEnteros.agregarVertice(uno);
		grafoDeEnteros.agregarVertice(dos);
		grafoDeEnteros.agregarVertice(tres);
		grafoDeEnteros.agregarVertice(cuatro);
		grafoDeEnteros.agregarVertice(cinco);
		grafoDeEnteros.agregarVertice(seis);

		grafoDeEnteros.agregarArista(uno, dos, 3);
		grafoDeEnteros.agregarArista(uno, tres, 2);
		grafoDeEnteros.agregarArista(uno, cuatro, 3);
		grafoDeEnteros.agregarArista(dos, tres, 1);
		grafoDeEnteros.agregarArista(dos, cinco, 5);
		grafoDeEnteros.agregarArista(tres, cuatro, 2);
		grafoDeEnteros.agregarArista(tres, cinco, 5);
		grafoDeEnteros.agregarArista(tres, seis, 8);
		grafoDeEnteros.agregarArista(cuatro, seis, 6);
		grafoDeEnteros.agregarArista(cinco, seis, 4);

		// Como el enunciado dice que la arista 3 y 6 se encuentra techada, entonces
		Arista<Integer> aristaTechada = grafoDeEnteros.obtenerArista(tres, seis);
		aristaTechada.setPeso(0);

		MST<Integer> mst = prim.generarMST(tres, grafoDeEnteros);
		int resultadoEsperado = 9;
		int resultadoObtenido = mst.getCostoTotal();

		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	@Test(expected = VerticeInvalidoException.class)
	public void testVerticeNoPerteneceAlGrafo() throws VerticeInvalidoException {

		grafoDeCaracteres.agregarVertice(A);
		grafoDeCaracteres.agregarVertice(B);
		grafoDeCaracteres.agregarVertice(C);
		
		grafoDeCaracteres.agregarArista(A, B, 1);
		grafoDeCaracteres.agregarArista(B, C, 2);

		assertNull(prim.generarMST(D, grafoDeCaracteres));
	}

}
