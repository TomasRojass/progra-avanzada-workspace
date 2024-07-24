package DistanciaDeEdicion;

public class DistanciaDeEdicion {

	public static int obtenerMinimaDeOperaciones(String primerPalabra, String segundaPalabra) {
		int longitudPrimeraPalabra = primerPalabra.length();
		int longitudSegundaPalabra = segundaPalabra.length();
		int[][] matrizDeCostosMinimos = new int[longitudPrimeraPalabra + 1][longitudSegundaPalabra + 1];

		// Inicializar la primera fila y columna
		for (int i = 0; i <= longitudPrimeraPalabra; i++) {
			matrizDeCostosMinimos[i][0] = i;
		}
		for (int j = 0; j <= longitudSegundaPalabra; j++) {
			matrizDeCostosMinimos[0][j] = j;
		}

		// Llenar la tabla dp
		for (int i = 1; i <= longitudPrimeraPalabra; i++) {
			for (int j = 1; j <= longitudSegundaPalabra; j++) {
				if (primerPalabra.charAt(i - 1) == segundaPalabra.charAt(j - 1)) {
					matrizDeCostosMinimos[i][j] = matrizDeCostosMinimos[i - 1][j - 1];
				} else {
					matrizDeCostosMinimos[i][j] = Math.min(matrizDeCostosMinimos[i - 1][j - 1], // Sustitución
							Math.min(matrizDeCostosMinimos[i][j - 1], // Inserción
									matrizDeCostosMinimos[i - 1][j]) // Eliminación
					) + 1;
				}
			}
		}

		return matrizDeCostosMinimos[longitudPrimeraPalabra][longitudSegundaPalabra];
	}

}
