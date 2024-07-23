package NoElementales;

public class TimSort {

	public void ordenar(int v[], int linz, int lder) {

		if (lder - linz > 3) {
			int mitad = linz + (lder - linz) / 2;
			ordenar(v, linz, mitad);
			ordenar(v, mitad + 1, lder);
		}

		if (v.length == lder - 1) {
			int i = 0, j = 0, k = 0;
			int mitad = v.length / 2;
			int[] mitadIzquierda = new int[mitad];
			int[] mitadDerecha = new int[v.length - mitad];
			System.arraycopy(v, 0, mitadIzquierda, 0, mitad);
			System.arraycopy(v, mitad, mitadDerecha, 0, v.length - mitad);

			while (i < mitadIzquierda.length && j < mitadDerecha.length) {

				if (mitadIzquierda[i] < mitadDerecha[j]) {
					v[k] = mitadIzquierda[i];
					i++;
				} else {
					v[k] = mitadDerecha[j];
					j++;
				}
				k++;
			}

			while (i < mitadIzquierda.length) {
				v[k] = mitadIzquierda[i];
				i++;
				k++;
			}

			while (j < mitadDerecha.length) {
				v[k] = mitadDerecha[j];
				j++;
				k++;
			}

		} else {
			int llave;
			for (int i = linz; i <= lder; i++) {
				llave = v[i];
				int j = i - 1;
				while (j >= 0 && j >= linz && v[j] > llave) {
					v[j + 1] = v[j];
					v[j] = llave;
					j--;
				}
			}
		}
	}

}
