package MST;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.GrafoLista;
import Entidades.Vertice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Kruskal {

	public <T> MST<T> generarMST(Grafo<T> grafo) {
		Grafo<T> mst = new GrafoLista<>(Grafo.NO_ES_DIRIGIDO, Grafo.ES_PONDERADO);
		int costoTotal = 0;

		// Paso 1: Inicializar el grafo MST con los mismos vértices
		for (Vertice<T> vertice : grafo.obtenerVertices()) {
			mst.agregarVertice(vertice);
		}

		// Paso 2: Crear una lista de todas las aristas y ordenarlas por peso
		PriorityQueue<Arista<T>> colaPrioridad = new PriorityQueue<>(grafo.obtenerAristas());

		// Paso 3: Inicializar estructuras de conjuntos disjuntos (Union-Find)
		UnionFind unionFind = new UnionFind(grafo.obtenerCantidadDeVertices());

		// Paso 4: Procesar cada arista en orden creciente de peso
		while (!colaPrioridad.isEmpty()) {
			Arista<T> arista = colaPrioridad.poll();
			int indiceOrigen = grafo.obtenerIndiceDeVertice(arista.getOrigen());
			int indiceDestino = grafo.obtenerIndiceDeVertice(arista.getDestino());

			// Verificar si los vértices están en diferentes componentes
			if (unionFind.find(indiceOrigen) != unionFind.find(indiceDestino)) {

				// Añadir la arista al MST
				mst.agregarArista(arista.getOrigen(), arista.getDestino(), arista.getPeso());
				costoTotal += arista.getPeso();

				// Unir los conjuntos
				unionFind.union(indiceOrigen, indiceDestino);
			}
		}

		return new MST<T>(mst, costoTotal);
	}

	public class UnionFind {

		private int[] padre; // Almacena el padre de cada vertice

		private int[] rango; // Almacena el rango de cada conjunto

		/* Inicializa las estructuras de conjuntos disjuntos. */
		public UnionFind(int cantidadDeVertices) {
			this.padre = new int[cantidadDeVertices];
			this.rango = new int[cantidadDeVertices];
			Arrays.fill(this.rango, 0);
			// Cada vertice es su propio padre inicialmente
			for (int i = 0; i < cantidadDeVertices; i++) {
				this.padre[i] = i;
			}
		}

		/* Une dos conjuntos disjuntos */
		private void union(int indiceVerticeOrigen, int indiceVerticeDestino) {
			int raizVerticeOrigen = find(indiceVerticeOrigen);
			int raizVerticeDestino = find(indiceVerticeDestino);
			if (raizVerticeOrigen != raizVerticeDestino) {
				if (this.rango[raizVerticeOrigen] < this.rango[raizVerticeDestino]) {
					this.padre[raizVerticeOrigen] = raizVerticeDestino;
				} else if (this.rango[raizVerticeOrigen] > this.rango[raizVerticeDestino]) {
					this.padre[raizVerticeDestino] = raizVerticeOrigen;
				} else {
					this.padre[raizVerticeDestino] = raizVerticeOrigen;
					this.rango[raizVerticeOrigen]++;
				}
			}
		}

		/* Encuentra la raíz del conjunto al que pertenece el elemento dado */
		private int find(int indiceVertice) {
			if (this.padre[indiceVertice] != indiceVertice) {
				// Compresión de camino
				this.padre[indiceVertice] = find(this.padre[indiceVertice]);
			}
			return this.padre[indiceVertice];
		}

	}

}
