package Entidades;

import java.util.Objects;

public class Comprador extends PersonaDeInteres {

	public Comprador(int precio, int cantidad, int indice) {
		super(precio, false, cantidad, indice);
	}

	@Override
	public boolean esFabricante() {
		return false;
	}

	@Override
	public String toString() {
		return "Precio a pagar por unidad: " + this.getPrecio() + "\tCantidad de unidades a comprar: "
				+ this.getCantidad();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getCantidad(), this.getPrecio());
	}

}
