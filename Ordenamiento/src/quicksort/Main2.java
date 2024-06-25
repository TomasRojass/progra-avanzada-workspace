package quicksort;

import java.util.Random;

public class Main2 {
	public static void main(String[] args) {
        //int[] lista = {69, 75, 71 ,7, 40 ,67, 25 ,23, 31 ,77 ,19 ,23};
        //65 77 88 97 10 31 16 6 28 10 
        int[] lista = new int[10];
        
        Random random = new Random();
     
        for (int i = 0; i < lista.length; i++) {
            lista[i] = random.nextInt(100);
        }
        System.out.print("miVector desordenado: ");
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
        Quicksort2.ordenar(lista,0,lista.length-1);
        System.out.print("\nmiVector ordenado: ");
        for (int i = 0; i <lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
    }
}
