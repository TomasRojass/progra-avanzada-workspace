package Entidades;

import java.util.List;

public interface Grafo<T> {

	public static final boolean ES_DIRIGIDO = true;

	public static final boolean NO_ES_DIRIGIDO = false;

	public static final boolean ES_PONDERADO = true;

	public static final boolean NO_ES_PONDERADO = false;

	void agregarVertice(Vertice<T> vertice);

	int obtenerCantidadDeVertices();

	int obtenerIndiceDeVertice(Vertice<T> vertice);

	List<Vertice<T>> obtenerVertices();

	public default boolean contieneVertice(Vertice<T> vertice) {
		for (Vertice<T> v : obtenerVertices()) {
			if (v.equals(vertice)) {
				return true;
			}
		}
		return false;
	}

	boolean contieneArista(Vertice<T> origen, Vertice<T> destino);

	void agregarArista(Vertice<T> origen, Vertice<T> destino, int peso);

	void agregarArista(Vertice<T> origen, Vertice<T> destino);

	List<Arista<T>> obtenerAristasDeVertice(Vertice<T> vertice);

	Arista<T> obtenerArista(Vertice<T> origen, Vertice<T> destino);

	List<Arista<T>> obtenerAristas();

	boolean esDirigido();

	boolean esPonderado();

}
