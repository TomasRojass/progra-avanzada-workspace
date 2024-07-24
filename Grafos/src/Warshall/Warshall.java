package Warshall;

public class Warshall {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Pasarlas a test
		int[][] matriz1 = new int[][] { { 0, 1, 1 }, { 0, 0, 0 }, { 0, 1, 0 } };

		int[][] matriz2 = new int[][] { { 0, 1, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };

		int[][] resultado;
		try {
			resultado = warshall(matriz2);
			System.out.println("La matriz de warshall es:");
			for (int i = 0; i < resultado.length; i++) {
				for (int j = 0; j < resultado[i].length; j++) {
					System.out.print(resultado[i][j] + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int[][] warshall(int[][] matriz) throws Exception {
		int largo = matriz.length;
		int[][] matrizDistancia = new int[largo][largo];

		for (int i = 0; i < largo; i++) {
			for (int j = 0; j < largo; j++) {
				matrizDistancia[i][j] = matriz[i][j];
			}
		}

		for (int k = 0; k < largo; k++) {

			for (int i = 0; i < largo; i++) {
				if (matrizDistancia[i][i] != 0) {
					throw new Exception("La distancia de un nodo a si mismo no puede ser distinto de cero");
				}
				for (int j = 0; j < largo; j++) {
					if (matrizDistancia[i][j] != 0 && matrizDistancia[i][j] != 1)
						throw new Exception("La matriz unicamente puede contener ceros y unos");

					if ((matrizDistancia[i][j] + (matrizDistancia[i][k] * matrizDistancia[k][j])) == 1) {
						matrizDistancia[i][j] = 1;
					}
					if (i == j) {
						matrizDistancia[i][j] = 0;
					}
				}
			}

		}

		return matrizDistancia;
	}

}
