package Elementales;

import Entidades.Ordenamiento;

public class Insercion implements Ordenamiento {

	@Override
	public <T extends Comparable<T>> void ordenar(T[] vector) {
		for (int i = 1; i < vector.length; i++) {
			T valorActual = vector[i];
			int j = i - 1;
			while (j >= 0 && vector[j].compareTo(valorActual) > 0) {
				vector[j + 1] = vector[j];
				j--;
			}
			vector[j + 1] = valorActual;
		}
	}
	
	public void ordenar(int[] vector) {
		int llave;
		for(int i = 1;i < vector.length;i++) {
			llave = vector[i];
			int j=i-1;
			while(j>=0&&vector[j]>llave) {
				vector[j+1]= vector[j];
				vector[j]=llave;
				j--;
			}
		}
	}

}
