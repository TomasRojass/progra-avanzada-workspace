package quicksort;
import java.util.Arrays;

public class QuicksortInt implements Quicksort<Integer>{

	@Override
	public Integer[] ordenar(Integer[] lista) {
		int largo = lista.length;
		Integer[] listaOrdenada = new Integer[largo];
		int der = largo-1;
		int izq = 0;
		
		//clono array (complejidad O(n))
		listaOrdenada = Arrays.copyOf(lista, lista.length); 
		
		this.ordenarRecursivo(listaOrdenada, izq, der);
		
		return listaOrdenada;
	}
	
	private void ordenarRecursivo(Integer[] lista, int izq, int der) {
		int i = izq;
		int j = der - 1;
		int pivote;
		
		pivote = intercambioPivoteYUltimoElemento(lista, izq, der);
		do {
			//busco un elemento >= pivote
			while(i <= j && this.compareTo(lista[i], pivote) < 0) {
				i ++; 
			}
			//busco un elemento <= pivote
			while(i <= j && this.compareTo(lista[j], pivote) > 0) {
				j --;
			}
			
			if(i < j) {
				this.intercambiar(lista, i, j);
				i ++;
				j --;
			}
			
		} while (i <= j);
		
		this.intercambiar(lista, i, der); //nuevo pivote
		
		if(izq < i-1) {
			ordenarRecursivo(lista, izq, i-1);
		}
		if(der > i+1) {
			ordenarRecursivo(lista, i+1, der);
		}
		
	}
	
	private Integer intercambioPivoteYUltimoElemento(Integer[] listaAOrdenar,int izq, int der) {
		// intercambio elementos (pivote y ultimo elemento)
		this.intercambiar(listaAOrdenar, izq + Math.floorDiv(der-izq, 2), der);
		
		return listaAOrdenar[der];
	}
	
	private void intercambiar(Integer[] lista, int pos1, int pos2) {
		int aux = lista[pos1]; 
		lista[pos1] = lista[pos2];
		lista[pos2] = aux;
		
		return;
	}
	
	
	private int compareTo(Integer num1, Integer num2) {
		return num1.compareTo(num2);
	}
	
	
}
