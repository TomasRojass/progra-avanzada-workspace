package Entidades;

public class Arista<T> implements Comparable<Arista<T>> {

	public static final double INFINITO_DOUBLE = Double.POSITIVE_INFINITY;

	public static final int INFINITO_INTEGER = Integer.MAX_VALUE;

	public static final double SIN_COSTO = 0.0;

	private Vertice<T> origen;

	private Vertice<T> destino;

	private double peso;

	private boolean esDirigida;

	public Arista(Vertice<T> origen, Vertice<T> destino, double peso, boolean esDirigida) {
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

	public double getPeso() {
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
		return "(" + origen + (esDirigida ? " -> " : ", ") + destino + ", " + peso + ")";
	}

	@Override
	public int compareTo(Arista<T> otraArista) {
		return Double.compare(this.peso, otraArista.peso);
	}

}
