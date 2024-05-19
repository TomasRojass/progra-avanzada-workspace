package seleccion;

public class Seleccion {
	
	public void ordenarPorSeleccion(int[] datos) {
		int n = datos.length;
		for(int i=0; i<(n-1); i++) {
			int menor = i;
			for(int j= i+1; j < n; j++) {
				if(datos[j] < datos[menor])
					menor = j;
			}
			int swap = datos[i];
			datos[i] = datos[menor];
			datos[menor] = swap;
		}
	}
}
