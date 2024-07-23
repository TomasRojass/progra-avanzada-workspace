package NoElementales;

import java.util.ArrayList;
import java.util.Stack;

import Entidades.Ordenamiento;

public class ShellSort implements Ordenamiento {

	private Stack<Integer> pilaDePasos;

	public ShellSort() {
		pilaDePasos = new Stack<Integer>();
	}

	// Publicos

	@Override
	public <T extends Comparable<T>> void ordenar(T[] vector) {
		armarPilaDePasos(pilaDePasos, vector.length);
		while (!pilaDePasos.isEmpty()) {
			int distancia = pilaDePasos.pop();
			for (int indiceActual = distancia; indiceActual < vector.length; indiceActual++) {
				T auxiliar = vector[indiceActual];
				int indiceDesplazamiento;
				for (indiceDesplazamiento = indiceActual; indiceDesplazamiento >= distancia
						&& vector[indiceDesplazamiento - distancia]
								.compareTo(auxiliar) > 0; indiceDesplazamiento -= distancia) {
					vector[indiceDesplazamiento] = vector[indiceDesplazamiento - distancia];
				}
				vector[indiceDesplazamiento] = auxiliar;
			}
		}
	}

	@Override
	public void ordenar(int[] lista) {
		Integer[] vectorDeDistancias = this.generoVectorDeDistancias(lista.length);
		int aux;
		for (int i = vectorDeDistancias.length - 1; i >= 0; i--) {
			int distancia = vectorDeDistancias[i];
			int limiteIzq = 0;
			int posicionAOrdenar;
			while (limiteIzq + distancia < lista.length) {
				posicionAOrdenar = limiteIzq + distancia;
				aux = lista[posicionAOrdenar];
				while (posicionAOrdenar - distancia >= 0 && aux < lista[posicionAOrdenar - distancia]) {
					lista[posicionAOrdenar] = lista[posicionAOrdenar - distancia];
					posicionAOrdenar -= distancia;
				}
				lista[posicionAOrdenar] = aux;
				limiteIzq++;
			}
		}
	}

	// Privados

	private void armarPilaDePasos(Stack<Integer> pilaDePasos, int tamanioVector) {
		int numeroSerie = 1;
		while (numeroSerie < tamanioVector) {
			pilaDePasos.push(numeroSerie);
			numeroSerie = numeroSerie * 3 + 1;
		}
	}

	private Integer[] generoVectorDeDistancias(int n) {
		ArrayList<Integer> lista = new ArrayList<>();
		for (int i = 1; i <= n; i = i * 3 + 1) {
			lista.add(i);
		}
		Integer[] retorno = lista.toArray(new Integer[0]);

		return retorno;
	}
}
