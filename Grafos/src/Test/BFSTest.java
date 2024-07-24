package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.GrafoLista;
import Entidades.Vertice;
import Excepciones.VerticeInvalidoException;
import Recorridos.BFS;

public class BFSTest {

	private Grafo<Integer> grafoDeEnteros;

	private Vertice<Integer> cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez, once, doce;

	@Before
	public void setUp() throws Exception {

		grafoDeEnteros = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.ES_PONDERADO);

		cero = new Vertice<Integer>(0);
		uno = new Vertice<Integer>(1);
		dos = new Vertice<Integer>(2);
		tres = new Vertice<Integer>(3);
		cuatro = new Vertice<Integer>(4);
		cinco = new Vertice<Integer>(5);
		seis = new Vertice<Integer>(6);
		siete = new Vertice<Integer>(7);
		ocho = new Vertice<Integer>(8);
		nueve = new Vertice<Integer>(9);
		diez = new Vertice<Integer>(10);
		once = new Vertice<Integer>(11);
		doce = new Vertice<Integer>(12);
	}

	@Test
	public void testEjercicioDeClase() throws VerticeInvalidoException {

		grafoDeEnteros.agregarVertice(cero);
		grafoDeEnteros.agregarVertice(uno);
		grafoDeEnteros.agregarVertice(dos);
		grafoDeEnteros.agregarVertice(tres);
		grafoDeEnteros.agregarVertice(cuatro);
		grafoDeEnteros.agregarVertice(cinco);
		grafoDeEnteros.agregarVertice(seis);
		grafoDeEnteros.agregarVertice(siete);
		grafoDeEnteros.agregarVertice(ocho);
		grafoDeEnteros.agregarVertice(nueve);
		grafoDeEnteros.agregarVertice(diez);
		grafoDeEnteros.agregarVertice(once);
		grafoDeEnteros.agregarVertice(doce);

		grafoDeEnteros.agregarArista(cero, uno);
		grafoDeEnteros.agregarArista(cero, ocho);
		grafoDeEnteros.agregarArista(uno, dos);
		grafoDeEnteros.agregarArista(uno, cinco);
		grafoDeEnteros.agregarArista(dos, tres);
		grafoDeEnteros.agregarArista(cuatro, cinco);
		grafoDeEnteros.agregarArista(cuatro, ocho);
		grafoDeEnteros.agregarArista(cinco, seis);
		grafoDeEnteros.agregarArista(cinco, nueve);
		grafoDeEnteros.agregarArista(seis, siete);
		grafoDeEnteros.agregarArista(ocho, nueve);
		grafoDeEnteros.agregarArista(nueve, diez);
		grafoDeEnteros.agregarArista(once, doce);

		BFS<Integer> bfs = new BFS<>();
		int[] resultadoEsperado = { 0, 1, 2, 3, 2, 2, 3, 4, 1, 2, 3, Arista.INFINITO_INTEGER, Arista.INFINITO_INTEGER };
		int[] resultadoObtenido = bfs.recorrerGrafo(grafoDeEnteros, cero);

		assertArrayEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test(expected = VerticeInvalidoException.class)
	public void testVerticeNoPerteneceAlGrafo() throws VerticeInvalidoException {

		grafoDeEnteros.agregarVertice(cero);
		grafoDeEnteros.agregarVertice(uno);
		grafoDeEnteros.agregarVertice(dos);
		grafoDeEnteros.agregarVertice(tres);

		Vertice<Integer> verticeNoEnGrafo = new Vertice<Integer>(100);

		BFS<Integer> bfs = new BFS<>();
		bfs.recorrerGrafo(grafoDeEnteros, verticeNoEnGrafo);
	}

}
