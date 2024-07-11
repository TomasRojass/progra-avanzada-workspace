package MST;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.GrafoLista;
import Entidades.Vertice;

public class Prim {

	public <T> MST<T> generarMST(Vertice<T> verticeOrigen, Grafo<T> grafo) {

		if (!grafo.contieneVertice(verticeOrigen)) {
			return null;
		}

		Grafo<T> mst = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.ES_PONDERADO);
		int costoTotal = 0;

		// Conjunto para mantener los vértices ya agregados al MST
		Set<Vertice<T>> verticesIncluidos = new HashSet<>();
		verticesIncluidos.add(verticeOrigen);

		// Cola de prioridad para manejar las aristas
		PriorityQueue<Arista<T>> colaDePrioridad = new PriorityQueue<>();
		colaDePrioridad.addAll(grafo.obtenerAristasDeVertice(verticeOrigen));

		while (!colaDePrioridad.isEmpty()) {
			Arista<T> aristaDeMenorCosto = colaDePrioridad.poll();

			Vertice<T> origen = aristaDeMenorCosto.getOrigen();
			Vertice<T> destino = aristaDeMenorCosto.getDestino();

			// Verificar si el vértice de destino ya está en el MST para evitar ciclos
			if (verticesIncluidos.contains(destino)) {
				continue;
			}

			// Agregar el vértice y la arista al MST
			mst.agregarVertice(origen);
			mst.agregarVertice(destino);
			mst.agregarArista(origen, destino, aristaDeMenorCosto.getPeso());

			// Actualizar el costo total del MST
			costoTotal += aristaDeMenorCosto.getPeso();

			// Marcar el vértice de destino como incluido en el MST
			verticesIncluidos.add(destino);

			// Agregar las aristas del vértice de destino a la cola de prioridad
			colaDePrioridad.addAll(grafo.obtenerAristasDeVertice(aristaDeMenorCosto.getDestino()));
		}

		return new MST<T>(mst, costoTotal);
	}

}
