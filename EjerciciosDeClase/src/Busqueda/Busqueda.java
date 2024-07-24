package Busqueda;

public interface Busqueda {

	final int ELEMENTO_NO_ENCONTRADO = -1;

	public <T extends Comparable<T>> int buscar(T[] vector, T elemento);

}
