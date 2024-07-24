package Coloreo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import Entidades.Arista;
import Entidades.Grafo;
import Entidades.Vertice;

public class Matula {

	public <T> Coloreo<T> colorearGrafo(Grafo<T> grafo) {
		Coloreo<T> resultadoColoreo = new Coloreo<>();

		// Ordenar los vértices por grado en orden ascendente
		List<Vertice<T>> verticesOrdenados = new ArrayList<>(grafo.obtenerVertices());
		verticesOrdenados.sort(Comparator.comparingInt(Vertice<T>::getGrado));

		// Array para marcar los colores usados por los vecinos
		boolean[] coloresUsados = new boolean[Color.values().length];

		// Asignar colores a los vértices
		for (Vertice<T> vertice : verticesOrdenados) {
			// Reiniciar el array de colores usados
			Arrays.fill(coloresUsados, false);

			// Marcar los colores usados por los vértices adyacentes
			for (Arista<T> arista : grafo.obtenerAristasDeVertice(vertice)) {
				Color colorAdyacente = resultadoColoreo.obtenerColor(arista.getDestino());
				if (colorAdyacente != null) {
					coloresUsados[colorAdyacente.ordinal()] = true;
				}
			}

			// Encontrar el primer color no usado
			for (Color color : Color.values()) {
				if (!coloresUsados[color.ordinal()]) {
					resultadoColoreo.asignarColor(vertice, color);
					break;
				}
			}
		}

		return resultadoColoreo;
	}

	@SuppressWarnings("unused")
	private <T> void imprimirListaDeVertices(List<Vertice<T>> vertices) {
		for (Vertice<T> vertice : vertices) {
			System.out.println("Vertice: " + vertice.getValor() + "\tGrado: " + vertice.getGrado());
		}
	}

}
