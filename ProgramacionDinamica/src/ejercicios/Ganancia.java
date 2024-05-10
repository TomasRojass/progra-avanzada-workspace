package ejercicios;

public class Ganancia {

	public int robarGananciaMaximaBottomUp(int[] vector) {
		
		// Casos base
		if (vector.length == 0) {
			return 0;
		} else if (vector.length == 1) {
			return vector[0];
		} else if (vector.length == 2) {
			return Math.max(vector[0], vector[1]);
		}

		// Declaro un vector de la misma longitud
		int[] vectorGanancia = new int[vector.length];
		
		// Almaceno la primera ganancia
		vectorGanancia[0] = vector[0];
		
		// Veo cual entre los primeros 2 es el que me conviene robar
		vectorGanancia[1] = Math.max(vector[0], vector[1]);

		// Me voy fijando si es que conviene quedarme con la ganancia que ya tengo y no sumarle nada
		// O si conviene agarrar la nueva + la ganancia anterior y que no puedo agarrar consecutivamente
		for (int i = 2; i < vector.length; i++) {
			vectorGanancia[i] = Math.max(vector[i] + vectorGanancia[i - 2], vectorGanancia[i - 1]);
			//System.out.println("Ganancia acumulada: " + vectorGanancia[i]);
		}

		//System.out.print("Vector Ganancia: ");
		//for(int j = 0; j < vectorGanancia.length; j++) {
		//    System.out.print(vectorGanancia[j] + (j != vectorGanancia.length - 1 ? ", " : "\n"));
		//}
		
		return vectorGanancia[vectorGanancia.length - 1];
	}
	
}
