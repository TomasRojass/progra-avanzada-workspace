package Entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoLista<T> implements Grafo<T> {

	private Map<Vertice<T>, List<Arista<T>>> listaAdyacencia;

	private boolean esDirigido;

	private boolean esPonderado;

	public GrafoLista(boolean esDirigido, boolean esPonderado) {
		this.esDirigido = esDirigido;
		this.esPonderado = esPonderado;
		this.listaAdyacencia = new HashMap<>();
	}

	@Override
	public void agregarVertice(Vertice<T> vertice) {
		listaAdyacencia.putIfAbsent(vertice, new ArrayList<>());
	}

	@Override
	public int obtenerCantidadDeVertices() {
		return listaAdyacencia.size();
	}

	@Override
	public int obtenerIndiceDeVertice(Vertice<T> vertice) {
		int indice = 0;
		for (Vertice<T> v : listaAdyacencia.keySet()) {
			if (v.equals(vertice)) {
				return indice;
			}
			indice++;
		}
		return -1;
	}

	@Override
	public List<Vertice<T>> obtenerVertices() {
		return new ArrayList<>(listaAdyacencia.keySet());
	}

	@Override
	public boolean contieneArista(Vertice<T> origen, Vertice<T> destino) {
		if (!listaAdyacencia.containsKey(origen) || !listaAdyacencia.containsKey(destino)) {
			return false;
		}
		for (Arista<T> arista : listaAdyacencia.get(origen)) {
			if (arista.getDestino().equals(destino)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void agregarArista(Vertice<T> origen, Vertice<T> destino, double peso) {
		if (!listaAdyacencia.containsKey(origen) || !listaAdyacencia.containsKey(destino)) {
			throw new IllegalArgumentException("El vértice no existe en el grafo");
		}

		Arista<T> arista = new Arista<>(origen, destino, peso, esDirigido);
		listaAdyacencia.get(origen).add(arista);

		if (!esDirigido) {
			listaAdyacencia.get(destino).add(new Arista<>(destino, origen, peso, false));
		}

		incrementarGrado(origen);
		incrementarGrado(destino);
	}

	@Override
	public void agregarArista(Vertice<T> origen, Vertice<T> destino) {
		if (!listaAdyacencia.containsKey(origen) || !listaAdyacencia.containsKey(destino)) {
			throw new IllegalArgumentException("El vértice no existe en el grafo");
		}

		listaAdyacencia.get(origen).add(new Arista<>(origen, destino, Arista.SIN_COSTO, esDirigido));

		if (!esDirigido) {
			listaAdyacencia.get(destino).add(new Arista<>(destino, origen, Arista.SIN_COSTO, false));
		}

		incrementarGrado(origen);
		incrementarGrado(destino);
	}

	@Override
	public List<Arista<T>> obtenerAristasDeVertice(Vertice<T> vertice) {
		return listaAdyacencia.getOrDefault(vertice, new ArrayList<>());
	}

	@Override
	public Arista<T> obtenerArista(Vertice<T> origen, Vertice<T> destino) {
		if (!contieneVertice(origen) || !contieneVertice(destino)) {
			return null;
		}
		for (Arista<T> arista : listaAdyacencia.get(origen)) {
			if (arista.getDestino().equals(destino)) {
				return arista;
			}
		}
		return null;
	}

	@Override
	public List<Arista<T>> obtenerAristas() {
		List<Arista<T>> aristas = new ArrayList<>();
		for (List<Arista<T>> lista : listaAdyacencia.values()) {
			aristas.addAll(lista);
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
		for (Vertice<T> vertice : listaAdyacencia.keySet()) {
			sb.append(vertice).append(": ");
			for (Arista<T> arista : listaAdyacencia.get(vertice)) {
				sb.append(arista).append(", ");
			}
			sb.setLength(sb.length() - 2);
			sb.append("\n");
		}
		return sb.toString();
	}

	private void incrementarGrado(Vertice<T> vertice) {
		vertice.incrementarGrado();
	}

	@Override
	public double[][] getMatrizAdyacencia() {
		int cantidadDeVertices = this.obtenerCantidadDeVertices();
		double[][] matrizAdyacencia = new double[cantidadDeVertices][cantidadDeVertices];

		List<Vertice<T>> vertices = this.obtenerVertices();

		for (int i = 0; i < cantidadDeVertices; i++) {
			for (int j = 0; j < cantidadDeVertices; j++) {
				matrizAdyacencia[i][j] = Arista.INFINITO_DOUBLE;
			}
		}

		for (int i = 0; i < cantidadDeVertices; i++) {
			Vertice<T> vertice = vertices.get(i);
			List<Arista<T>> aristas = this.obtenerAristasDeVertice(vertice);
			for (Arista<T> arista : aristas) {
				int j = vertices.indexOf(arista.getDestino());
				matrizAdyacencia[i][j] = arista.getPeso();
			}
		}

		return matrizAdyacencia;
	}

}
