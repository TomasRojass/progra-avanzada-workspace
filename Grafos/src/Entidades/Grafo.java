package Entidades;

import java.util.List;

public interface Grafo {

	public abstract void agregarArista(int origen, int destino, int costo);

	List<Arista> getAristas();

	public int getCantidadDeVertices();

	public void imprimirGrafo();

}
