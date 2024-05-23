package Entidades;

public class Comprador {

	private int precioAPagarPorUnidad;
	private int cantidadDeUnidadesAComprar; // Por dia

	public Comprador(int precioAPagarPorUnidad, int cantidadDeUnidadesAComprar) {
		this.precioAPagarPorUnidad = precioAPagarPorUnidad;
		this.cantidadDeUnidadesAComprar = cantidadDeUnidadesAComprar;
	}

	public int getPrecioAPagarPorUnidad() {
		return precioAPagarPorUnidad;
	}

	public int getCantidadDeUnidadesAComprar() {
		return cantidadDeUnidadesAComprar;
	}

	@Override
	public String toString() {
		return "Precio a pagar por unidad: " + precioAPagarPorUnidad + "\tCantidad de unidades a comprar: " + cantidadDeUnidadesAComprar;
	}

}