package Entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrafoMatriz<T> implements Grafo<T> {

	private double[][] matrizAdyacencia;

	private List<Vertice<T>> vertices;

	private boolean esDirigido;

	private boolean esPonderado;

	public GrafoMatriz(boolean esDirigido, boolean esPonderado, int numVertices) {
		this.esDirigido = esDirigido;
		this.esPonderado = esPonderado;
		this.matrizAdyacencia = new double[numVertices][numVertices];
		for (double[] fila : this.matrizAdyacencia) {
			Arrays.fill(fila, Arista.INFINITO_DOUBLE);
		}
		vertices = new ArrayList<>();
	}

	@Override
	public void agregarVertice(Vertice<T> vertice) {
		vertices.add(vertice);
	}

	@Override
	public int obtenerCantidadDeVertices() {
		return vertices.size();
	}

	@Override
	public int obtenerIndiceDeVertice(Vertice<T> vertice) {
		return vertices.indexOf(vertice);
	}

	@Override
	public List<Vertice<T>> obtenerVertices() {
		return new ArrayList<>(vertices);
	}

	@Override
	public boolean contieneArista(Vertice<T> origen, Vertice<T> destino) {
		int indiceOrigen = vertices.indexOf(origen);
		int indiceDestino = vertices.indexOf(destino);
		if (indiceOrigen == -1 || indiceDestino == -1) {
			return false;
		}
		return matrizAdyacencia[indiceOrigen][indiceDestino] != Arista.INFINITO_DOUBLE;
	}

	@Override
	public void agregarArista(Vertice<T> origen, Vertice<T> destino, double peso) {
		int indiceOrigen = vertices.indexOf(origen);
		int indiceDestino = vertices.indexOf(destino);
		if (indiceOrigen == -1 || indiceDestino == -1) {
			throw new IllegalArgumentException("El vértice no existe en el grafo");
		}

		matrizAdyacencia[indiceOrigen][indiceDestino] = peso;

		if (!esDirigido) {
			matrizAdyacencia[indiceDestino][indiceOrigen] = peso;
		}

		incrementarGrado(origen);
		incrementarGrado(destino);
	}

	@Override
	public void agregarArista(Vertice<T> origen, Vertice<T> destino) {
		agregarArista(origen, destino, Arista.SIN_COSTO);
	}

	@Override
	public List<Arista<T>> obtenerAristasDeVertice(Vertice<T> vertice) {
		int indiceVertice = vertices.indexOf(vertice);
		if (indiceVertice == -1) {
			return new ArrayList<>();
		}
		List<Arista<T>> aristas = new ArrayList<>();
		for (int j = 0; j < matrizAdyacencia.length; j++) {
			if (matrizAdyacencia[indiceVertice][j] != Arista.INFINITO_DOUBLE) {
				aristas.add(new Arista<>(vertice, vertices.get(j), matrizAdyacencia[indiceVertice][j], esDirigido));
			}
		}
		return aristas;
	}

	@Override
	public Arista<T> obtenerArista(Vertice<T> origen, Vertice<T> destino) {
		int indiceOrigen = vertices.indexOf(origen);
		int indiceDestino = vertices.indexOf(destino);

		if (indiceOrigen == -1 || indiceDestino == -1) {
			return null;
		}

		if (matrizAdyacencia[indiceOrigen][indiceDestino] != Arista.INFINITO_DOUBLE) {
			return new Arista<>(origen, destino, matrizAdyacencia[indiceOrigen][indiceDestino], esDirigido);
		}

		return null;
	}

	@Override
	public List<Arista<T>> obtenerAristas() {
		List<Arista<T>> aristas = new ArrayList<>();
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if (matrizAdyacencia[i][j] != Arista.INFINITO_DOUBLE) {
					aristas.add(new Arista<>(vertices.get(i), vertices.get(j), matrizAdyacencia[i][j], esDirigido));
				}
			}
		}
		return aristas;
	}

	@Override
	public boolean esDirigido() {
		return esDirigido;
	}

	@Override
	public boolean esPonderado() {
		return esPonderado;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vertices.size(); i++) {
			sb.append(vertices.get(i)).append(": ");
			for (int j = 0; j < matrizAdyacencia.length; j++) {
				if (matrizAdyacencia[i][j] != Arista.INFINITO_DOUBLE) {
					sb.append(vertices.get(i)).append(" -> ").append(vertices.get(j)).append(" [peso: ")
							.append(matrizAdyacencia[i][j]).append("], ");
				}
			}
			sb.setLength(sb.length() - 2);
			sb.append("\n");
		}
		return sb.toString();
	}

	public void mostrarMatrizAdyacencia() {
		int filas = this.matrizAdyacencia.length;
		int columnas = this.matrizAdyacencia[0].length;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(
						(this.matrizAdyacencia[i][j] == Arista.INFINITO_DOUBLE ? "INF" : this.matrizAdyacencia[i][j])
								+ (j < columnas - 1 ? "\t" : "\n"));
			}
		}
	}

	@Override
	public double[][] getMatrizAdyacencia() {
		return this.matrizAdyacencia;
	}

	private void incrementarGrado(Vertice<T> vertice) {
		vertice.incrementarGrado();
	}

}
