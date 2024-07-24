package Rescate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

	public static final String RUTA_ARCHIVOS_ENTRADA = "Archivos/in/";
	public static final String RUTA_ARCHIVOS_TESTS_ENTRADA = "Archivos/test/in/";
	public static final String RUTA_ARCHIVOS_SALIDA = "Archivos/out/";
	public static final String RUTA_ARCHIVOS_TESTS_SALIDA = "Archivos/test/out/";

	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public Rescate leerArchivoRescate(String rutaArchivo) {

		Scanner scanner = null;
		int cantidadDeClaros = 0;
		int cantidadDeSenderos = 0;
		int[] dragones = null;
		int claroPrincesa = 0;
		int claroPrincipe = 0;
		int[][] senderos = null;

		try {
			File file = new File(rutaArchivo + this.nombre + ".in");

			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			cantidadDeClaros = scanner.nextInt();
			cantidadDeSenderos = scanner.nextInt();
			dragones = new int[scanner.nextInt()];
			claroPrincesa = scanner.nextInt();
			claroPrincipe = scanner.nextInt();

			for (int i = 0; i < dragones.length; i++) {
				dragones[i] = scanner.nextInt();
			}

			senderos = new int[cantidadDeSenderos][3];

			for (int i = 0; i < cantidadDeSenderos; i++) {
				senderos[i][0] = scanner.nextInt();
				senderos[i][1] = scanner.nextInt();
				senderos[i][2] = scanner.nextInt();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return new Rescate(cantidadDeClaros, cantidadDeSenderos, dragones, claroPrincesa, claroPrincipe, senderos);
	}

	public void generarArchivoRescate(String rutaArchivo, String salida) throws IOException {
		FileWriter file = null;
		PrintWriter printWriter = null;

		try {
			file = new FileWriter(rutaArchivo + this.nombre + ".out");
			printWriter = new PrintWriter(file);
			printWriter.println(salida.trim());

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
