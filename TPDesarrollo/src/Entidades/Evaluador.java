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

		System.out.println("======================== Fabricantes ========================");
		mostrarFabricantes(fabricantes);
		System.out.println("======================== Compradores ========================");
		mostrarCompradores(compradores);
		System.out.println("======================== Presupuesto ========================");
		System.out.println(presupuesto.getValor());

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

	public static int ganancia(int P, List<Fabricante> fabricantes, List<Comprador> compradores, MutableInt Fab,
			MutableInt Comp) {
		int resultado = Constante.RESIGNAR_NEGOCIO; // Indicando que inicialmente no hay ganancia calculada.

		// Armo una lista con todos los fabricantes y todos los compradores, unos seguidos de los otros
		List<PersonaDeInteres> personas = new ArrayList<>();

		personas.addAll(fabricantes);
		personas.addAll(compradores);

		Collections.sort(personas); // Ordeno por cantidad

		int[] minPrecio = { Integer.MAX_VALUE, -1 };

		// Primer recorrido para encontrar la ganancia máxima
		// minPrecio: Guarda el precio mínimo de los fabricantes encontrados hasta el momento y su índice.

		// PRECIO POR UNIDAD
		for (PersonaDeInteres p : personas) {
			// Si es un fabricante, se actualiza minPrecio si el precio del fabricante es menor que el mínimo actual.
			if (p.esFabricante()) {
				if (minPrecio[0] > p.getPrecio()) {
					minPrecio[0] = p.getPrecio();
					minPrecio[1] = p.getIndice();
				}
			} else {
				// Si es un comprador, se calcula la posible ganancia si se compra al precio mínimo encontrado (minPrecio).
				// Si la ganancia es mayor que la resultado actual, se actualiza res, y los índices de Comp y Fab.
				if (p.getCantidad() * minPrecio[0] <= P && minPrecio[1] != -1) {
					int ganancia = p.getCantidad() * (p.getPrecio() - minPrecio[0]);
					if (ganancia > resultado) {
						resultado = ganancia;
						Comp.setValor(p.getIndice());
						Fab.setValor(minPrecio[1]);
					}
				}
			}
		}

		// Segundo recorrido para maximizar la ganancia basada en el costo total
		// minCosto: Guarda el costo mínimo total de los fabricantes encontrados y su índice.
		int[] minCosto = { Integer.MAX_VALUE, -1 };

		// La lista personas se invierte para procesar desde el más grande al más pequeño.
		Collections.reverse(personas);

		// PRECIO POR COSTO
		for (PersonaDeInteres p : personas) {

			// Si es un fabricante, se calcula su costo total.
			// Si este costo es menor que el presupuesto P y menor que el mínimo actual, se actualiza minCosto.
			if (p.esFabricante()) {
				int costo = p.getPrecio() * p.getCantidad();
				if (costo <= P && minCosto[0] > costo) {
					minCosto[0] = costo;
					minCosto[1] = p.getIndice();
				}
			} else {
				// Si es un comprador, se calcula la posible ganancia con el costo mínimo encontrado (minCosto).
				// Si la ganancia es mayor que la res actual, se actualiza res
				int ganancia = p.getCantidad() * p.getPrecio() - minCosto[0];
				if (ganancia > resultado) {
					resultado = ganancia;
					Comp.setValor(p.getIndice());
					Fab.setValor(minCosto[1]);
				}
			}
		}

		return resultado;
	}

	private void mostrarFabricantes(List<Fabricante> fabricantes) {
		for (Fabricante fabricante : fabricantes) {
			System.out.println("Fabricante: " + fabricante.getIndice() + "\t" + fabricante + "\tCosto total: "
					+ fabricante.getCantidad() * fabricante.getPrecio());
		}
	}

	private void mostrarCompradores(List<Comprador> compradores) {
		for (Comprador comprador : compradores) {
			System.out.println("Comprador: " + comprador.getIndice() + "\t" + comprador + "\tCosto total: "
					+ comprador.getCantidad() * comprador.getPrecio());
		}
	}
}
