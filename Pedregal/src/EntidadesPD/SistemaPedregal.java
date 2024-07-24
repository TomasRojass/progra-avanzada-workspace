package EntidadesPD;

public class SistemaPedregal {

	public void iniciar() {
		Archivo archivoIn = new Archivo("Pedregal");
		PlanConstruccion plan = archivoIn.leerArchivo(Archivo.RUTA_ARCHIVOS_ENTRADA);
		this.construirCasaBottomUp(plan);
		Archivo archivoOut = new Archivo("Pedregal");
		archivoOut.generarArchivo(Archivo.RUTA_ARCHIVOS_SALIDA, plan);
	}

	/**
	 * Intenta construir una casa en el terreno utilizando una estrategia de
	 * bottom-up. Se utiliza una matriz de acumulación de piedras para verificar si
	 * hay espacio suficiente para la casa en cada posible ubicación del terreno.
	 * 
	 * @param plan El objeto PlanConstruccion que contiene la información del
	 *             terreno y la casa.
	 */
	private void construirCasaBottomUp(PlanConstruccion plan) {
		int[][] matrizIntermediaPiedras = this.crearMatrizDePiedras(plan);

		int frente = plan.getFrenteCasa();
		int lado = plan.getLadoCasa();
		int filas = plan.getTerreno().length;
		int columnas = plan.getTerreno()[0].length;

		/**
		 * Todas las sumas de +1 en los indices es porque el archivo viene desde fila y
		 * columna 1
		 */
		for (int i = 0; i < filas && plan.getUbicacionCasa() == null; i++) {
			for (int j = 0; j < columnas && plan.getUbicacionCasa() == null; j++) {
				if (i - frente + 1 >= 0 && j - lado + 1 >= 0) {
					this.intentarFabricarCasa(plan, frente, lado, i, j, matrizIntermediaPiedras);
				}
				// casa rotada
				if (i - lado + 1 >= 0 && j - frente + 1 >= 0) {
					this.intentarFabricarCasa(plan, lado, frente, i, j, matrizIntermediaPiedras);
				}
			}
		}

	}

	/**
	 * Crea una matriz de acumulación basada en la matriz del terreno de
	 * PlanConstruccion. La matriz de acumulación facilita el cálculo de la suma de
	 * elementos en submatrices del terreno.
	 * 
	 * - La primera fila se acumula sumando valores de izquierda a derecha. - La
	 * primera columna se acumula sumando valores de arriba a abajo. - Otras celdas
	 * se calculan sumando el valor de la celda de arriba, la celda a la izquierda,
	 * y el valor del terreno actual, restando la celda diagonal superior izquierda.
	 * 
	 * @param plan El objeto PlanConstruccion que contiene la matriz del terreno.
	 * @return Una matriz de acumulación con las mismas dimensiones que la matriz
	 *         del terreno.
	 */
	private int[][] crearMatrizDePiedras(PlanConstruccion plan) {
		int[][] matriz = new int[plan.getTerreno().length][plan.getTerreno()[0].length];
		int[][] terreno = plan.getTerreno();
		int filas = matriz.length;
		int columnas = matriz[0].length;

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (i == 0) {
					if (j == 0) {
						matriz[i][j] = terreno[i][j];
					} else {
						matriz[i][j] = matriz[i][j - 1] + terreno[i][j];
					}
				} else if (j == 0) {
					matriz[i][j] = matriz[i - 1][j] + terreno[i][j];
				} else {
					matriz[i][j] = matriz[i - 1][j] + matriz[i][j - 1] + terreno[i][j] - matriz[i - 1][j - 1];
				}
			}
		}

		return matriz;
	}

	/**
	 * Intenta ubicar una casa en el terreno especificado por el objeto
	 * PlanConstruccion. Verifica si hay espacio suficiente en la matriz de
	 * acumulación de piedras para colocar la casa.
	 *
	 * - La verificación se realiza utilizando la matriz de acumulación de piedras
	 * para determinar si la submatriz correspondiente al espacio de la casa está
	 * libre de piedras. - Si se encuentra un lugar adecuado, se establece la
	 * ubicación de la casa en el plan.
	 *
	 * @param plan          El objeto PlanConstruccion que contiene la matriz del
	 *                      terreno y las dimensiones de la casa.
	 * @param frente        El número de filas que ocupa la casa.
	 * @param lado          El número de columnas que ocupa la casa.
	 * @param i             La fila actual en la matriz del terreno.
	 * @param j             La columna actual en la matriz del terreno.
	 * @param matrizPiedras La matriz de acumulación de piedras.
	 */
	private void intentarFabricarCasa(PlanConstruccion plan, int frente, int lado, int i, int j,
			int[][] matrizPiedras) {
		boolean hayLugar = false;
		if (j - lado + 1 == 0) {
			if (i - frente + 1 == 0 && matrizPiedras[i][j] == 0) {
				int[] ubicacion = { i + 1, j + 1 };
				plan.setUbicacionCasa(ubicacion);
			}
			if (i - frente + 1 > 0) {
				hayLugar = matrizPiedras[i][j] - matrizPiedras[i - frente][j] == 0;
			}
		} else if (j - lado + 1 > 0) {
			if (i - frente == 0) {
				hayLugar = matrizPiedras[i][j] - matrizPiedras[i][j - lado] == 0;
			}
			if (i - frente + 1 > 0) {
				hayLugar = matrizPiedras[i][j] - matrizPiedras[i - frente][j] - matrizPiedras[i][j - lado]
						+ matrizPiedras[i - frente][j - lado] == 0;
			}
		}
		if (hayLugar) {
			int[] ubicacion = { i + 1 - frente, j + 1 - lado };
			plan.setUbicacionCasa(ubicacion);
		}
	}
}
