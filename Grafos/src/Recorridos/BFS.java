package Recorridos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.Vertice;
import Excepciones.VerticeInvalidoException;

public class BFS<T> {

	private Queue<Vertice<T>> colaDeVertices;

	private int[] vectorDeDistancias;

	public BFS() {
		this.colaDeVertices = new LinkedList<>();
	}

	public int[] recorrerGrafo(Grafo<T> grafo, Vertice<T> verticeInicial) throws VerticeInvalidoException {

		if (!grafo.contieneVertice(verticeInicial)) {
			throw new VerticeInvalidoException("El vertice " + verticeInicial.getValor() + " no pertence al grafo.");
		}

		this.vectorDeDistancias = new int[grafo.obtenerCantidadDeVertices()];

		// Inicializar las distancias a "INFINITO"
		Arrays.fill(this.vectorDeDistancias, Arista.INFINITO_INTEGER);

		// Distancia al vertice inicial es 0
		this.vectorDeDistancias[grafo.obtenerIndiceDeVertice(verticeInicial)] = 0;
		this.colaDeVertices.add(verticeInicial);

		while (!this.colaDeVertices.isEmpty()) {
			Vertice<T> verticeDesacolado = this.colaDeVertices.poll();
			int indiceVertice = grafo.obtenerIndiceDeVertice(verticeDesacolado);

			for (Arista<T> arista : grafo.obtenerAristasDeVertice(verticeDesacolado)) {

				Vertice<T> vecino = arista.getDestino();
				int indiceVecino = grafo.obtenerIndiceDeVertice(vecino);

				if (this.vectorDeDistancias[indiceVecino] == Arista.INFINITO_INTEGER) {
					this.colaDeVertices.add(vecino);
					this.vectorDeDistancias[indiceVecino] = this.vectorDeDistancias[indiceVertice] + 1;
				}
			}
		}

		return this.vectorDeDistancias;
	}

	// Privados

	@SuppressWarnings("unused")
	private void imprimirVectorDeDistancias() {
		for (int i = 0; i < this.vectorDeDistancias.length; i++) {
			System.out.println("Vertice " + i + (this.vectorDeDistancias[i] == Arista.INFINITO_INTEGER ? "\tINFINITO"
					: "\t" + this.vectorDeDistancias[i]));
		}
	}

}
