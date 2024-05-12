package quicksort;

public class Main {

	public static void main(String[] args) {
		Integer[] array = { 5, 8, 2, 6, 4, 1, 3, 7, 9};
		QuicksortInt ordenador = new QuicksortInt();
		
		Integer[] arrayOrdenado = ordenador.ordenar(array);
		
		for(int i = 0; i < arrayOrdenado.length; i++) {
			System.out.println(arrayOrdenado[i]);
		}
	}

}
