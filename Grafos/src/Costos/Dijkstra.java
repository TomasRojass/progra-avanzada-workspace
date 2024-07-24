package Costos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.Vertice;
import Excepciones.VerticeInvalidoException;

public class Dijkstra<T> {

	private Map<Vertice<T>, Double> distancias;

	private Map<Vertice<T>, Vertice<T>> predecesores;

	public Dijkstra() {
		this.distancias = new HashMap<>();
		this.predecesores = new HashMap<>();
	}

	public void aplicarAlgoritmo(Grafo<T> grafo, Vertice<T> verticeOrigen) throws VerticeInvalidoException {

		if (!grafo.contieneVertice(verticeOrigen)) {
			throw new VerticeInvalidoException("El vértice " + verticeOrigen.getValor() + " no pertenece al grafo.");
		}

		PriorityQueue<Vertice<T>> colaDePrioridad = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));

		// Inicialización
		for (Vertice<T> vertice : grafo.obtenerVertices()) {
			distancias.put(vertice, vertice.equals(verticeOrigen) ? 0.0 : Double.POSITIVE_INFINITY);
			predecesores.put(vertice, null);
			colaDePrioridad.add(vertice);
		}

		while (!colaDePrioridad.isEmpty()) {
			Vertice<T> verticeActual = colaDePrioridad.poll();

			for (Arista<T> arista : grafo.obtenerAristasDeVertice(verticeActual)) {

				Vertice<T> verticeAdyacente = arista.getDestino();
				double peso = arista.getPeso();

				double nuevaDistancia = distancias.get(verticeActual) + peso;

				if (nuevaDistancia < distancias.get(verticeAdyacente)) {
					colaDePrioridad.remove(verticeAdyacente);
					distancias.put(verticeAdyacente, nuevaDistancia);
					predecesores.put(verticeAdyacente, verticeActual);
					colaDePrioridad.add(verticeAdyacente);
				}
			}
		}

		// Para depuración, imprimir los resultados
		// System.out.println("Distancias desde " + verticeOrigen + ":");
		// imprimirDistancias();
		// System.out.println("Predecesores:");
		// imprimirPredecesores();

	}

	public void imprimirDistancias() {
		for (Map.Entry<Vertice<T>, Double> entry : distancias.entrySet()) {
			System.out.println("Hasta " + entry.getKey() + ": " + entry.getValue());
		}

	}

	public void imprimirPredecesores() {
		for (Map.Entry<Vertice<T>, Vertice<T>> entry : predecesores.entrySet()) {
			System.out.println("Vertice " + entry.getKey() + ", predecesor: " + entry.getValue());
		}
	}

	public List<Vertice<T>> encontrarCaminoMinimo(Grafo<T> grafo, Vertice<T> verticeOrigen, Vertice<T> verticeDestino)
			throws VerticeInvalidoException {
		if (!grafo.contieneVertice(verticeOrigen) || !grafo.contieneVertice(verticeDestino)) {
			throw new VerticeInvalidoException("Uno o ambos vértices no pertenecen al grafo.");
		}

		// Ejecutar el algoritmo de Dijkstra desde el vértice de origen
		aplicarAlgoritmo(grafo, verticeOrigen);

		List<Vertice<T>> camino = new ArrayList<>();
		for (Vertice<T> vertice = verticeDestino; vertice != null; vertice = predecesores.get(vertice)) {
			camino.add(vertice);
		}
		Collections.reverse(camino);

		return camino.get(0).equals(verticeOrigen) ? camino : Collections.emptyList();
	}

	public double obtenerCostoCamino(Grafo<T> grafo, Vertice<T> verticeOrigen, Vertice<T> verticeDestino)
			throws VerticeInvalidoException {
		if (!grafo.contieneVertice(verticeOrigen) || !grafo.contieneVertice(verticeDestino)) {
			throw new VerticeInvalidoException("Uno o ambos vértices no pertenecen al grafo.");
		}

		// Ejecutar el algoritmo de Dijkstra desde el vértice de origen
		aplicarAlgoritmo(grafo, verticeOrigen);

		return distancias.getOrDefault(verticeDestino, Double.POSITIVE_INFINITY);
	}

	public Map<Vertice<T>, Double> getDistancias() {
		return distancias;
	}

	public Map<Vertice<T>, Vertice<T>> getPredecesores() {
		return predecesores;
	}

}
