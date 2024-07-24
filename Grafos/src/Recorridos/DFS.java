package Recorridos;

import java.util.Stack;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.Vertice;
import Excepciones.VerticeInvalidoException;

public class DFS<T> {

	private static final boolean VISITADO = true;

	private Stack<Vertice<T>> pilaDeVertices;

	private boolean[] vectorDeVisitantes;

	public DFS() {
		pilaDeVertices = new Stack<Vertice<T>>();
	}

	public boolean[] recorrerGrafo(Grafo<T> grafo, Vertice<T> verticeInicial) throws VerticeInvalidoException {

		if (!grafo.contieneVertice(verticeInicial)) {
			throw new VerticeInvalidoException("El vertice " + verticeInicial.getValor() + " no pertence al grafo.");
		}

		this.vectorDeVisitantes = new boolean[grafo.obtenerCantidadDeVertices()];
		this.vectorDeVisitantes[grafo.obtenerIndiceDeVertice(verticeInicial)] = VISITADO;

		this.pilaDeVertices.push(verticeInicial);

		while (!pilaDeVertices.isEmpty()) {

			Vertice<T> verticeDesapilado = pilaDeVertices.pop();

			for (Arista<T> arista : grafo.obtenerAristasDeVertice(verticeDesapilado)) {

				Vertice<T> vecino = arista.getDestino();
				int indiceVecino = grafo.obtenerIndiceDeVertice(vecino);

				if (!vectorDeVisitantes[indiceVecino]) {
					this.pilaDeVertices.push(vecino);
					this.vectorDeVisitantes[indiceVecino] = VISITADO;
				}
			}
		}

		return this.vectorDeVisitantes;
	}

	@SuppressWarnings("unused")
	private void imprimirVectorDeVisitantes() {
		for (int i = 0; i < this.vectorDeVisitantes.length; i++) {
			System.out.println(
					"Vertice " + i + (this.vectorDeVisitantes[i] == VISITADO ? "\tVISITADO" : "\tNO VISITADO"));
		}
	}

}
