package Entidades;

import java.util.List;

public interface Grafo {

	public static final int INFINITO = Integer.MAX_VALUE;
	public static final int SIN_COSTO = 0;

	public abstract void agregarArista(int origen, int destino, int costo);

	List<Arista> getAristas();

	public int getCantidadDeVertices();

	public void imprimirGrafo();

}
