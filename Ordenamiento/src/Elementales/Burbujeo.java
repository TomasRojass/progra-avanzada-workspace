package Elementales;

import Entidades.Ordenamiento;
import Entidades.Vector;

public class Burbujeo implements Ordenamiento {

	@Override
	public <T extends Comparable<T>> void ordenar(T[] vector) {
		boolean huboCambio = false;
		do {
			huboCambio = false;
			for (int i = 0; i < vector.length - 1; i++) {
				if (vector[i].compareTo(vector[i + 1]) > 0) {
					Vector.intercambiar(vector, i, i + 1);
					huboCambio = true;
				}
			}
		} while (huboCambio);
	}

	public void ordenar(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			for (int j = i + 1; j < vector.length; j++) {
				if (vector[i] > vector[j]) {
					int aux = vector[j];
					vector[j] = vector[i];
					vector[i] = aux;
				}
			}
		}
	}

}
