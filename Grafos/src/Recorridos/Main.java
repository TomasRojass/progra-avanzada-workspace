package Recorridos;

import Entidades.Grafo;
import Entidades.GrafoImpLista;

public class Main {

	public static void main(String[] args) {
		Grafo grafo = new GrafoImpLista();
        
		// Este grafo es el ejemplo de las diapositivas de clase (Grafo no ponderado)
        grafo.agregarArista(0, 1, Grafo.SIN_COSTO);
        grafo.agregarArista(0, 8, Grafo.SIN_COSTO);
        grafo.agregarArista(1, 2, Grafo.SIN_COSTO);
        grafo.agregarArista(1, 5, Grafo.SIN_COSTO);
        grafo.agregarArista(2, 3, Grafo.SIN_COSTO);
        grafo.agregarArista(4, 5, Grafo.SIN_COSTO);
        grafo.agregarArista(4, 8, Grafo.SIN_COSTO);
        grafo.agregarArista(5, 6, Grafo.SIN_COSTO);
        grafo.agregarArista(5, 9, Grafo.SIN_COSTO);
        grafo.agregarArista(6, 7, Grafo.SIN_COSTO);
        grafo.agregarArista(8, 9, Grafo.SIN_COSTO);
        grafo.agregarArista(9, 10, Grafo.SIN_COSTO);
        grafo.agregarArista(11, 12, Grafo.SIN_COSTO);
        
        Recorrido recorrido = new Recorrido();
        System.out.println("DFS (empezando desde el nodo 0):");
        recorrido.dfs(grafo, 0);
        System.out.println("===============================================");
        System.out.println("BFS (empezando desde el nodo 0):");
        recorrido.bfs(grafo, 0);
	}

}
