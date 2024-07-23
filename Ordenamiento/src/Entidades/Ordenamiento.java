package Entidades;

public interface Ordenamiento {

	public <T extends Comparable<T>> void ordenar(T[] vector);

	public void ordenar(int[] vector);

}
