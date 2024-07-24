package Dijkstra;

public class Nodo implements Comparable<Nodo> {

	private int id;

	private double peso;

	public Nodo(int id, double peso) {
		this.id = id;
		this.peso = peso;
	}

	@Override
	public int compareTo(Nodo otroNodo) {
		return this.id - otroNodo.id;
	}

	@Override
	public String toString() {
		return "(" + this.id + ", " + this.peso + ")";
	}

	public double getPeso() {
		return this.peso;
	}

	public int getId() {
		return this.id;
	}
}
