package sumaSubrectangulos;

public class SumaSubrectangulos {
	
	/**
	 * Calcula la suma máxima de cualquier subrectángulo en una matriz dada.
	 * Utiliza una matriz intermedia de sumas acumuladas para facilitar el cálculo de sumas de submatrices.
	 *
	 * @param matriz La matriz de enteros de entrada.
	 * @return La suma máxima de cualquier subrectángulo en la matriz.
	 */
	public long calcularMaximaSumaSubrectangulo(int[][] matriz) {
		int[][] matrizIntermedia = this.generarMatrizIntermediaDeSuma(matriz);
		long maximaSuma = matrizIntermedia[0][0];
		
		for(int tamFila=1; tamFila <= matriz.length; tamFila++) {
			for(int tamCol=1; tamCol <= matriz[0].length; tamCol++) {
				
				int ubicFila = tamFila-1;
				while(ubicFila < matriz.length && ubicFila + tamFila <= matrizIntermedia.length) {
					int ubicCol = tamCol - 1;
					while(ubicCol < matriz[0].length && ubicCol + tamCol <= matrizIntermedia[0].length) {
						long sumaSubMatriz;
						if(ubicFila - tamFila == -1) { // si esta en primera fila
							if(ubicCol - tamCol == -1) { // si esta en primera fila primera columna
								sumaSubMatriz = matrizIntermedia[ubicFila][ubicCol];
							}
							else {
								sumaSubMatriz = matrizIntermedia[ubicFila][ubicCol] - matrizIntermedia[ubicFila][ubicCol-tamCol];
							}
						}
						else if(ubicCol - tamCol == -1) { // si esta en primera columna
							sumaSubMatriz = matrizIntermedia[ubicFila][ubicCol] - matrizIntermedia[ubicFila - tamFila][ubicCol];
						}
						else {
							sumaSubMatriz = matrizIntermedia[ubicFila][ubicCol] - matrizIntermedia[ubicFila][ubicCol -tamCol] - matrizIntermedia[ubicFila -tamFila][ubicCol] + matrizIntermedia[ubicFila -tamFila][ubicCol  -tamCol];
						}
						
						if(sumaSubMatriz > maximaSuma) {
							maximaSuma = sumaSubMatriz;
						}
						ubicCol ++;
					}
					ubicFila ++;
				}
			}
		}
		
		return maximaSuma;
		
	}
	
	
	/**
	 * Genera una matriz intermedia de sumas acumuladas para facilitar el cálculo de sumas de submatrices.
	 * La matriz intermedia en cada posición (i, j) contiene la suma de todos los elementos en el subrectángulo
	 * que va desde (0, 0) hasta (i, j) en la matriz original.
	 *
	 * @param matriz La matriz de enteros de entrada.
	 * @return La matriz intermedia de sumas acumuladas.
	 */
	private int[][] generarMatrizIntermediaDeSuma(int[][] matriz) {
		int cantFilas = matriz.length;
		int cantCol = matriz[0].length;
		int[][] matrizSuma = new int[cantFilas][cantCol];
		
		for(int i=0; i < cantFilas; i++) {
			for(int j=0; j < cantCol; j++) {
				if(i == 0) {
					if(j == 0) {
						matrizSuma[i][j] = matriz[i][j];
					}
					else {
						matrizSuma[i][j] = matriz[i][j] + matrizSuma[i][j-1];
					}
				}
				else if(j == 0) {
					matrizSuma[i][j] = matriz[i][j] + matrizSuma[i-1][j];
				}
				else {
					matrizSuma[i][j] = matriz[i][j] + matrizSuma[i][j-1] + matrizSuma[i-1][j] - matrizSuma[i-1][j-1];
				}
			}
		}
		
		return matrizSuma;
	}
}
