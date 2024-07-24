package Entidades;

public class SistemaPedregal {

	public void iniciar() {
		Archivo archivoIn = new Archivo("Pedregal");
		String[][] terreno = archivoIn.leerArchivo(Archivo.RUTA_ARCHIVOS_ENTRADA);
		String[][] casa = archivoIn.leerArchivoCasa(Archivo.RUTA_ARCHIVOS_ENTRADA);
		int[] puntas = esPosibleUbicarCasa(terreno, casa);		
		Archivo archivoOut= new Archivo("Pedregal");
		archivoOut.crearArchivoSalida(puntas, Archivo.RUTA_ARCHIVOS_SALIDA);
	}

	public static int[] esPosibleUbicarCasa(String[][] terreno, String[][] casa) {
		int[] puntas= new int[2];
		for (int i = 0; i <= terreno.length - casa.length; i++) { // asegurarse de que podamos comenzar a colocar la
																	// casa en una fila donde haya suficiente espacio
			for (int j = 0; j <= terreno[0].length - casa[0].length; j++) {
				boolean puedeUbicar = true;
				for (int k = 0; k < casa.length; k++) {
					for (int l = 0; l < casa[0].length; l++) {
						if (terreno[i + k][j + l] == "P") {
							puedeUbicar = false; // Hay una piedra en la ubicación de la casa
							break;
						}
					}
					if (!puedeUbicar) {
						break;
					}
				}
				if (puedeUbicar) {
					puntas[0]=i;
					puntas[1]=j;
					return puntas;
				}
			}
		}
		puntas[0]=-1;
		return puntas;
	}

}
