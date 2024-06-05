package Entidades;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {
	
	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public int leerArchivo(String rutaArchivo, List<Fabricante> fabricantes, List<Comprador> compradores, MutableInt presupuesto) {
		Scanner scanner = null;
		try {
			File file = new File(rutaArchivo + this.nombre + ".in");
			if (file.length() == 0) {
	            return Constante.ARCHIVO_VACIO;
	        }
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			// Leer la primera linea del archivo, que representa:
			// * Presupuesto
			// * Cantidad de fabricantes
			// * Cantidad de compradores
			String[] primeraLinea = scanner.nextLine().split(" ");
			presupuesto.setValor(Integer.parseInt(primeraLinea[0]));
			int cantidadDeFabricantes = Integer.parseInt(primeraLinea[1]);
			int cantidadDeCompradores = Integer.parseInt(primeraLinea[2]);
			if(Validacion.verificarRangos(presupuesto.getValor(), cantidadDeFabricantes, cantidadDeCompradores) != Constante.TODO_OK) {
				return Constante.ERROR_RANGOS;
			}
			// Con la cantidad de fabricantes y compradores obtenidas cargo las listas
			if(cargarListaFabricantes(scanner, cantidadDeFabricantes, fabricantes) != Constante.TODO_OK) {
				return Constante.ERROR_RANGOS;
			}
			if(cargarListaCompradores(scanner, cantidadDeCompradores, compradores) != Constante.TODO_OK) {
				return Constante.ERROR_RANGOS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(scanner != null) {
				scanner.close();				
			}
		}
		return Constante.TODO_OK;
	}
	
	private int cargarListaFabricantes(Scanner scanner, int cantidadDeFabricantes, List<Fabricante> fabricantes) {
		for (int i = 0; i < cantidadDeFabricantes; i++) {
			String[] registro = scanner.nextLine().split(" ");
			int precioACobrarPorUnidad = Integer.parseInt(registro[0]);
			int cantidadMinimaDeUnidades = Integer.parseInt(registro[1]);
			if(Validacion.verificarPrecioYCantidad(precioACobrarPorUnidad, cantidadMinimaDeUnidades) != Constante.TODO_OK) {
				return Constante.ERROR_RANGOS;
			}
			Fabricante fabricante = new Fabricante(precioACobrarPorUnidad, cantidadMinimaDeUnidades,i+1);
			fabricantes.add(fabricante);
		}
		return Constante.TODO_OK;
	}

	private int cargarListaCompradores(Scanner scanner, int cantidadDeCompradores, List<Comprador> compradores) {
		for (int i = 0; i < cantidadDeCompradores; i++) {
			String[] registro = scanner.nextLine().split(" ");
			int precioAPagarPorUnidad = Integer.parseInt(registro[0]);
			int cantidadDeUnidadesAComprar = Integer.parseInt(registro[1]);
			if(Validacion.verificarPrecioYCantidad(precioAPagarPorUnidad, cantidadDeUnidadesAComprar) != Constante.TODO_OK) {
				return Constante.ERROR_RANGOS;
			}
			Comprador comprador = new Comprador(precioAPagarPorUnidad, cantidadDeUnidadesAComprar,i+1);
			compradores.add(comprador);
		}
		return Constante.TODO_OK;
	}

}
