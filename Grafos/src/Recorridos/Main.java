package Recorridos;

import Entidades.Grafo;
import Entidades.GrafoLista;
import Entidades.Vertice;

public class Main {

	public static void main(String[] args) {

		Grafo<Integer> grafo = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.NO_ES_PONDERADO);

		Vertice<Integer> cero = new Vertice<>(0);
		Vertice<Integer> uno = new Vertice<>(1);
		Vertice<Integer> dos = new Vertice<>(2);
		Vertice<Integer> tres = new Vertice<>(3);
		Vertice<Integer> cuatro = new Vertice<>(4);
		Vertice<Integer> cinco = new Vertice<>(5);
		Vertice<Integer> seis = new Vertice<>(6);
		Vertice<Integer> siete = new Vertice<>(7);
		Vertice<Integer> ocho = new Vertice<>(8);
		Vertice<Integer> nueve = new Vertice<>(9);
		Vertice<Integer> diez = new Vertice<>(10);
		Vertice<Integer> once = new Vertice<>(11);
		Vertice<Integer> doce = new Vertice<>(12);

		grafo.agregarVertice(cero);
		grafo.agregarVertice(uno);
		grafo.agregarVertice(dos);
		grafo.agregarVertice(tres);
		grafo.agregarVertice(cuatro);
		grafo.agregarVertice(cinco);
		grafo.agregarVertice(seis);
		grafo.agregarVertice(siete);
		grafo.agregarVertice(ocho);
		grafo.agregarVertice(nueve);
		grafo.agregarVertice(diez);
		grafo.agregarVertice(once);
		grafo.agregarVertice(doce);

		grafo.agregarArista(cero, uno);
		grafo.agregarArista(cero, ocho);
		grafo.agregarArista(uno, dos);
		grafo.agregarArista(uno, cinco);
		grafo.agregarArista(dos, tres);
		grafo.agregarArista(cuatro, cinco);
		grafo.agregarArista(cuatro, ocho);
		grafo.agregarArista(cinco, seis);
		grafo.agregarArista(cinco, nueve);
		grafo.agregarArista(seis, siete);
		grafo.agregarArista(ocho, nueve);
		grafo.agregarArista(nueve, diez);
		grafo.agregarArista(once, doce);

		DFS<Integer> dfs = new DFS<>();
		System.out.println("DFS (empezando desde el nodo 0):");
		dfs.recorrerGrafo(grafo, cero);

		System.out.println("=====================================");

		BFS<Integer> bfs = new BFS<>();
		System.out.println("BFS (empezando desde el nodo 0):");
		bfs.recorrerGrafo(grafo, cero);
	}

}
