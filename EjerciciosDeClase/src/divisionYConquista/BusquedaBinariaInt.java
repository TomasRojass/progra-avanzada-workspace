package divisionYConquista;

public class BusquedaBinariaInt implements BusquedaBinaria<Integer>{

	@Override
	public Integer buscar(Integer elemento, Integer[] lista) {
		return this.buscar(elemento, 0, lista.length - 1, lista);
	}
	
	private Integer buscar(int elemento, int limIzq, int limDer, Integer lista[]) {
		if(limDer < limIzq) {
			return -1;
		}
		int actual = (limDer - limIzq) / 2 + limIzq;
		if(lista[actual] == elemento) {
			return actual;
		}
		
		return lista[actual] > elemento ? buscar(elemento, limIzq, actual, lista): buscar(elemento, actual, limDer, lista);
	}

}
