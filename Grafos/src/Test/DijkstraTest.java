package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Costos.Dijkstra;
import Entidades.Grafo;
import Entidades.GrafoLista;
import Entidades.Vertice;
import Excepciones.VerticeInvalidoException;

public class DijkstraTest {

	private static final double DELTA = 1e-9;

	private Grafo<Integer> grafoDeEnteros;

	private Vertice<Integer> cero, uno, dos, tres, cuatro, cinco;

	@Before
	public void setUp() throws Exception {
		this.grafoDeEnteros = new GrafoLista<Integer>(Grafo.ES_DIRIGIDO, Grafo.ES_PONDERADO);
		this.cero = new Vertice<>(0);
		this.uno = new Vertice<>(1);
		this.dos = new Vertice<>(2);
		this.tres = new Vertice<>(3);
		this.cuatro = new Vertice<>(4);
		this.cinco = new Vertice<>(5);
	}

	// https://youtu.be/fgdCNuGPJnw?si=3jDP-76w6NCn6cq9
	@Test
	public void testEjercicioVideo() throws VerticeInvalidoException {
		Grafo<Character> grafoCaracteres = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.ES_PONDERADO);

		Vertice<Character> s = new Vertice<>('S');
		Vertice<Character> b = new Vertice<>('B');
		Vertice<Character> c = new Vertice<>('C');
		Vertice<Character> d = new Vertice<>('D');
		Vertice<Character> e = new Vertice<>('E');
		Vertice<Character> t = new Vertice<>('T');

		grafoCaracteres.agregarVertice(s);
		grafoCaracteres.agregarVertice(b);
		grafoCaracteres.agregarVertice(c);
		grafoCaracteres.agregarVertice(d);
		grafoCaracteres.agregarVertice(e);
		grafoCaracteres.agregarVertice(t);

		grafoCaracteres.agregarArista(s, b, 4.0);
		grafoCaracteres.agregarArista(s, c, 2.0);
		grafoCaracteres.agregarArista(b, c, 1.0);
		grafoCaracteres.agregarArista(b, d, 5.0);
		grafoCaracteres.agregarArista(c, d, 8.0);
		grafoCaracteres.agregarArista(c, e, 10.0);
		grafoCaracteres.agregarArista(d, e, 2.0);
		grafoCaracteres.agregarArista(d, t, 6.0);
		grafoCaracteres.agregarArista(e, t, 2.0);

		Dijkstra<Character> dijkstra = new Dijkstra<>();

		List<Vertice<Character>> caminoMinimoEsperado = new ArrayList<>();
		caminoMinimoEsperado.add(s);
		caminoMinimoEsperado.add(c);
		caminoMinimoEsperado.add(b);
		caminoMinimoEsperado.add(d);
		caminoMinimoEsperado.add(e);
		caminoMinimoEsperado.add(t);

		double costoMinimoDeCaminoEsperado = 12.0;

