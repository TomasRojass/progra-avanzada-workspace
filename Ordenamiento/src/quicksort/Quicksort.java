package quicksort;

public interface Quicksort<T extends Comparable<T> > {
	public T[] ordenar(T[] lista);
}
