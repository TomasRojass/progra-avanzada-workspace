package DivisionYConquista;

public class SumaElementosArray {
	public long sumar(Integer[] array) {
		return this.sumar(array, 0, array.length - 1);
	}
	
	private long sumar(Integer[] array, int limIzq, int limDer) {
		int actual = (limDer + limIzq) / 2 ;
		if(limDer == limIzq) {
	        return array[limDer];
		}
		
		return this.sumar(array, limIzq, actual) + this.sumar(array, actual + 1, limDer);
	}
}
