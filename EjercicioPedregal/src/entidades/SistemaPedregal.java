package entidades;

public class SistemaPedregal {

	public void iniciar() {

		Archivo archivoIn = new Archivo("Pedregal");
		String[][] terreno = archivoIn.leerArchivo(Archivo.RUTA_ARCHIVOS_ENTRADA);

//		for(int i=0; i<terreno.length; i++) {
//			for( int j=0; j< terreno[0].length; j++)
//				System.out.print(terreno[i][j] + "         ");
//			System.out.println("\n");
//		}

		String[][] casa = archivoIn.leerArchivoCasa(Archivo.RUTA_ARCHIVOS_ENTRADA);
//		System.out.println("\n");
//		System.out.println("\n");
//		for(int i=0; i<casa.length; i++) {
//			for( int j=0; j< casa[0].length; j++)
//				System.out.print(casa[i][j] + "         ");
//			System.out.println("\n");
//		}
		
//		int minFila= terreno.length;
//		int minCol = terreno[0].length;
//		por ahora le asigno las puntas mas grandes, habria que ver como obtener la punta mas pequeña
		int[] puntas = esPosibleUbicarCasa(terreno, casa);
//		boolean puedeUbicar = esPosibleUbicarCasa(terreno, casa, minFila, minCol);
//		if (puntas[0] != -1) { 
//			System.out.println("Se puede ubicar la casa");
//			//System.out.println("fila minima: " +puntas[0] + "\ncolumna minima: " + puntas[1]);
//		}
//		else
//			System.out.println("No se puede ubicar la casa");
//		
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
