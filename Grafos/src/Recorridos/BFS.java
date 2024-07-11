package Recorridos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.Vertice;

public class BFS<T> {

	private Queue<Vertice<T>> colaDeVertices;

	private int[] vectorDeDistancias;

	public BFS() {
		this.colaDeVertices = new LinkedList<>();
	}

	public void recorrerGrafo(Grafo<T> grafo, Vertice<T> verticeInicial) {

		this.vectorDeDistancias = new int[grafo.obtenerCantidadDeVertices()];

		// Inicializar las distancias a "INFINITO"
		Arrays.fill(this.vectorDeDistancias, Arista.INFINITO);

		// Distancia al vertice inicial es 0
		this.vectorDeDistancias[grafo.obtenerIndiceDeVertice(verticeInicial)] = 0;
		this.colaDeVertices.add(verticeInicial);

		while (!this.colaDeVertices.isEmpty()) {
			Vertice<T> verticeDesacolado = this.colaDeVertices.poll();
			int indiceVertice = grafo.obtenerIndiceDeVertice(verticeDesacolado);
			System.out.print(verticeDesacolado + " ");

			for (Arista<T> arista : grafo.obtenerAristasDeVertice(verticeDesacolado)) {

				Vertice<T> vecino = arista.getDestino();
				int indiceVecino = grafo.obtenerIndiceDeVertice(vecino);

				if (this.vectorDeDistancias[indiceVecino] == Arista.INFINITO) {
					this.colaDeVertices.add(vecino);
					this.vectorDeDistancias[indiceVecino] = this.vectorDeDistancias[indiceVertice] + 1;
				}
			}
		}
		System.out.println("\nDistancias desde el vertice " + verticeInicial.getValor() + ":");
		imprimirVectorDeDistancias();
	}

	private void imprimirVectorDeDistancias() {
		for (int i = 0; i < this.vectorDeDistancias.length; i++) {
			System.out.println("Vertice " + i + (this.vectorDeDistancias[i] == Arista.INFINITO ? "\tINFINITO"
					: "\t" + this.vectorDeDistancias[i]));
		}
	}

}
