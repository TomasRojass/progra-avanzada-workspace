package Entidades;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

	public static int TODO_OK = 0;
	public static int ERROR_RANGOS = -1;
	
	public static final String RUTA_ARCHIVOS = "Archivos/";
	public static final String RUTA_ARCHIVOS_TESTS = "Archivos/test/";

	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public int leerArchivo(String rutaArchivo, List<Fabricante> fabricantes, List<Comprador> compradores) {
		Scanner scanner = null;
		int presupuesto = 0;
		try {
			File file = new File(rutaArchivo + this.nombre + ".in");
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			// Leer la primera linea del archivo, que representa:
			// * Presupuesto
			// * Cantidad de fabricantes
			// * Cantidad de compradores
			String[] primeraLinea = scanner.nextLine().split(" ");
			presupuesto = Integer.parseInt(primeraLinea[0]);
			int cantidadDeFabricantes = Integer.parseInt(primeraLinea[1]);
			int cantidadDeCompradores = Integer.parseInt(primeraLinea[2]);
			if(verificarRangos(presupuesto, cantidadDeFabricantes, cantidadDeCompradores) != TODO_OK) {
				return ERROR_RANGOS;
			}
			// Con la cantidad de fabricantes y compradores obtenidas cargo las listas
			if(cargarListaFabricantes(scanner, cantidadDeFabricantes, fabricantes) != TODO_OK) {
				return ERROR_RANGOS;
			}
			if(cargarListaCompradores(scanner, cantidadDeCompradores, compradores) != TODO_OK) {
				return ERROR_RANGOS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return presupuesto;
	}
	
	private int cargarListaFabricantes(Scanner scanner, int cantidadDeFabricantes, List<Fabricante> fabricantes) {
		for (int i = 0; i < cantidadDeFabricantes; i++) {
			String[] registro = scanner.nextLine().split(" ");
			int precioACobrarPorUnidad = Integer.parseInt(registro[0]);
			int cantidadMinimaDeUnidades = Integer.parseInt(registro[1]);
			if(verificarPrecioYCantidad(precioACobrarPorUnidad, cantidadMinimaDeUnidades) != TODO_OK) {
				return ERROR_RANGOS;
			}
			Fabricante fabricante = new Fabricante(precioACobrarPorUnidad, cantidadMinimaDeUnidades);
			fabricantes.add(fabricante);
		}
		return TODO_OK;
	}

	private int cargarListaCompradores(Scanner scanner, int cantidadDeCompradores, List<Comprador> compradores) {
		for (int i = 0; i < cantidadDeCompradores; i++) {
			String[] registro = scanner.nextLine().split(" ");
			int precioAPagarPorUnidad = Integer.parseInt(registro[0]);
			int cantidadDeUnidadesAComprar = Integer.parseInt(registro[1]);
			if(verificarPrecioYCantidad(precioAPagarPorUnidad, cantidadDeUnidadesAComprar) != TODO_OK) {
				return ERROR_RANGOS;
			}
			Comprador comprador = new Comprador(precioAPagarPorUnidad, cantidadDeUnidadesAComprar);
			compradores.add(comprador);
		}
		return TODO_OK;
	}

	private int verificarRangos(int presupuesto, int cantidadDeFabricantes, int cantidadDeCompradores) {
		return (presupuesto < 1 && presupuesto > 1_000_000_000) || 
			   (cantidadDeFabricantes < 1 && cantidadDeFabricantes > 100_000) || 
			   (cantidadDeCompradores < 1 && cantidadDeCompradores > 100_000)?
				ERROR_RANGOS : TODO_OK; 
	}
	
	private int verificarPrecioYCantidad (int precio, int cantidad) {
		return (precio < 1 && precio > 10_000) || (cantidad < 1 && cantidad > 100_000)?
				ERROR_RANGOS : TODO_OK;
	}
	
}
