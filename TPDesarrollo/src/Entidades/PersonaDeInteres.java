package Entidades;

public abstract class PersonaDeInteres implements Comparable<PersonaDeInteres> {

	private int cantidad;
	private int precio;
	private int indice;

	public PersonaDeInteres(int precio, boolean esFabricante, int cantidad, int indice) {
		this.cantidad = cantidad;
		this.precio = precio;
		this.indice = indice;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public int getIndice() {
		return indice;
	}

	public abstract boolean esFabricante();

	public int compareTo(PersonaDeInteres other) {
		return Integer.compare(this.cantidad, other.cantidad);
	}

}
