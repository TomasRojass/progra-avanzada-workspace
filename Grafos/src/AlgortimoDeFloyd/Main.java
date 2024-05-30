package AlgortimoDeFloyd;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int I = Integer.MAX_VALUE;
		
		// PONER LAS MATRICES EN TEST
		int[][] matriz = new int[][]
				{
					{ 0, I, 2, I },
					{ 4, 0, 3, I },
					{ I, I, 0, 2 },
					{ I, 1, I, 0 }
				};
				int[][] matriz2 = new int[][]
						{
							{ 0, 8, 5 },
							{ 3, 5, I },
							{ I, 2, 0 } 
						};
			
		int[][] resultado;
		try {
			resultado = floyd(matriz2);
			System.out.println("La matriz de distancias más cortas es:");
	        for (int i = 0; i < resultado.length; i++) {
	            for (int j = 0; j < resultado[i].length; j++) {
	                if (resultado[i][j] == I) {
	                    System.out.print("I");
	                } else {
	                    System.out.print(resultado[i][j] + " ");
	                }
	            }
	            System.out.println();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

	private static int[][] floyd(int[][] matriz) throws Exception {
		int largo = matriz.length;
		int[][] matrizDistancia = new int[largo][largo];
	
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < largo; j++) {
                matrizDistancia[i][j] = matriz[i][j];
            } 
        }
        
        for (int k = 0; k < largo; k++) {

            for (int i = 0; i < largo; i++) {
            	if(matrizDistancia[i][i] !=0 ) {
            		throw new Exception("La distancia de un nodo a si mismos no puede ser distinto de cero");
            	}
                for (int j = 0; j < largo; j++) {
                	
                	if (matrizDistancia[i][k] != Integer.MAX_VALUE
							&& matrizDistancia[k][j] != Integer.MAX_VALUE
							&& (matrizDistancia[i][k] + matrizDistancia[k][j] < matrizDistancia[i][j]))
					{
                		matrizDistancia[i][j] = matrizDistancia[i][k] + matrizDistancia[k][j];
						
					}
                }
            }

        }
		
        return matrizDistancia;
	}

}
