package mergeSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 5, 8, 2, 6, 4, 1, 3, 7, 9};
		Merge ordenador = new Merge();
		
		ordenador.ordenarPorMergeSort(array);
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
