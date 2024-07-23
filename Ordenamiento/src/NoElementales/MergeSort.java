package NoElementales;

import Entidades.Ordenamiento;

public class MergeSort implements Ordenamiento {

	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> void ordenar(T[] vector) {
		if (vector.length > 1) {
			int tamanioSubVectorIzquierdo = vector.length / 2;
			int tamanioSubVectorDerecho = vector.length - tamanioSubVectorIzquierdo;

			T[] subVectorIzquierdo = (T[]) new Comparable[tamanioSubVectorIzquierdo];
			T[] subVectorDerecho = (T[]) new Comparable[tamanioSubVectorDerecho];

			System.arraycopy(vector, 0, subVectorIzquierdo, 0, tamanioSubVectorIzquierdo);
			System.arraycopy(vector, tamanioSubVectorIzquierdo, subVectorDerecho, 0, tamanioSubVectorDerecho);

			// Ordenar los subvectores recursivamente
			ordenar(subVectorIzquierdo);
			ordenar(subVectorDerecho);

			// Combinar los subvectores ordenados
			merge(vector, subVectorIzquierdo, subVectorDerecho);
		}
	}

	public void ordenar(int[] array) {
		int mitad;
		int i = 0, j = 0, k = 0;
		if (array.length > 1) {
			mitad = array.length / 2;
			int[] mitadIzquierda = new int[mitad];
			int[] mitadDerecha = new int[array.length - mitad];
			System.arraycopy(array, 0, mitadIzquierda, 0, mitad);
			System.arraycopy(array, mitad, mitadDerecha, 0, array.length - mitad);

			ordenar(mitadIzquierda);
			ordenar(mitadDerecha);

			while (i < mitadIzquierda.length && j < mitadDerecha.length) {
				if (mitadIzquierda[i] < mitadDerecha[j]) {
					array[k] = mitadIzquierda[i];
					i++;
				} else {
					array[k] = mitadDerecha[j];
					j++;
				}
				k++;
			}

			while (i < mitadIzquierda.length) {
				array[k] = mitadIzquierda[i];
				i++;
				k++;
			}

			while (j < mitadDerecha.length) {
				array[k] = mitadDerecha[j];
				j++;
				k++;
			}

		}
	}

	private <T extends Comparable<T>> void merge(T[] vector, T[] subVectorIzquierdo, T[] subVectorDerecho) {
		int indiceSubVectorIzquierdo = 0;
		int indiceSubVectorDerecho = 0;
		int indiceVector = 0;

		// Combinar los subvectores ordenados en el vector original
		while (indiceSubVectorIzquierdo < subVectorIzquierdo.length
				&& indiceSubVectorDerecho < subVectorDerecho.length) {
			if (subVectorIzquierdo[indiceSubVectorIzquierdo].compareTo(subVectorDerecho[indiceSubVectorDerecho]) <= 0) {
				vector[indiceVector++] = subVectorIzquierdo[indiceSubVectorIzquierdo++];
			} else {
				vector[indiceVector++] = subVectorDerecho[indiceSubVectorDerecho++];
			}
		}

		// Copiar los elementos restantes del subvector izquierdo (si hay)
		while (indiceSubVectorIzquierdo < subVectorIzquierdo.length) {
			vector[indiceVector++] = subVectorIzquierdo[indiceSubVectorIzquierdo++];
		}

		// Copiar los elementos restantes del subvector derecho (si hay)
		while (indiceSubVectorDerecho < subVectorDerecho.length) {
			vector[indiceVector++] = subVectorDerecho[indiceSubVectorDerecho++];
		}
	}

}
