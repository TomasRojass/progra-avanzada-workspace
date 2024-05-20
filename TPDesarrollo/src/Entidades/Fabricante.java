package Entidades;

public class Fabricante {
	
	private int precioACobrarPorUnidad;
	private int cantidadMinimaDeUnidades;
	
	public Fabricante(int precioACobrarPorUnidad, int cantidadMinimaDeUnidades) {
		this.precioACobrarPorUnidad = precioACobrarPorUnidad;
		this.cantidadMinimaDeUnidades = cantidadMinimaDeUnidades;
	}

	public int getPrecioACobrarPorUnidad() {
		return precioACobrarPorUnidad;
	}

	public int getCantidadMinimaDeUnidades() {
		return cantidadMinimaDeUnidades;
	}

	@Override
	public String toString() {
		return "Fabricante [precioACobrarPorUnidad=" + precioACobrarPorUnidad + ", cantidadMinimaDeUnidades="
				+ cantidadMinimaDeUnidades + "]";
	}
	
	
}
