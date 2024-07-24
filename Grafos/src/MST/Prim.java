package MST;

import java.util.List;
import java.util.PriorityQueue;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.GrafoLista;
import Entidades.Vertice;
import Excepciones.VerticeInvalidoException;

public class Prim {

	public <T> MST<T> generarMST(Vertice<T> verticeOrigen, Grafo<T> grafo) throws VerticeInvalidoException {

		// Verificar si el vértice de origen pertenece al grafo
		if (!grafo.contieneVertice(verticeOrigen)) {
			throw new VerticeInvalidoException("El vertice " + verticeOrigen.getValor() + " no pertenece al grafo.");
		}

		Grafo<T> mst = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.ES_PONDERADO);
		int costoTotal = 0;

		// Cola de prioridad para manejar las aristas, agrego todas las aristas
		// adyacentes al primer vertice
		PriorityQueue<Arista<T>> colaDePrioridad = new PriorityQueue<>();
		colaDePrioridad.addAll(grafo.obtenerAristasDeVertice(verticeOrigen));

		while (!colaDePrioridad.isEmpty()) {

			Arista<T> aristaDeMenorCosto = colaDePrioridad.poll();
			Vertice<T> posibleVertice = aristaDeMenorCosto.getDestino();

			// Verificar si el vértice de destino ya está en el MST para evitar ciclos
			if (!mst.contieneVertice(posibleVertice)) {

				Vertice<T> origen = aristaDeMenorCosto.getOrigen();
				Vertice<T> destino = posibleVertice;

				// Agregar el vértice y la arista al MST
				mst.agregarVertice(origen);
				mst.agregarVertice(destino);
				mst.agregarArista(origen, destino, aristaDeMenorCosto.getPeso());

				// Actualizar el costo total del MST
				costoTotal += aristaDeMenorCosto.getPeso();

				// Agregar las aristas del vértice de destino a la cola de prioridad
				List<Arista<T>> aristasAdyacentes = grafo.obtenerAristasDeVertice(destino);
				for (Arista<T> arista : aristasAdyacentes) {
					if (!mst.contieneVertice(arista.getDestino())) {
						colaDePrioridad.add(arista);
					}
				}
			}
		}

		return new MST<T>(mst, costoTotal);
	}

}
