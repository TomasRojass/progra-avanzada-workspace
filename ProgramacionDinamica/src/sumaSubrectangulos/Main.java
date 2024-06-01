package sumaSubrectangulos;

public class Main {

	public static void main(String[] args) {
		
		SumaSubrectangulos sumador = new SumaSubrectangulos();
		int[][] matriz = {
	            {-5, 3, 5, 8, 2, 1, -4},
	            {3, -8, -10, 2, -2, 5, 4},
	            {1, 8, 3, -6, 0, 9, 3},
	            {12, 7, 1, -4, -9, 5, -6},
	            {-15, 8, -12, 6, 3, -10, 3}
	        };
		
		System.out.println("Suma maxima de matriz: ");
		System.out.println("Solucion: " + sumador.calcularMaximaSumaSubrectangulo(matriz));
		System.out.println("-----------------------------------------");
	}

}
