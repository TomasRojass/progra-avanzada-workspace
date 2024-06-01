package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Evaluador {

	MutableInt presupuesto;
	private List<Comprador> compradores;
	private List<Fabricante> fabricantes;

	public Evaluador() {
		this.compradores = new ArrayList<Comprador>();
		this.fabricantes = new ArrayList<Fabricante>();
		this.presupuesto = new MutableInt(0);
	}

	public void iniciar() {

		Archivo archivo = new Archivo("ganancia");
		int resultado = archivo.leerArchivo(Constante.RUTA_ARCHIVOS, this.fabricantes, this.compradores, presupuesto);
		if (resultado == Constante.ERROR_RANGOS) {
			System.out.println("Se produjo un error al leer el archivo");
			return;
		}
		if (resultado == Constante.ARCHIVO_VACIO) {
			System.out.println("El archivo no existe");
			return;
		}

		/*
		 * System.out.
		 * println("======================== Fabricantes ========================");
		 * mostrarFabricantes(fabricantes); System.out.
		 * println("======================== Compradores ========================");
		 * mostrarCompradores(compradores); System.out.
		 * println("======================== Presupuesto ========================");
		 * System.out.println(presupuesto.getValor());
		 */

		MutableInt numeroDeFabricanteSeleccionado = new MutableInt(0);
		MutableInt numeroDeCompradorSeleccionado = new MutableInt(0);

		int gananciaMaxima = ganancia(this.presupuesto.getValor(), this.fabricantes, this.compradores,
				numeroDeFabricanteSeleccionado, numeroDeCompradorSeleccionado);

		if (gananciaMaxima == Constante.RESIGNAR_NEGOCIO) {
			System.out.println("No se puede realizar ninguna operación sin pérdidas.");
		} else {
			System.out.println("Comprando a al fabricante " + numeroDeFabricanteSeleccionado.getValor()
					+ " y vendiendole al comprador " + numeroDeCompradorSeleccionado.getValor() + " gana "
					+ gananciaMaxima + " por día.");
		}
	}

	public int ganancia(int presupuesto, List<Fabricante> fabricantes, List<Comprador> compradores,
			MutableInt numeroDeFabricanteSeleccionado, MutableInt numeroDeCompradorSeleccionado) {

		int maximaGanancia = Integer.MIN_VALUE;

		Collections.sort(compradores);

		boolean compradorEncontrado = false;

		for (int compradorIndice = 0; compradorIndice < compradores.size() && !compradorEncontrado; compradorIndice++) {
			
			Comprador comprador = compradores.get(compradorIndice);
			int precioCompra = comprador.getPrecioAPagarPorUnidad();
			int cantidadCompra = comprador.getCantidadDeUnidadesAComprar();
			
			for (int fabricanteIndice = 0; fabricanteIndice < fabricantes.size(); fabricanteIndice++) {
				
				Fabricante fabricante = fabricantes.get(fabricanteIndice);
				int precioFabricacion = fabricante.getPrecioACobrarPorUnidad();
				int cantidadMinima = fabricante.getCantidadMinimaDeUnidades();

				// La cantidad que necesitamos comprar es el máximo entre la cantidad mínima del
				// fabricante y la cantidad que quiere el comprador
				int cantidadNecesaria = Math.max(cantidadMinima, cantidadCompra);
				int costoTotalFabricacion = cantidadNecesaria * precioFabricacion;

				// Verificamos si el costo total está dentro del presupuesto
				if (costoTotalFabricacion <= presupuesto) {

					// Calculamos la ganancia neta
					int ingresoTotal = cantidadCompra * precioCompra;
					int gananciaNeta = ingresoTotal - costoTotalFabricacion;

					if (gananciaNeta >= 0 && gananciaNeta > maximaGanancia) {

						maximaGanancia = gananciaNeta;
						numeroDeFabricanteSeleccionado.setValor(fabricanteIndice + 1);
						numeroDeCompradorSeleccionado.setValor(comprador.getNumero());
						compradorEncontrado = true;
					}

				}
			}
		}
		
		// Caso en que no se encontro ninguna combinación válida
		if (maximaGanancia == Integer.MIN_VALUE) {
			numeroDeFabricanteSeleccionado.setValor(0);
			numeroDeCompradorSeleccionado.setValor(0);
			return Constante.RESIGNAR_NEGOCIO;
		}

		return maximaGanancia;
	}

	@SuppressWarnings("unused")
	private void mostrarFabricantes(List<Fabricante> fabricantes) {
		int numeroDeFabricante = 1;
		for (Fabricante fabricante : fabricantes) {
			System.out.println("Fabricante: " + numeroDeFabricante++ + "\t" + fabricante + "\tCosto total: "
					+ fabricante.getCantidadMinimaDeUnidades() * fabricante.getPrecioACobrarPorUnidad());
		}
	}

	@SuppressWarnings("unused")
	private void mostrarCompradores(List<Comprador> compradores) {
		for (Comprador comprador : compradores) {
			System.out.println("Comprador: " + comprador.getNumero() + "\t" + comprador + "\tCosto total: "
					+ comprador.getCantidadDeUnidadesAComprar() * comprador.getPrecioAPagarPorUnidad());
		}
	}
}
