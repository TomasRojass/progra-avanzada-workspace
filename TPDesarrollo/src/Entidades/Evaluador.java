package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Evaluador {

	public void iniciar() {

		List<Comprador> compradores = new ArrayList<Comprador>();
		List<Fabricante> fabricantes = new ArrayList<Fabricante>();

		Archivo archivo = new Archivo("ganancia");
		int presupuesto = archivo.leerArchivo(Archivo.RUTA_ARCHIVOS_ENTRADA, fabricantes, compradores);

		/*System.out.println("======================== Fabricantes ========================");
		mostrarFabricantes(fabricantes);
		System.out.println("======================== Compradores ========================");
		mostrarCompradores(compradores);
		System.out.println("======================== Presupuesto ========================");
		System.out.println(presupuesto);*/

		MutableInt numeroDeFabricanteSeleccionado = new MutableInt(0);
		MutableInt numeroDeCompradorSeleccionado = new MutableInt(0);

		int gananciaMaxima = ganancia(presupuesto, fabricantes, compradores, numeroDeFabricanteSeleccionado, numeroDeCompradorSeleccionado);

		System.out.println("Comprando a " + numeroDeCompradorSeleccionado.getValor() + " y vendiendo a " + numeroDeFabricanteSeleccionado.getValor() + " gana " + gananciaMaxima + " por día.");
	}

	public int ganancia(int presupuesto, List<Fabricante> fabricantes, List<Comprador> compradores, MutableInt numeroDeFabricanteSeleccionado, MutableInt numeroDeCompradorSeleccionado) {

		int maximaGanancia = 0;
		
		numeroDeFabricanteSeleccionado.setValor(1);
		numeroDeCompradorSeleccionado.setValor(1);
		
		int compradorActual = 1;

		for (Comprador comprador : compradores) {

			int gananciaPorVenta = comprador.getCantidadDeUnidadesAComprar() * comprador.getPrecioAPagarPorUnidad();
			int fabricanteActual = 1;

			for (Fabricante fabricante : fabricantes) {

				int cantidadAPedir = comprador.getCantidadDeUnidadesAComprar() < fabricante.getCantidadMinimaDeUnidades() ? 
						fabricante.getCantidadMinimaDeUnidades() : comprador.getCantidadDeUnidadesAComprar();

				int costoDeFabricante = cantidadAPedir * fabricante.getPrecioACobrarPorUnidad();

				if (costoDeFabricante <= presupuesto) {

					int gananciaNeta = gananciaPorVenta - costoDeFabricante;

					if (gananciaNeta > maximaGanancia) {

						maximaGanancia = gananciaNeta;
						numeroDeFabricanteSeleccionado.setValor(fabricanteActual);
						numeroDeCompradorSeleccionado.setValor(compradorActual);

					}
				}
				fabricanteActual++;
			}
			compradorActual++;
		}
		return maximaGanancia;
	}

	@SuppressWarnings("unused")
	private void mostrarFabricantes(List<Fabricante> fabricantes) {
		int numeroDeFabricante = 1;
		for (Fabricante fabricante : fabricantes) {
			System.out.println("Fabricante: " + numeroDeFabricante++ + "\t" + fabricante);
		}
	}
	
	@SuppressWarnings("unused")
	private void mostrarCompradores(List<Comprador> compradores) {
		int numeroDeComprador = 1;
		for (Comprador comprador : compradores) {
			System.out.println("Comprador: " + numeroDeComprador++ + "\t" + comprador);
		}
	}
}
