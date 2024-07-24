package Costos;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.Vertice;
import Excepciones.CicloNegativoException;
import Excepciones.VerticeInvalidoException;

import java.util.Arrays;

public class BellmanFord<T> {

	private double[] vectorDeDistancias;

	private Vertice<T>[] vectorDePredecesores;

	@SuppressWarnings("unchecked")
	public void aplicarAlgoritmo(Grafo<T> grafo, Vertice<T> verticeOrigen)
			throws VerticeInvalidoException, CicloNegativoException {

		if (!grafo.contieneVertice(verticeOrigen)) {
			throw new VerticeInvalidoException("El vertice " + verticeOrigen.getValor() + " no pertenece al grafo.");
		}

		int cantidadDeVertices = grafo.obtenerCantidadDeVertices();

		// Inicialización
		this.vectorDeDistancias = new double[cantidadDeVertices];
		this.vectorDePredecesores = new Vertice[cantidadDeVertices];
		Arrays.fill(this.vectorDeDistancias, Arista.INFINITO_DOUBLE);
		Arrays.fill(this.vectorDePredecesores, null);
		this.vectorDeDistancias[grafo.obtenerIndiceDeVertice(verticeOrigen)] = 0;
		this.vectorDePredecesores[grafo.obtenerIndiceDeVertice(verticeOrigen)] = verticeOrigen;

		// Relajación de aristas o actualizacion de distancias
		for (int i = 1; i < cantidadDeVertices; ++i) {
			for (Arista<T> arista : grafo.obtenerAristas()) {
				Vertice<T> origen = arista.getOrigen();
				Vertice<T> destino = arista.getDestino();
				double peso = arista.getPeso();

				int indiceOrigen = grafo.obtenerIndiceDeVertice(origen);
				int indiceDestino = grafo.obtenerIndiceDeVertice(destino);

				if (this.vectorDeDistancias[indiceOrigen] != Arista.INFINITO_DOUBLE
						&& this.vectorDeDistancias[indiceOrigen] + peso < this.vectorDeDistancias[indiceDestino]) {
					this.vectorDeDistancias[indiceDestino] = this.vectorDeDistancias[indiceOrigen] + peso;
					this.vectorDePredecesores[indiceDestino] = arista.getOrigen();
				}
			}
		}

		// Detección de ciclos de peso negativo
		for (Arista<T> arista : grafo.obtenerAristas()) {
			Vertice<T> origen = arista.getOrigen();
			Vertice<T> destino = arista.getDestino();
			double peso = arista.getPeso();

			int indiceOrigen = grafo.obtenerIndiceDeVertice(origen);
			int indiceDestino = grafo.obtenerIndiceDeVertice(destino);

			if (this.vectorDeDistancias[indiceOrigen] != Arista.INFINITO_INTEGER
					&& this.vectorDeDistancias[indiceOrigen] + peso < this.vectorDeDistancias[indiceDestino]) {
				throw new CicloNegativoException("El grafo contiene un ciclo de peso negativo");
			}
		}

	}

	public double[] getVectorDeDistancias() {
		return vectorDeDistancias;
	}

	public Vertice<T>[] getVectorDePredecesores() {
		return vectorDePredecesores;
	}

	public void imprimirVectorDeDistancias(Grafo<T> grafo) {
		System.out.print("Vertice:");
		for (Vertice<T> vertice : grafo.obtenerVertices()) {
			System.out.print("\t" + vertice.getValor());
		}
		System.out.print("\nDistancia:");
		for (int i = 0; i < this.vectorDeDistancias.length; ++i) {
			System.out.print("\t" + this.vectorDeDistancias[i]);
		}
	}

	public void imprimirVectorDePredecesores(Grafo<T> grafo) {
		System.out.print("Vertice:");
		for (Vertice<T> vertice : grafo.obtenerVertices()) {
			System.out.print("\t" + vertice.getValor());
		}
		System.out.print("\nPredecesor:");
		for (int i = 0; i < this.vectorDePredecesores.length; ++i) {
			System.out.print("\t" + (this.vectorDePredecesores[i] == null ? "N/A" : this.vectorDePredecesores[i]));
		}
	}

}
