package seleccion;

public class Main {

	public static void main(String[] args) {
		int[] array = { 5, 8, 2, 6, 4, 1, 3, 7, 9};
		Seleccion ordenador = new Seleccion();
		
		ordenador.ordenarPorSeleccion(array);
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

}
