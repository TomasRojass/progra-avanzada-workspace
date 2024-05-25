package shellSort;

import java.util.ArrayList;

public class ShellSortInt implements ShellSort<Integer>{

	@Override
	public void ordenar(Integer[] lista) {
		Integer[] vectorDeDistancias = this.generoVectorDeDistancias(lista.length);
		int aux;
		for(int i = vectorDeDistancias.length - 1; i >= 0; i-- ) {
			int distancia = vectorDeDistancias[i];
			int limiteIzq = 0;
			int posicionAOrdenar;
			while(limiteIzq + distancia < lista.length) {
				posicionAOrdenar = limiteIzq + distancia;
				aux = lista[posicionAOrdenar];
				while(posicionAOrdenar - distancia >= 0 && aux < lista[posicionAOrdenar - distancia]) {
					lista[posicionAOrdenar] = lista[posicionAOrdenar - distancia];
					posicionAOrdenar -= distancia;
				}
				lista[posicionAOrdenar] = aux;
				limiteIzq ++;
			}
		}
	}
	
	private Integer[] generoVectorDeDistancias(int n) {
		ArrayList<Integer> lista = new ArrayList<>();
		for(int i = 1; i <= n; i = i * 3 + 1) {
			lista.add(i);
		}
		Integer[] retorno = lista.toArray(new Integer[0]);
		
		return retorno;
	}

}
