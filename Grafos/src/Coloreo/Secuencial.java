package Coloreo;

import java.util.HashSet;
import java.util.Set;
import Entidades.Arista;
import Entidades.Grafo;
import Entidades.Vertice;

public class Secuencial {

	public <T> Coloreo<T> colorearGrafo(Grafo<T> grafo) {

		Coloreo<T> resultadoColoreo = new Coloreo<>();

		// Paso 1: Iterar sobre todos los vértices del grafo
		for (Vertice<T> vertice : grafo.obtenerVertices()) {
			Set<Color> coloresVecinos = new HashSet<>();

			// Paso 2: Recoger los colores de los vértices adyacentes
			for (Arista<T> arista : grafo.obtenerAristasDeVertice(vertice)) {
				Vertice<T> verticeAdyacente = arista.getDestino();
				Color colorAdyacente = resultadoColoreo.obtenerColor(verticeAdyacente);

				if (colorAdyacente != null) {
					coloresVecinos.add(colorAdyacente);
				}
			}

			// Paso 3: Encontrar el primer color disponible que no esté en coloresVecinos
			for (Color color : Color.values()) {
				if (!coloresVecinos.contains(color)) {
					resultadoColoreo.asignarColor(vertice, color);
					break;
				}
			}
		}

		return resultadoColoreo;
	}

}
