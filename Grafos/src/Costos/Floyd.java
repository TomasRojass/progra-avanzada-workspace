package Costos;

import java.util.Arrays;
import Entidades.Arista;
import Entidades.Grafo;
import Entidades.Vertice;

public class Floyd<T> {

	private double[][] matrizDeCostos;

	private Vertice<T>[][] matrizDePredecesores;

	public void aplicarAlgoritmo(Grafo<T> grafo) {
		crearMatrizDeCostos(grafo);
		crearMatrizDePredecesores(grafo);
		int cantidadDeVertices = grafo.obtenerCantidadDeVertices();
		for (int k = 0; k < cantidadDeVertices; k++) {
			for (int i = 0; i < cantidadDeVertices; i++) {
				for (int j = 0; j < cantidadDeVertices; j++) {
					if (matrizDeCostos[i][k] != Arista.INFINITO_DOUBLE && matrizDeCostos[k][j] != Arista.INFINITO_DOUBLE
							&& matrizDeCostos[i][k] + matrizDeCostos[k][j] < matrizDeCostos[i][j]) {
						matrizDeCostos[i][j] = matrizDeCostos[i][k] + matrizDeCostos[k][j];
						matrizDePredecesores[i][j] = grafo.obtenerVertices().get(k);
					}
				}
			}
		}
	}

	public double[][] getMatrizDeCostos() {
		return matrizDeCostos;
	}

	public Vertice<T>[][] getMatrizDePredecesores() {
		return matrizDePredecesores;
	}

	public void imprimirMatrizDePredecesores() {
		int cantidadDeVertices = this.matrizDePredecesores.length;
		for (int i = 0; i < cantidadDeVertices; i++) {
			for (int j = 0; j < cantidadDeVertices; j++) {
				System.out.print((i == j ? "-" : this.matrizDePredecesores[i][j].getValor())
						+ (j < cantidadDeVertices - 1 ? "\t" : "\n"));
			}
		}
	}

	public void imprimirMatrizDeCostos() {
		int cantidadDeVertices = matrizDeCostos.length;
		for (int i = 0; i < cantidadDeVertices; i++) {
			for (int j = 0; j < cantidadDeVertices; j++) {
				System.out
						.print((this.matrizDeCostos[i][j] == Arista.INFINITO_DOUBLE ? "INF" : this.matrizDeCostos[i][j])
								+ (j < cantidadDeVertices - 1 ? "\t" : "\n"));
			}
		}
	}

	// Privados

	@SuppressWarnings("unchecked")
	private void crearMatrizDePredecesores(Grafo<T> grafo) {
		int cantidadDeVertices = grafo.obtenerCantidadDeVertices();
		this.matrizDePredecesores = (Vertice<T>[][]) new Vertice[cantidadDeVertices][cantidadDeVertices];
		for (Vertice<T> vertice : grafo.obtenerVertices()) {
			int indiceVertice = grafo.obtenerIndiceDeVertice(vertice);
			for (int i = 0; i < cantidadDeVertices; i++) {
				this.matrizDePredecesores[i][indiceVertice] = i == indiceVertice ? null : vertice;
			}
		}
	}

	private void crearMatrizDeCostos(Grafo<T> grafo) {
		int cantidadDeVertices = grafo.obtenerCantidadDeVertices();
		this.matrizDeCostos = new double[cantidadDeVertices][cantidadDeVertices];
		for (int i = 0; i < cantidadDeVertices; i++) {
			Arrays.fill(matrizDeCostos[i], Arista.INFINITO_DOUBLE);
			this.matrizDeCostos[i][i] = 0;
		}
		for (Vertice<T> vertice : grafo.obtenerVertices()) {
			int indiceOrigen = grafo.obtenerIndiceDeVertice(vertice);
			for (Arista<T> arista : grafo.obtenerAristasDeVertice(vertice)) {
				int indiceDestino = grafo.obtenerIndiceDeVertice(arista.getDestino());
				this.matrizDeCostos[indiceOrigen][indiceDestino] = arista.getPeso();
			}
		}

	}
}
