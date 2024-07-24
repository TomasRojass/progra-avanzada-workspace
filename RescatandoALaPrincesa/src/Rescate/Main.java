package Rescate;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Archivo archivoIn = new Archivo("entrada");
		Rescate rescate = archivoIn.leerArchivoRescate(Archivo.RUTA_ARCHIVOS_ENTRADA);
		String respuestaRescate = rescate.resolver();
		Archivo archivoOut = new Archivo("salida");
		archivoOut.generarArchivoRescate(Archivo.RUTA_ARCHIVOS_SALIDA, respuestaRescate);
	}

}
