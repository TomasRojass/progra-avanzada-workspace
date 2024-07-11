package Recorridos;

import java.util.Stack;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.Vertice;

public class DFS<T> {

	private static final boolean VISITADO = true;

	private Stack<Vertice<T>> pilaDeVertices;

	private boolean[] vectorDeVisitantes;

	public DFS() {
		pilaDeVertices = new Stack<Vertice<T>>();
	}

	public void recorrerGrafo(Grafo<T> grafo, Vertice<T> verticeInicial) {

		if (!grafo.contieneVertice(verticeInicial)) {
			System.out.println("El vertice " + verticeInicial.getValor() + " no pertenece al grafo.");
			return;
		}

		this.vectorDeVisitantes = new boolean[grafo.obtenerCantidadDeVertices()];
		this.vectorDeVisitantes[grafo.obtenerIndiceDeVertice(verticeInicial)] = VISITADO;

		this.pilaDeVertices.push(verticeInicial);

		while (!pilaDeVertices.isEmpty()) {

			Vertice<T> verticeDesapilado = pilaDeVertices.pop();
			System.out.print(verticeDesapilado.getValor() + " ");

			for (Arista<T> arista : grafo.obtenerAristasDeVertice(verticeDesapilado)) {

				Vertice<T> vecino = arista.getDestino();
				int indiceVecino = grafo.obtenerIndiceDeVertice(vecino);

				if (!vectorDeVisitantes[indiceVecino]) {
					this.pilaDeVertices.push(vecino);
					this.vectorDeVisitantes[indiceVecino] = VISITADO;
				}
			}
		}

		System.out.println("\nVector de visitantes");
		imprimirVectorDeVisitantes();
	}

	private void imprimirVectorDeVisitantes() {
		for (int i = 0; i < this.vectorDeVisitantes.length; i++) {
			System.out.println(
					"Vertice " + i + (this.vectorDeVisitantes[i] == VISITADO ? "\tVISITADO" : "\tNO VISITADO"));
		}
	}

}
