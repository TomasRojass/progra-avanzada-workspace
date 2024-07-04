package Recorridos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.Vertice;

public class Recorrido {
	
	public void dfs(Grafo grafo, int nodoInicial) {
		boolean[] vectorDeVisitado = new boolean[grafo.getCantidadDeVertices()];
		Stack<Integer> pila = new Stack<>();
		pila.push(nodoInicial);
		vectorDeVisitado[nodoInicial] = Vertice.VISITADO;
		while (!pila.isEmpty()) {
			int nodo = pila.pop();
			System.out.print(nodo + " ");
			for (Arista arista : grafo.getAristas()) {
				if (arista.getOrigen() == nodo && !vectorDeVisitado[arista.getDestino()]) {
					pila.push(arista.getDestino());
					vectorDeVisitado[arista.getDestino()] = Vertice.VISITADO;
				} else if (arista.getDestino() == nodo && !vectorDeVisitado[arista.getOrigen()]) {
					pila.push(arista.getOrigen());
					vectorDeVisitado[arista.getOrigen()] = Vertice.VISITADO;
				}
			}
		}
		System.out.println("");
		System.out.println("Vector de visitantes");
		for (int i = 0; i < vectorDeVisitado.length; i++) {
			System.out.println("Nodo " + i + (vectorDeVisitado[i] == Vertice.VISITADO ? "\tVISITADO" : "\tNO VISITADO"));
		}
	}

	public void bfs(Grafo grafo, int nodoInicial) {
		int[] distancias = new int[grafo.getCantidadDeVertices()];
		Queue<Integer> cola = new LinkedList<>();

		// Inicializar las distancias a "infinito"
		inicializarVectorDeDistancias(distancias);

		// Distancia al nodo inicial es 0
		distancias[nodoInicial] = 0;
		cola.add(nodoInicial);

		while (!cola.isEmpty()) {
			int nodo = cola.poll();
			System.out.print(nodo + " ");

			for (Arista arista : grafo.getAristas()) {
				if (arista.getOrigen() == nodo && distancias[arista.getDestino()] == Arista.INFINITO) {
					cola.add(arista.getDestino());
					distancias[arista.getDestino()] = distancias[nodo] + 1;
				} else if (arista.getDestino() == nodo && distancias[arista.getOrigen()] == Arista.INFINITO) {
					cola.add(arista.getOrigen());
					distancias[arista.getOrigen()] = distancias[nodo] + 1;
				}
			}
		}
		System.out.println("");
		System.out.println("Distancias desde el nodo inicial:");
		imprimirVectorDeDistancias(distancias);
	}
	
	private void inicializarVectorDeDistancias(int[] vectorDeDistancias) {
		for (int i = 0; i < vectorDeDistancias.length; i++) {
			vectorDeDistancias[i] = Arista.INFINITO;
		}
	}
	
	private void imprimirVectorDeDistancias(int[] vectorDeDistancias) {
		for (int i = 0; i < vectorDeDistancias.length; i++) {
			if (vectorDeDistancias[i] == Arista.INFINITO) {
				System.out.println("Nodo " + i + ": INFINITO");
			} else {
				System.out.println("Nodo " + i + ": " + vectorDeDistancias[i]);
			}
		}
	}
}
