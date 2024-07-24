package Busqueda;

public class BusquedaSecuencial implements Busqueda {

	@Override
	public <T extends Comparable<T>> int buscar(T[] vector, T elemento) {
		int posicion = 0;
		while (posicion < vector.length && vector[posicion].compareTo(elemento) != 0) {
			posicion++;
		}
		if (posicion < vector.length) {
			return posicion;
		}
		return ELEMENTO_NO_ENCONTRADO;
	}

}
