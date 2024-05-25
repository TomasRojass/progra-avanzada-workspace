package insercion;

public class Insercion {
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
