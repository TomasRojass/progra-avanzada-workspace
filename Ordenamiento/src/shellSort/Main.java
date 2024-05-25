package shellSort;

public class Main {

	public static void main(String[] args) {
		Integer[] array = { 5, 8, 2, 6, 4, 1, 3, 7, 9};
		ShellSortInt ordenador = new ShellSortInt();
		
		ordenador.ordenar(array);
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

}
