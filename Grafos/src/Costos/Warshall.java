package Costos;

import Entidades.Arista;
import Entidades.Grafo;

public class Warshall<T> {

	private boolean[][] matrizDeCerradura;

	public void aplicarAlgoritmo(Grafo<T> grafo) {
		crearMatrizDeCerradura(grafo);
		int cantidadDeVertices = grafo.obtenerCantidadDeVertices();
		for (int k = 0; k < cantidadDeVertices; k++) {
			for (int i = 0; i < cantidadDeVertices; i++) {
				for (int j = 0; j < cantidadDeVertices; j++) {
					matrizDeCerradura[i][j] = matrizDeCerradura[i][j]
							|| (matrizDeCerradura[i][k] && matrizDeCerradura[k][j]);
				}
			}
		}
	}

	public boolean[][] getMatrizDeCerradura() {
		return matrizDeCerradura;
	}

	public void imprimirMatrizDeCerradura() {
		int cantidadDeVertices = matrizDeCerradura.length;
		for (int i = 0; i < cantidadDeVertices; i++) {
			for (int j = 0; j < cantidadDeVertices; j++) {
				System.out.print(matrizDeCerradura[i][j] ? "1" : "0");
				System.out.print(j < cantidadDeVertices - 1 ? "\t" : "\n");
			}
		}
	}

	// Privados

	private void crearMatrizDeCerradura(Grafo<T> grafo) {
		int cantidadDeVertices = grafo.obtenerCantidadDeVertices();
		matrizDeCerradura = new boolean[cantidadDeVertices][cantidadDeVertices];
		double[][] matrizAdyacencia = grafo.getMatrizAdyacencia();
		for (int i = 0; i < cantidadDeVertices; i++) {
			for (int j = 0; j < cantidadDeVertices; j++) {
				matrizDeCerradura[i][j] = i == j ? false : matrizAdyacencia[i][j] != Arista.INFINITO_DOUBLE;
			}
		}
	}

}
