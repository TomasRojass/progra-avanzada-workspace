package Elementales;

import Entidades.Ordenamiento;
import Entidades.Vector;

public class Seleccion implements Ordenamiento {

	@Override
	public <T extends Comparable<T>> void ordenar(T[] vector) {
		if (vector == null || vector.length == 0) {
			return;
		}
		int cantidadDeElementos = vector.length;
		for (int i = 0; i < cantidadDeElementos - 1; i++) {
			int indiceMenor = i;
			for (int j = i + 1; j < cantidadDeElementos; j++) {
				if (vector[j].compareTo(vector[indiceMenor]) < 0) {
					indiceMenor = j;
				}
			}
			if (indiceMenor != i) {
				Vector.intercambiar(vector, i, indiceMenor);
			}
		}
	}

	public void ordenar(int[] datos) {
		int n = datos.length;
		for (int i = 0; i < (n - 1); i++) {
			int menor = i;
			for (int j = i + 1; j < n; j++) {
				if (datos[j] < datos[menor])
					menor = j;
			}
			int swap = datos[i];
			datos[i] = datos[menor];
			datos[menor] = swap;
		}
	}

}
