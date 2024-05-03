package ejercicios;

//import java.util.Arrays;

/*Ejercicio: La mina de Oro
 * 
 * Dada una mina de n filas y m columnas, donde mina[i][j] representa la cantidad de oro presente
 * en esa ubicacion. Queremos ingresar desde la parte superior de la mina y obtener tanto oro
 * como sea posible al llegar al fondo, sabiendo que solamente podemos movernos hacia abajo, o
 * un casillero en diagonal. Podemos terminar en cualquier posicion de la ultima fila
 * 
 * Ejemplo
 * 3		2		12		[15]	10
 * 6		19		7		11		[17]
 * 8		5		12		[32]	21
 * 3		20		2		[9]		7
 * 
 * Output: 73 (15 + 17 + 32 + 9 = 73)
 * */

public class MinaDeOro {

	public int obtenerOroMaximoMetodoBottomUp(int[][] mina) {

		// Declaro un vector con la misma cantidad de filas y columnas
		// El cual voy a estar almacenando lo maximo de oro que puedo conseguir por cada
		// camino
		int[][] oroConseguido = new int[mina.length][mina[0].length];

		int filas = mina.length;
		int columnas = mina[0].length;
		int oroPosActual, oroArriba, oroArribaIzquierda, oroArribaDerecha;

		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {

				// En la primera fila guardo todo tal cual esta
				if (i == 0) {
					oroConseguido[i][j] = mina[i][j];
				} else {

					oroPosActual = mina[i][j];
					oroArriba = oroConseguido[i - 1][j];

					// En los casos que este en una pared (j = 0 o j == mina[i].length - 1)
					// Solo voy a fijarme arriba de donde estoy parado y arriba a la izquierda o a
					// la derecha
					// segun que pared este
					if (j == 0) {

						// Caso que NO sea una sola columna
						if (j != columnas - 1) {
							oroArribaDerecha = oroConseguido[i - 1][j + 1];
							oroConseguido[i][j] = Math.max(oroPosActual + oroArriba, oroPosActual + oroArribaDerecha);
						} else {
							// Si es una sola columna, no hay arriba derecha, solo arriba
							oroConseguido[i][j] = oroPosActual + oroArriba;
						}

					} else if (j == columnas - 1) {
						oroArribaIzquierda = oroConseguido[i - 1][j - 1];
						oroConseguido[i][j] = Math.max(oroPosActual + oroArriba, oroPosActual + oroArribaIzquierda);
					} else {
						// Si no estoy en ninguna pared tengo que evaluar las tres posibilidades y
						// elegir el mayor
						oroArribaIzquierda = oroConseguido[i - 1][j - 1];
						oroArribaDerecha = oroConseguido[i - 1][j + 1];
						oroConseguido[i][j] = Math.max(
								Math.max(oroPosActual + oroArribaIzquierda, oroPosActual + oroArriba),
								oroPosActual + oroArribaDerecha);
					}

					// Es lo mismo que arriba pero menos intuitivo
					// int oroArriba = oroConseguido[i - 1][j];
					// int oroArribaIzquierda = (j > 0) ? oroConseguido[i - 1][j - 1] : 0;
					// int oroArribaDerecha = (j < cols - 1) ? oroConseguido[i - 1][j + 1] : 0;
					// int oroPosActual = mina[i][j];
					// oroConseguido[i][j] = oroPosActual + Math.max(oroArriba,
					// Math.max(oroArribaIzquierda, oroArribaDerecha));

				}
			}

		}

		// System.out.println("MATRIZ DE CAMINOS: ");
		// imprimirMatriz(oroConseguido);

		// El oro maximo conseguido se va a encontrar en la ultima fila de la matriz,
		// por lo tanto voy a buscar
		// el maximo en esa fila.
		return oroMaximo(oroConseguido[filas - 1]);

		// Es lo mismo
		// return Arrays.stream(oroConseguido[filas - 1]).max().getAsInt();
	}

	private int oroMaximo(int[] resultadoCaminos) {
		int oroMaximo = resultadoCaminos[0];
		for (int i = 1; i < resultadoCaminos.length; i++) {
			if (oroMaximo < resultadoCaminos[i]) {
				oroMaximo = resultadoCaminos[i];
			}
		}
		return oroMaximo;
	}

	public void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}