		List<Vertice<Character>> caminoMinimoObtenido = dijkstra.encontrarCaminoMinimo(grafoCaracteres, s, t);
		double costoMinimoDeCaminoObtenido = dijkstra.obtenerCostoCamino(grafoCaracteres, s, t);
		assertEquals(caminoMinimoEsperado, caminoMinimoObtenido);
		assertEquals(costoMinimoDeCaminoEsperado, costoMinimoDeCaminoObtenido, DELTA);
	}

	@Test
	public void testEjemploGrafoCiudades() throws VerticeInvalidoException {
		Grafo<String> grafoCiudades = new GrafoLista<>(Grafo.ES_DIRIGIDO, Grafo.ES_PONDERADO);

		Vertice<String> buenosAires = new Vertice<>("Buenos Aires");
		Vertice<String> sanPablo = new Vertice<>("San Pablo");
		Vertice<String> madrid = new Vertice<>("Madrid");
		Vertice<String> barcelona = new Vertice<>("Barcelona");
		Vertice<String> paris = new Vertice<>("Paris");

		grafoCiudades.agregarVertice(buenosAires);
		grafoCiudades.agregarVertice(sanPablo);
		grafoCiudades.agregarVertice(madrid);
		grafoCiudades.agregarVertice(barcelona);
		grafoCiudades.agregarVertice(paris);

		grafoCiudades.agregarArista(buenosAires, sanPablo, 500);
		grafoCiudades.agregarArista(buenosAires, madrid, 1500);
		grafoCiudades.agregarArista(buenosAires, barcelona, 1200);
		grafoCiudades.agregarArista(sanPablo, barcelona, 800);
		grafoCiudades.agregarArista(barcelona, paris, 10);
		grafoCiudades.agregarArista(barcelona, madrid, 100);
		grafoCiudades.agregarArista(paris, madrid, 50);

		Dijkstra<String> dijkstra = new Dijkstra<String>();
		dijkstra.aplicarAlgoritmo(grafoCiudades, buenosAires);

	}

	@Test
	public void testEjemploDiapositiva() throws VerticeInvalidoException {

		grafoDeEnteros.agregarVertice(cero);
		grafoDeEnteros.agregarVertice(uno);
		grafoDeEnteros.agregarVertice(dos);
		grafoDeEnteros.agregarVertice(tres);

		grafoDeEnteros.agregarArista(cero, uno, 7);
		grafoDeEnteros.agregarArista(cero, dos, 3);
		grafoDeEnteros.agregarArista(uno, tres, 2);
		grafoDeEnteros.agregarArista(dos, uno, 2);
		grafoDeEnteros.agregarArista(dos, tres, 8);

		Dijkstra<Integer> dijkstra = new Dijkstra<>();
		dijkstra.aplicarAlgoritmo(grafoDeEnteros, cero);

		Map<Vertice<Integer>, Double> distanciasEsperadas = new HashMap<>();
		distanciasEsperadas.put(cero, 0.0);
		distanciasEsperadas.put(uno, 5.0);
		distanciasEsperadas.put(dos, 3.0);
		distanciasEsperadas.put(tres, 7.0);

		Map<Vertice<Integer>, Vertice<Integer>> predecesoresEsperados = new HashMap<>();
		predecesoresEsperados.put(cero, null);
		predecesoresEsperados.put(uno, dos);
		predecesoresEsperados.put(dos, cero);
		predecesoresEsperados.put(tres, uno);

		Map<Vertice<Integer>, Double> distanciasObtenidas = dijkstra.getDistancias();
		Map<Vertice<Integer>, Vertice<Integer>> predecesoresObtenidos = dijkstra.getPredecesores();

		assertEquals(distanciasObtenidas, distanciasEsperadas);
		assertEquals(predecesoresObtenidos, predecesoresEsperados);
	}

	@Test
	public void testEjemploDeClase() throws VerticeInvalidoException {
		grafoDeEnteros.agregarVertice(uno);
		grafoDeEnteros.agregarVertice(dos);
		grafoDeEnteros.agregarVertice(tres);
		grafoDeEnteros.agregarVertice(cuatro);
		grafoDeEnteros.agregarVertice(cinco);

		grafoDeEnteros.agregarArista(uno, dos, 10);
		grafoDeEnteros.agregarArista(uno, cuatro, 30);
		grafoDeEnteros.agregarArista(uno, cinco, 100);
		grafoDeEnteros.agregarArista(dos, tres, 50);
		grafoDeEnteros.agregarArista(tres, cinco, 10);
		grafoDeEnteros.agregarArista(cuatro, tres, 20);
		grafoDeEnteros.agregarArista(cuatro, cinco, 60);

		Dijkstra<Integer> dijkstra = new Dijkstra<>();
		dijkstra.aplicarAlgoritmo(grafoDeEnteros, uno);

		Map<Vertice<Integer>, Double> distanciasEsperadas = new HashMap<>();
		distanciasEsperadas.put(uno, 0.0);
		distanciasEsperadas.put(dos, 10.0);
		distanciasEsperadas.put(tres, 50.0);
		distanciasEsperadas.put(cuatro, 30.0);
		distanciasEsperadas.put(cinco, 60.0);

		Map<Vertice<Integer>, Vertice<Integer>> predecesoresEsperados = new HashMap<>();
		predecesoresEsperados.put(uno, null);
		predecesoresEsperados.put(dos, uno);
		predecesoresEsperados.put(tres, cuatro);
		predecesoresEsperados.put(cuatro, uno);
		predecesoresEsperados.put(cinco, tres);

		Map<Vertice<Integer>, Double> distanciasObtenidas = dijkstra.getDistancias();
		Map<Vertice<Integer>, Vertice<Integer>> predecesoresObtenidos = dijkstra.getPredecesores();

		assertEquals(distanciasObtenidas, distanciasEsperadas);
		assertEquals(predecesoresObtenidos, predecesoresEsperados);
	}

}
