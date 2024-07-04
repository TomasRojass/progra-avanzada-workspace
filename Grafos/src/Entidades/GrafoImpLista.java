package Entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrafoImpLista implements Grafo {

	List<Arista> listaDeAdyacencia;
	Set<Integer> vertices;

	public GrafoImpLista() {
		listaDeAdyacencia = new ArrayList<>();
		vertices = new HashSet<>();
	}

	@Override
	public void agregarArista(int origen, int destino, int costo) {
		listaDeAdyacencia.add(new Arista(origen, destino, costo));
		vertices.add(origen);
		vertices.add(destino);
	}

	@Override
	public List<Arista> getAristas() {
		return new ArrayList<>(listaDeAdyacencia);
	}

	@Override
	public int getCantidadDeVertices() {
		return vertices.size();
	}

	@Override
	public void imprimirGrafo() {
		for (Arista arista : listaDeAdyacencia) {
			System.out.println("Origen: " + arista.getOrigen() + "\tDestino: " + arista.getDestino() + "\tCosto: "
					+ arista.getCosto());
		}
	}

}
