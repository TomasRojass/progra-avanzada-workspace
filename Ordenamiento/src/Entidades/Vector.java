package Entidades;

public abstract class Vector {

	public static <T> void intercambiar(T[] vector, int primerIndice, int segundoIndice) {
		T temporal = vector[primerIndice];
		vector[primerIndice] = vector[segundoIndice];
		vector[segundoIndice] = temporal;
	}

	public static <T> void mostrarVector(T[] vector) {
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + (i < vector.length - 1 ? " " : "\n"));
		}
	}

	public static void mostrarVector(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + (i < vector.length - 1 ? " " : "\n"));
		}
	}

}
