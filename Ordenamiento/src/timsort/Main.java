package timsort;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		TimSortInt timsort = new TimSortInt();
		int[] Vector = new int[13];
        Random random = new Random();
     
        for (int i = 0; i < Vector.length; i++) {
            Vector[i] = random.nextInt(100);
        }
        System.out.print("mi Vector desordenado: ");
        for (int i = 0; i < Vector.length; i++) {
            System.out.print(Vector[i] + " ");
        }
        timsort.ordenar(Vector,0,Vector.length-1);
        System.out.print("\nmi Vector ordenado: ");
        for (int i = 0; i <Vector.length; i++) {
            System.out.print(Vector[i] + " ");
        }
	}
}
