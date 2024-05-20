package Entidades;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {
	
	public static boolean TODO_OK = true;
	public static final String RUTA_ARCHIVOS_ENTRADA = "archivos/in/";
	public static final String RUTA_ARCHIVOS_TESTS_ENTRADA = "archivos/test/in/";
	public static final String RUTA_ARCHIVOS_SALIDA = "archivos/out/";
	public static final String RUTA_ARCHIVOS_TESTS_SALIDA = "archivos/test/out/";

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
			
			// Leer la primera linea del archivo, que representa el presupuesto, cantidad de fabricantes y cantidad de compradores
            String[] primeraLinea = scanner.nextLine().split(" ");
            presupuesto = Integer.parseInt(primeraLinea[0]); 
            int cantidadDeFabricantes = Integer.parseInt(primeraLinea[1]);
            int cantidadDeCompradores = Integer.parseInt(primeraLinea[2]);
            
            for(int i = 0; i < cantidadDeFabricantes; i++) {
            	String[] registro = scanner.nextLine().split(" ");
            	int precioACobrarPorUnidad = Integer.parseInt(registro[0]);
            	int cantidadMinimaDeUnidades = Integer.parseInt(registro[1]);
            	Fabricante fabricante = new Fabricante(precioACobrarPorUnidad, cantidadMinimaDeUnidades);
            	fabricantes.add(fabricante);
            }
            
            for(int i = 0; i < cantidadDeCompradores; i++) {
            	String[] registro = scanner.nextLine().split(" ");
            	int precioAPagarPorUnidad = Integer.parseInt(registro[0]);
            	int cantidadDeUnidadesAComprar = Integer.parseInt(registro[1]);
            	Comprador comprador = new Comprador(precioAPagarPorUnidad, cantidadDeUnidadesAComprar);
            	compradores.add(comprador);
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return presupuesto;
	}
	
}
