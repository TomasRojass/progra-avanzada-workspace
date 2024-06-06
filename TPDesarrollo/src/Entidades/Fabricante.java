package Entidades;

public class Fabricante extends PersonaDeInteres{


	public Fabricante(int precio, int cantidad, int indice) {
		super(precio, true , cantidad, indice);
	}

	@Override
	public boolean esFabricante() {
	   return true;
	}

	@Override
	public String toString() {
		return "Precio a cobrar por unidad: " + this.getPrecio() + "\tCantidad minima de unidades: " + this.getCantidad();
	}



}
