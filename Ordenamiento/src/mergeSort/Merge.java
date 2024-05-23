package mergeSort;

public class Merge {

	public void ordenarPorMergeSort(int[] array) {
		int mitad;
		int i=0, j=0, k=0;
		if(array.length >1) {
			mitad = array.length/2;
			int[] mitadIzquierda = new int[mitad];
	        int[] mitadDerecha = new int[array.length - mitad];
	        System.arraycopy(array, 0, mitadIzquierda, 0, mitad);
	        System.arraycopy(array, mitad, mitadDerecha, 0, array.length - mitad);
	        
	        ordenarPorMergeSort(mitadIzquierda);
	        ordenarPorMergeSort(mitadDerecha);
	        
	        while( i< mitadIzquierda.length &&  j < mitadDerecha.length) {
	        	if( mitadIzquierda[i] < mitadDerecha[j]) {
	        		array[k] = mitadIzquierda[i];
	        		i++;
	        	}else {
	        		array[k] = mitadDerecha[j];
	        		j++;
	        	}
	        	k++;
	        }
	        
	        while (i < mitadIzquierda.length) {
	        	array[k] = mitadIzquierda[i];
	        	i++;
	        	k++;
	        }
	        
	        while (j < mitadDerecha.length) {
	        	array[k] = mitadDerecha[j];
	        	j++;
	        	k++;
	        }
	        
	        
		}
	}

}
