package entidades;

import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {
	public static final String RUTA_ARCHIVOS_ENTRADA = "archivos/in/";
	public static final String RUTA_ARCHIVOS_TESTS_ENTRADA = "archivos/test/in/";
	public static final String RUTA_ARCHIVOS_SALIDA = "archivos/out/";
	public static final String RUTA_ARCHIVOS_TESTS_SALIDA = "archivos/test/out/";

	private String nombre;
	

	public Archivo(String nombre) {
		this.nombre = nombre;
	}
	
	public String[][] leerArchivo(String rutaArchivo) {

		Scanner scanner = null;
		String[][] matriz = null;
		
		try {
			File file = new File(rutaArchivo + this.nombre + ".in");

			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			
			// Leer los primeros dos números que representan las dimensiones del terreno
            String[] dimensiones = scanner.nextLine().split(" ");
            int filas = Integer.parseInt(dimensiones[0]);
            int columnas = Integer.parseInt(dimensiones[1]);
            
            // Crear la matriz con las dimensiones obtenidas
            matriz = new String[filas][columnas];
            
            // Leer la dimension de la casa
            scanner.nextLine().split(" ");
            
            // Leer la cantidad de piedras en el terreno
            int cantidadPiedras = Integer.parseInt(scanner.nextLine());
            
            // Llenar el terreno con las ubicaciones de las piedras
            for (int i = 0; i < cantidadPiedras; i++) {
                String[] ubicacionPiedra = scanner.nextLine().split(" ");
                int filaPiedra = Integer.parseInt(ubicacionPiedra[0]) - 1;
                int columnaPiedra = Integer.parseInt(ubicacionPiedra[1]) - 1;
                matriz[filaPiedra][columnaPiedra] = "P";
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return matriz;
	}
	
	public String[][] leerArchivoCasa(String rutaArchivo) {

		Scanner scanner = null;
		String[][] matriz = null;
		
		try {
			File file = new File(rutaArchivo + this.nombre + ".in");

			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			
			// Leer los primeros dos números que representan las dimensiones del terreno
            scanner.nextLine().split(" ");
            
            // Leer la dimension de la casa
            String[] dimensionesCasa = scanner.nextLine().split(" ");
            int filasCasa = Integer.parseInt(dimensionesCasa[0]);
            int columnasCasa = Integer.parseInt(dimensionesCasa[1]);
            
            matriz = new String[filasCasa][columnasCasa];
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return matriz;
	}
	
	public void crearArchivoSalida(int[] puntas, String rutaArchivo) {
		FileWriter file = null;
		PrintWriter printWriter = null;
		try {
			file = new FileWriter(rutaArchivo + this.nombre + ".out");
			printWriter = new PrintWriter(file);
			if(puntas[0]== -1) {
				printWriter.println("NO");
			}else {
				printWriter.println("SI");
				printWriter.println(puntas[0] + " " + puntas[1]);
				printWriter.println(" ");// aca deberiamos escribir la direccion de la puerta 
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
