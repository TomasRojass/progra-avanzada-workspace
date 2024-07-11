package MST;

import Entidades.Grafo;

public class MST<T> {

	private Grafo<T> arbol;

	private int costoTotal;

	public MST(Grafo<T> arbol, int costoTotal) {
		this.arbol = arbol;
		this.costoTotal = costoTotal;
	}

	public Grafo<T> getArbol() {
		return arbol;
	}

	public int getCostoTotal() {
		return costoTotal;
	}

}
