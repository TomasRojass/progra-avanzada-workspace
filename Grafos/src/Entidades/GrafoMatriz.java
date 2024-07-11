package Entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrafoMatriz<T> implements Grafo<T> {

	private int[][] matrizAdyacencia;

	private List<Vertice<T>> vertices;

	private boolean esDirigido;

	private boolean esPonderado;

	public GrafoMatriz(boolean esDirigido, boolean esPonderado, int numVertices) {
		this.esDirigido = esDirigido;
		this.esPonderado = esPonderado;
		this.matrizAdyacencia = new int[numVertices][numVertices];
		for (int[] fila : this.matrizAdyacencia) {
			Arrays.fill(fila, Arista.INFINITO);
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
		return matrizAdyacencia[indiceOrigen][indiceDestino] != Arista.INFINITO;
	}

	@Override
	public void agregarArista(Vertice<T> origen, Vertice<T> destino, int peso) {
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
			if (matrizAdyacencia[indiceVertice][j] != Arista.INFINITO) {
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

		if (matrizAdyacencia[indiceOrigen][indiceDestino] != Arista.INFINITO) {
			return new Arista<>(origen, destino, matrizAdyacencia[indiceOrigen][indiceDestino], esDirigido);
		}

		return null;
	}

	@Override
	public List<Arista<T>> obtenerAristas() {
		List<Arista<T>> aristas = new ArrayList<>();
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if (matrizAdyacencia[i][j] != Arista.INFINITO) {
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
				if (matrizAdyacencia[i][j] != Arista.INFINITO) {
					sb.append(vertices.get(i)).append(" -> ").append(vertices.get(j)).append(" [peso: ")
							.append(matrizAdyacencia[i][j]).append("], ");
				}
			}
			sb.setLength(sb.length() - 2);
			sb.append("\n");
		}
		return sb.toString();
	}

	private void incrementarGrado(Vertice<T> vertice) {
		vertice.incrementarGrado();
	}

}
