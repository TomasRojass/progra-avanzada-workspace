package Busqueda;

public class BusquedaBinaria implements Busqueda {

	@Override
	public <T extends Comparable<T>> int buscar(T[] vector, T elemento) {
		return buscar(vector, elemento, 0, vector.length - 1);
	}

	// Privados

	private <T extends Comparable<T>> int buscar(T[] vector, T elemento, int limiteInferior, int limiteSuperior) {
		if (limiteSuperior < limiteInferior) {
			return ELEMENTO_NO_ENCONTRADO;
		}
		int actual = (limiteInferior + limiteSuperior) / 2;
		if (vector[actual].compareTo(elemento) == 0) {
			return actual;
		}
		return vector[actual].compareTo(elemento) > 0 ? buscar(vector, elemento, limiteInferior, actual - 1)
				: buscar(vector, elemento, actual + 1, limiteSuperior);
	}

}
