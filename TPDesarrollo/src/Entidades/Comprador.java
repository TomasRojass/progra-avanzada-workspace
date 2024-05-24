package Entidades;

import java.util.Objects;

public class Comprador implements Comparable<Comprador> {

	private static int inicio = 1;
	private int numero;
	private int precioAPagarPorUnidad;
	private int cantidadDeUnidadesAComprar; // Por dia

	public Comprador(int precioAPagarPorUnidad, int cantidadDeUnidadesAComprar) {
		this.numero = inicio++;
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

	@Override
	public int hashCode() {
		return Objects.hash(cantidadDeUnidadesAComprar, precioAPagarPorUnidad);
	}


	@Override
	public int compareTo(Comprador o) {
		return o.cantidadDeUnidadesAComprar * o.precioAPagarPorUnidad - cantidadDeUnidadesAComprar * precioAPagarPorUnidad;
	}



	public int getNumero() {
		return numero;
	}

}
