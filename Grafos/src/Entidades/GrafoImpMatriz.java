package Entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrafoImpMatriz implements Grafo {

	int cantidadDeVertices;
	int[][] matrizDeAdyacencia;

	public GrafoImpMatriz(int cantidadDeVertices) {
		this.cantidadDeVertices = cantidadDeVertices;
		this.matrizDeAdyacencia = new int[this.cantidadDeVertices][this.cantidadDeVertices];
		for (int i = 0; i < this.cantidadDeVertices; i++) {
			Arrays.fill(this.matrizDeAdyacencia[i], INFINITO);
		}
	}

	@Override
	public void agregarArista(int origen, int destino, int costo) {
		this.matrizDeAdyacencia[origen][destino] = costo;
	}

	@Override
	public List<Arista> getAristas() {
		List<Arista> aristas = new ArrayList<>();
		for (int i = 0; i < cantidadDeVertices; i++) {
			for (int j = 0; j < cantidadDeVertices; j++) {
				if (matrizDeAdyacencia[i][j] != INFINITO) {
					aristas.add(new Arista(i, j, matrizDeAdyacencia[i][j]));
				}
			}
		}
		return aristas;
	}

	@Override
	public int getCantidadDeVertices() {
		return cantidadDeVertices;
	}

	@Override
	public void imprimirGrafo() {
		for (int i = 0; i < this.cantidadDeVertices; i++) {
			for (int j = 0; j < this.cantidadDeVertices; j++) {
				if (this.matrizDeAdyacencia[i][j] == INFINITO) {
					System.out.print("INF\t");
				} else {
					System.out.print(this.matrizDeAdyacencia[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}

	public int[][] getMatrizDeAdyacencia() {
		return this.matrizDeAdyacencia;
	}

}
