package ProblemaMochila;

public class Item {
	
	private int peso;
	
	private double precio;

	public Item(int peso, double precio) {
		this.peso = peso;
		this.precio = precio;
	}

	public int getPeso() {
		return peso;
	}

	public double getPrecio() {
		return precio;
	}

}
