package Entidades;

public class Arista<T> implements Comparable<Arista<T>> {

	public static final int INFINITO = Integer.MAX_VALUE;

	public static final int SIN_COSTO = 0;

	private Vertice<T> origen;

	private Vertice<T> destino;

	private int peso;

	private boolean esDirigida;

	public Arista(Vertice<T> origen, Vertice<T> destino, int peso, boolean esDirigida) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
		this.esDirigida = esDirigida;
	}

	public Vertice<T> getOrigen() {
		return origen;
	}

	public Vertice<T> getDestino() {
		return destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public boolean esDirigida() {
		return esDirigida;
	}

	@Override
	public String toString() {
		return origen + " -> " + destino + (esDirigida ? " (dirigida)" : "") + " [peso: " + peso + "]";
	}

	@Override
	public int compareTo(Arista<T> otraArista) {
		return Integer.compare(this.peso, otraArista.peso);
	}

}
