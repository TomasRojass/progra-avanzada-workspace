package Principales;

import java.util.Random;
import Elementales.Seleccion;
import NoElementales.MergeSort;
import NoElementales.QuickSortInt;
import NoElementales.ShellSort;
import NoElementales.TimSort;

public class Main {

	public static void main(String[] args) {

		int[] array = { 5, 8, 2, 6, 4, 1, 3, 7, 9 };
		Seleccion seleccion = new Seleccion();
		seleccion.ordenar(array);

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		int[] array2 = { 5, 8, 2, 6, 4, 1, 3, 7, 9 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.ordenar(array2);

		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}

		TimSort timsort = new TimSort();
		int[] Vector = new int[13];
		Random random = new Random();

		for (int i = 0; i < Vector.length; i++) {
			Vector[i] = random.nextInt(100);
		}
		System.out.print("mi Vector desordenado: ");
		for (int i = 0; i < Vector.length; i++) {
			System.out.print(Vector[i] + " ");
		}
		timsort.ordenar(Vector, 0, Vector.length - 1);
		System.out.print("\nmi Vector ordenado: ");
		for (int i = 0; i < Vector.length; i++) {
			System.out.print(Vector[i] + " ");
		}

		Integer[] array3 = { 5, 8, 2, 6, 4, 1, 3, 7, 9 };
		QuickSortInt ordenador = new QuickSortInt();

		ordenador.ordenar(array3);

		for (int i = 0; i < array3.length; i++) {
			System.out.println(array3[i]);
		}

		// int[] lista = {69, 75, 71 ,7, 40 ,67, 25 ,23, 31 ,77 ,19 ,23};
		// 65 77 88 97 10 31 16 6 28 10
		int[] lista = new int[10];

		for (int i = 0; i < lista.length; i++) {
			lista[i] = random.nextInt(100);
		}
		System.out.print("miVector desordenado: ");
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + " ");
		}
		QuickSortInt.ordenar(lista, 0, lista.length - 1);
		System.out.print("\nmiVector ordenado: ");
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + " ");
		}

		Integer[] array4 = { 5, 8, 2, 6, 4, 1, 3, 7, 9 };
		ShellSort shellSort = new ShellSort();

		shellSort.ordenar(array4);

		for (int i = 0; i < array4.length; i++) {
			System.out.println(array4[i]);
		}
	}

}
