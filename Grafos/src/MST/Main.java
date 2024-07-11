package MST;

import Entidades.Grafo;
import Entidades.GrafoLista;
import Entidades.Vertice;

public class Main {

	public static void main(String[] args) {

		Grafo<String> grafo = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.ES_PONDERADO);

		Vertice<String> a = new Vertice<String>("A");
		Vertice<String> b = new Vertice<String>("B");
		Vertice<String> c = new Vertice<String>("C");
		Vertice<String> d = new Vertice<String>("D");
		Vertice<String> e = new Vertice<String>("E");
		Vertice<String> f = new Vertice<String>("F");
		Vertice<String> g = new Vertice<String>("G");
		Vertice<String> h = new Vertice<String>("H");

		grafo.agregarVertice(a);
		grafo.agregarVertice(b);
		grafo.agregarVertice(c);
		grafo.agregarVertice(d);
		grafo.agregarVertice(e);
		grafo.agregarVertice(f);
		grafo.agregarVertice(g);
		grafo.agregarVertice(h);

		grafo.agregarArista(a, b, 1);
		grafo.agregarArista(a, c, 13);
		grafo.agregarArista(a, d, 6);
		grafo.agregarArista(a, f, 5);
		grafo.agregarArista(b, c, 5);
		grafo.agregarArista(b, d, 14);
		grafo.agregarArista(b, e, 3);
		grafo.agregarArista(c, e, 4);
		grafo.agregarArista(c, h, 15);
		grafo.agregarArista(d, f, 7);
		grafo.agregarArista(d, g, 9);
		grafo.agregarArista(e, h, 8);
		grafo.agregarArista(e, g, 11);
		grafo.agregarArista(f, g, 2);
		grafo.agregarArista(f, h, 16);
		grafo.agregarArista(g, h, 10);

		Prim prim = new Prim();
		MST<String> mstConPrim = prim.generarMST(a, grafo);
		System.out.println("Algoritmo de Prim");
		System.out.println("Las aristas en el MST son:");
		System.out.println(mstConPrim.getArbol());
		System.out.println("El costo total del MST es: " + mstConPrim.getCostoTotal());

		System.out.println("===============================================");

		Kruskal kruskal = new Kruskal();
		MST<String> mstConKruskal = kruskal.generarMST(grafo);
		System.out.println("Algoritmo de Kruskal");
		System.out.println("Las aristas en el MST son:");
		System.out.println(mstConKruskal.getArbol());
		System.out.println("El costo total del MST es: " + mstConKruskal.getCostoTotal());

	}

}
